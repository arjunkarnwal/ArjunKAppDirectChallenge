package com.arjun.appdirect.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.openid.OpenIDAuthenticationStatus;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arjun.appdirect.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    
    
    @RequestMapping(value = "/appDirectUser", method = RequestMethod.GET)
    public String showCurrentUser(Model model, OpenIDAuthenticationToken authentication) {
       model.addAttribute("authentication", authentication);
       model.addAttribute("authenticated", authentication != null ? OpenIDAuthenticationStatus.SUCCESS.equals(authentication.getStatus()) : Boolean.FALSE);
       return "appDirectUser";
    }

    @RequestMapping(value = "/appDirectUsers", method = RequestMethod.GET)
    public String showAllUsers(Model model, OpenIDAuthenticationToken authentication) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("authenticated", authentication != null ? OpenIDAuthenticationStatus.SUCCESS.equals(authentication.getStatus()) : Boolean.FALSE);
        return "appDirectUsers";
    }
    
	@RequestMapping("/")
    public String index(Model model, OpenIDAuthenticationToken authentication) {
        model.addAttribute("authenticated", authentication != null ? OpenIDAuthenticationStatus.SUCCESS.equals(authentication.getStatus()) : Boolean.FALSE);
        return "index";
    }

}
