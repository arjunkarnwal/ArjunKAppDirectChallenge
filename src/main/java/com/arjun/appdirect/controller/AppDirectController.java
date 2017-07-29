package com.arjun.appdirect.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth.provider.ConsumerAuthentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arjun.appdirect.action.ActionResult;
import com.arjun.appdirect.action.GetSubscriptionCancelEventAction;
import com.arjun.appdirect.action.GetSubscriptionOrderEventAction;
import com.arjun.appdirect.action.GetUserAssignedEventAction;
import com.arjun.appdirect.action.GetUserUnassignedEventAction;
import com.arjun.appdirect.handler.AppDirectHandler;
import com.arjun.appdirect.model.User;
import com.arjun.appdirect.model.event.EventResult;
import com.arjun.appdirect.model.event.subscription.SubscriptionCancelEvent;
import com.arjun.appdirect.model.event.subscription.SubscriptionOrderEvent;
import com.arjun.appdirect.model.event.user.UserAssignedEvent;
import com.arjun.appdirect.model.event.user.UserUnassignedEvent;
import com.arjun.appdirect.model.web.UserProfile;
import com.arjun.appdirect.service.UserService;


@RestController
@RequestMapping("/appdirect")
public class AppDirectController {
	
	private static Logger log = LoggerFactory.getLogger(AppDirectController.class);
    
	@Autowired
    AppDirectHandler appDirectHandler;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/subscription/create")
    public EventResult createSubscription(HttpServletRequest request,
            @RequestParam String url,
            @RequestParam String token,
            @AuthenticationPrincipal ConsumerAuthentication authentication) {

        logRequest(request, authentication);

        GetSubscriptionOrderEventAction action = new GetSubscriptionOrderEventAction(appDirectHandler, url, token);
        ActionResult<SubscriptionOrderEvent> actionResult = action.execute();

        SubscriptionOrderEvent event = actionResult.getEntity();
        User user = event.getCreator();

        UserProfile profile = userService.createProfile(user);

        // return result XML
        return getResult("Welcome to AppDirect!", profile != null, "arjunk");
    }

    
    @RequestMapping("/subscription/cancel")
    public EventResult cancelSubscription(HttpServletRequest request,
            @RequestParam String url,
            @RequestParam String token,
            @AuthenticationPrincipal ConsumerAuthentication authentication) {

        logRequest(request, authentication);

        // get event details
        GetSubscriptionCancelEventAction action = new GetSubscriptionCancelEventAction(appDirectHandler, url, token);
        SubscriptionCancelEvent event = action.execute().getEntity();
        String openId = event.getCreator().getOpenId();
        UserProfile profile = userService.getByOpenID(openId);
        //TODO: delete all accounts in system tied to this accountId
        boolean deleted = true;
        if (profile != null) {
        		userService.delete(profile.getId());
            deleted = !userService.exists(profile.getId());
        }

        // return result XML
        return getResult(event.toString(), deleted, null);
    }
    
    

    @RequestMapping("/user/assign")
    public EventResult assignUser(HttpServletRequest request,
            @RequestParam String url,
            @RequestParam String token,
            @AuthenticationPrincipal ConsumerAuthentication authentication) {

        logRequest(request, authentication);

        // get event details
        GetUserAssignedEventAction action = new GetUserAssignedEventAction(appDirectHandler, url, token);
        UserAssignedEvent event = action.execute().getEntity();
        User user = event.getPayload().getUser();

        UserProfile profile = userService.createProfile(user);

        // return result XML
        return getResult(event.toString(), profile != null, null);
    }
    
    @RequestMapping("/user/unassign")
    public EventResult unassignUser(HttpServletRequest request,
            @RequestParam String url,
            @RequestParam String token,
            @AuthenticationPrincipal ConsumerAuthentication authentication) {

        logRequest(request, authentication);

        // get event details
        GetUserUnassignedEventAction action = new GetUserUnassignedEventAction(appDirectHandler, url, token);
        UserUnassignedEvent event = action.execute().getEntity();

        String openId = event.getPayload().getUser().getOpenId();
        UserProfile profile = userService.getByOpenID(openId);

        boolean deleted = true;
        if (profile != null) {
        		userService.delete(profile.getId());
            deleted = !userService.exists(profile.getId());
        }

        // return result XML
        return getResult(event.toString(), deleted, null);
    }
    
    private EventResult getResult(final String message, final boolean isSuccess, final String accountIdentifier) {
    		EventResult result = new EventResult();
    		result.setAccountIdentifier(accountIdentifier);
        result.setMessage(message);
        result.setSuccess(isSuccess);
        return result;
    }
    
   
    
    private void logRequest(HttpServletRequest request, ConsumerAuthentication authentication) {
        if (log.isDebugEnabled()) {
            log.debug("request = " + request.getRequestURI() + "?" + request.getQueryString());
            if (authentication != null) {
                log.debug("authenticated = " + authentication.isAuthenticated());
                log.debug("signature validated = " + authentication.isSignatureValidated());
            } else {
                log.debug("Request not authenticated");
            }
        }
    } 
}
