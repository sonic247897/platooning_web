package com.gunzip.mongodb;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class mongoController {
	@Autowired
	mongoService service;
	@RequestMapping(value="/mongo/insert.do", method=RequestMethod.POST, produces= {"application/json"})
	public String insertData(HttpServletRequest req) {
		String userid = "";
		String carnum = "";
		
		try {
			InputStream in = req.getInputStream();
			InputStreamReader ir = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(ir);
			String msg = br.readLine();
			System.out.println("==>"+msg);
			userid = "";
			carnum = "";
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("insert");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
		String datestr = sdf.format(cal.getTime());
		mongoDTO dto = new mongoDTO();
		dto.setUserid(userid);
		dto.setCarnum(carnum);
		dto.setSaveDate(datestr);
		service.insert(dto);
		return "hello";
	}
	
	@RequestMapping(value="/mongo/select.do", method=RequestMethod.GET, produces= {"application/json"})
	public String selectData() {
		mongoDTO dto = new mongoDTO();
		System.out.println(service.select(dto));
		return "index";
	}
	
}
