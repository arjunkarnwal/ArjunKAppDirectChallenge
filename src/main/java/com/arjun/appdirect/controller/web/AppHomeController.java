package com.arjun.appdirect.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppHomeController {
	
	@RequestMapping("/")
    public String index(Model model) {
       // model.addAttribute("authenticated", authentication != null ? OpenIDAuthenticationStatus.SUCCESS.equals(authentication.getStatus()) : Boolean.FALSE);
        return "index";
    }
}
