package com.mjk.thymeleafTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mjk.thymeleafTest.dao.UserDAO;
import com.mjk.thymeleafTest.domain.UserVO;

@Controller
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	@GetMapping("/signup.do")
	public ModelAndView signup(@ModelAttribute UserVO user) {
		return new ModelAndView("page/signup");
	}
	
	@PostMapping("/inProc.do")
	public String inProc(UserVO user) {
		userDAO.signUpProc(user);
		return "redirect:/signup.do";
	}
	@GetMapping("/userAll")
	public String userAll(Model model) {
		model.addAttribute("userList", userDAO.userAll());
		return "page/userAll";
	}
	
	@GetMapping("/userSelect")
	public String userSelect(Model model, String id) {
		
		id="kim123";
		model.addAttribute("userList", userDAO.userSelect(id));
		return "page/userAll";
	}
}
