package com.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class HomeController {

	private String HOME_VIEW_COUNT = "HOME_VIEW_COUNT";

	@GetMapping("/")
	String hello(Principal principal, HttpSession session) {
		incrementCount(session, HOME_VIEW_COUNT);
		return "Hello, " + principal.getName();
	}

	@GetMapping("/count")
	String getCount(HttpSession session) {
		return "HOME_VIEW_COUNT : " + session.getAttribute(HOME_VIEW_COUNT);
	}

	private void incrementCount(HttpSession session, String attr) {
		Integer homeViewCount = session.getAttribute(attr) == null ? 0 : (Integer) session.getAttribute(attr);
		session.setAttribute(HOME_VIEW_COUNT, homeViewCount += 1);

	}
}
