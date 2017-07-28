package com.arjun.appdirect.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.arjun.appdirect.model.web.UserProfile;
import com.arjun.appdirect.service.UserService;


@RestController
@RequestMapping("/appdirect")
public class AppDirectController {

   /** @AutowiredLogger
    Logger log;
	**/
	
    @Autowired
    AppDirectHandler appDirectClient;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/subscription/create")
    public EventResult createSubscription(HttpServletRequest request,
            @RequestParam String url,
            @RequestParam String token,
            @AuthenticationPrincipal ConsumerAuthentication authentication) {

        //logRequest(request, authentication);

        GetSubscriptionOrderEventAction action = new GetSubscriptionOrderEventAction(appDirectClient);
        action.setUrl(url);
        action.setToken(token);
        ActionResult<SubscriptionOrderEvent> actionResult = action.execute();

        SubscriptionOrderEvent event = actionResult.getEntity();
        User user = event.getCreator();

        UserProfile profile = userService.createProfile(user);

        // return result XML
        EventResult result = new EventResult();
        result.setAccountIdentifier("eheiker-appdirect");
        result.setMessage("Welcome to AppDirect!");
        result.setSuccess(profile != null);

        return result;
    }

    
    @RequestMapping("/subscription/cancel")
    public EventResult cancelSubscription(HttpServletRequest request,
            @RequestParam String url,
            @RequestParam String token,
            @AuthenticationPrincipal ConsumerAuthentication authentication) {

       // logRequest(request, authentication);

        // get event details
        GetSubscriptionCancelEventAction action = new GetSubscriptionCancelEventAction(appDirectClient);
        action.setUrl(url);
        action.setToken(token);
        SubscriptionCancelEvent event = action.execute().getEntity();

        //TODO: delete all accounts in system tied to this accountId

        // return result XML
        EventResult result = new EventResult();
        result.setMessage(event.toString());
        result.setSuccess(true);

        return result;
    }
    
    /**

    @RequestMapping("/user/assign")
    public EventResult assignUser(HttpServletRequest request,
            @RequestParam String url,
            @RequestParam String token,
            @AuthenticationPrincipal ConsumerAuthentication authentication) {

        logRequest(request, authentication);

        // get event details
        GetUserAssignedEventAction action = new GetUserAssignedEventAction(appDirectClient);
        action.setUrl(url);
        action.setToken(token);
        UserAssignedEvent event = action.execute().getEntity();
        UserProfile user = event.getPayload().getUser();

        Profile profile = userService.createProfile(user);

        // return result XML
        EventResult result = new EventResult();
        result.setMessage(event.toString());
        result.setSuccess(profile != null);

        return result;
    }

    @RequestMapping("/user/unassign")
    public EventResult unassignUser(HttpServletRequest request,
            @RequestParam String url,
            @RequestParam String token,
            @AuthenticationPrincipal ConsumerAuthentication authentication) {

        logRequest(request, authentication);

        // get event details
        GetUserUnassignedEventAction action = new GetUserUnassignedEventAction(appDirectClient);
        action.setUrl(url);
        action.setToken(token);
        UserUnassignedEvent event = action.execute().getEntity();

        String openId = event.getPayload().getUser().getOpenId();
        Profile profile = profileService.getByOpenID(openId);

        boolean deleted = true;
        if (profile != null) {
            profileService.delete(profile.getId());
            deleted = !profileService.exists(profile.getId());
        }

        // return result XML
        EventResult result = new EventResult();
        result.setMessage(event.toString());
        result.setSuccess(deleted);

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
    } **/
}
