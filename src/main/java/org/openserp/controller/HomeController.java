package org.openserp.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	@RequestMapping(value="/home")
	public ModelAndView home(ModelAndView modelAndView, Principal principal){
		//setup the user details for display
		Map<String, Object> model = modelAndView.getModel();
		model.put("username", principal.getName());
		modelAndView.setViewName("home");
		return modelAndView;
	}
}
