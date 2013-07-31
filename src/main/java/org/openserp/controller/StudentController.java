package org.openserp.controller;

import java.security.Principal;
import java.util.Map;

import javax.annotation.Resource;

import org.openserp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

	@Resource(name = "studentService")
	private StudentService studentService;

	public void setUserService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/student/list/main")
	public ModelAndView mainPage(ModelAndView modelAndView, Principal principal) {

		//studentService.getStudentList(firstResult, maxResults);
		
		Map<String, Object> model = modelAndView.getModel();
		model.put("username", principal.getName());
		modelAndView.setViewName("student");

		return modelAndView;
	}

}
