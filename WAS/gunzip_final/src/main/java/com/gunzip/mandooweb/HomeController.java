package com.gunzip.mandooweb;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index() {
		
		return "index";
	}
	@RequestMapping(value = "/index2.do", method = RequestMethod.GET)
	public String index2() {
		
		return "index2";
	}
	@RequestMapping(value = "/index3.do", method = RequestMethod.GET)
	public String index3() {
		
		return "index3";
	}
}