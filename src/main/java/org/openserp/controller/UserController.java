package org.openserp.controller;

import java.security.Principal;
import java.util.Map;

import javax.annotation.Resource;

import org.openserp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Resource(name = "userService")
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/user/list/main")
	public ModelAndView mainPage(ModelAndView modelAndView, Principal principal) {

		// setup the user details for display

		Map<String, Object> model = modelAndView.getModel();
		model.put("username", principal.getName());
		modelAndView.setViewName("user");

		return modelAndView;
	}

}
