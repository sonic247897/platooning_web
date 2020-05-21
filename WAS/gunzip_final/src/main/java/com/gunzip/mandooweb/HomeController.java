package com.gunzip.mandooweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gunzip.admin.AdminDTO;
import com.gunzip.admin.AdminService;

@Controller
public class HomeController {
	@Autowired
	AdminService service;
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String adminLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/index.do", method = RequestMethod.POST)
	public String indexPOST(AdminDTO dto, HttpServletRequest req) {
		//System.out.println(req);
		//System.out.println(dto.getid()+","+dto.getPassword());
		//System.out.println(service.toString());
		AdminDTO result = service.login(dto);
		if(result==null) {
			return "login";
		}else {
			return "index";
		}
	}
	
	
	
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
	
	

	
	@RequestMapping(value = "/map.do", method = RequestMethod.GET)
	public String map() {
		return "map";
	}

	
	@RequestMapping(value = "/map_test.do", method = RequestMethod.GET)
	public String map_test() {
		return "map_test";
	}
	
}