package com.unlilearning.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String displayLoginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		String errorMsg = null;
		if (error != null) {
			errorMsg = "Username or Password is incorrect!";
		}
		if (logout != null) {
			errorMsg = "You have been logout successfully!";
		}

		model.addAttribute("errorMessage", errorMsg);

		return "login";
	}

	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "redirect:/login?logout=true";
	}
}
