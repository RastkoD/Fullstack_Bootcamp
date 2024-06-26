package com.iktpreobuka.testing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iktpreobuka.testing.services.GreetingService;

@Controller
public class GreetingController {
	
	@Autowired
	private GreetingService service;
	
	@RequestMapping("/greeting")
	public @ResponseBody String greeting() {
		return service.greet();
	}
}
