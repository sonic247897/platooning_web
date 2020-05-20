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
	
	
	@RequestMapping(value = "/roadDgdgr.do", method = RequestMethod.GET)
	public ModelAndView roadDgdgr(){
		ModelAndView mav = new ModelAndView();
		StringBuilder sb = null;
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552061/roadDgdgrHighway/getRestRoadDgdgrHighway"); /*URL*/
        try {
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZtdZwa%2FHIEL1O0xwoQ96aLM9AQLpJfdqWxiNoEEbg8t4b3XyY5pqbmY5s864FPRt1WiarbQZ%2FTWr%2B5%2FQn3tCsA%3D%3D");
	        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("ZtdZwa%2FHIEL1O0xwoQ96aLM9AQLpJfdqWxiNoEEbg8t4b3XyY5pqbmY5s864FPRt1WiarbQZ%2FTWr%2B5%2FQn3tCsA%3D%3D", "UTF-8")); /*공공데이터포털에서 발급받은 인증키*/
	        urlBuilder.append("&" + URLEncoder.encode("frwyNm","UTF-8") + "=" + URLEncoder.encode("경부고속도로", "UTF-8")); /*고속도로명*/
	        urlBuilder.append("&" + URLEncoder.encode("frwySctnNm","UTF-8") + "=" + URLEncoder.encode("판교IC-신갈JC", "UTF-8")); /*고속도로구간명(IC, JC구간)*/
	        urlBuilder.append("&" + URLEncoder.encode("vhctyCd","UTF-8") + "=" + URLEncoder.encode("01", "UTF-8")); /*차량종류코드(01:승용차, 02:버스, 03:택시, 04:화물차)*/
	        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*결과형식(xml/json)*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*검색건수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
        } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
        mav.addObject("api", sb.toString());
        mav.setViewName("roadDgdgr");
		return mav;
	}
	
	@RequestMapping(value = "/map.do", method = RequestMethod.GET)
	public String map() {
		return "map";
	}

	
}