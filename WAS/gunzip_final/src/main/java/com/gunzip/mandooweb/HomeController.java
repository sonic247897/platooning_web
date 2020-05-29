package com.gunzip.mandooweb;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
		/*// XML 문서 파싱
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("sample.kml");
				
		// root 구하기
		Element root = document.getDocumentElement();
				
		// root의 속성
		System.out.println("class name: " + root.getAttribute("name"));
				
		NodeList childeren = root.getChildNodes(); // 자식 노드 목록 get
		for(int i = 0; i < childeren.getLength(); i++){
			Node node = childeren.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){ // 해당 노드의 종류 판정(Element일 때)
				Element ele = (Element)node;
				String nodeName = ele.getNodeName();
				System.out.println("node name: " + nodeName);
				if(nodeName.equals("teacher")){
					System.out.println("node attribute: " + ele.getAttribute("name"));
				}
				else if(nodeName.equals("student")){
					// 이름이 student인 노드는 자식노드가 더 존재함
					NodeList childeren2 = ele.getChildNodes();
					for(int a = 0; a < childeren2.getLength(); a++){
						Node node2 = childeren2.item(a);
						if(node2.getNodeType() == Node.ELEMENT_NODE){
							Element ele2 = (Element)node2;
							String nodeName2 = ele2.getNodeName();
							System.out.println("node name2: " + nodeName2);
							System.out.println("node attribute2: " + ele2.getAttribute("num"));
						}
					}
				}
			}
		}*/
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
	
	
	
	// TODO: 현정 ============================================================

	
	@RequestMapping(value="/web/score.do",
			method=RequestMethod.GET,
			produces="application/json;charset=utf-8") //json으로 변환해달라
	public @ResponseBody String dangerScore(String beforePoint0, String beforePoint1, String point0, String point1) {
		String score = ApiExplorer.readJson(beforePoint0, beforePoint1, point0, point1);
		System.out.println("위험도지수: "+score);
		return score;
	}
	
	
	@RequestMapping(value = "/speed.do", method = RequestMethod.GET)
	public String speed() {
		return "speed";
	}
	
	

	
	@RequestMapping(value = "/map.do", method = RequestMethod.GET)
	public String map() {
		return "map";
	}

	
	@RequestMapping(value = "/map_test.do", method = RequestMethod.GET)
	public String map_test() {
		return "map_test";
	}
	
	// 칠곡물류IC - 왜관IC (구글 지도 좌표) 15포인트
	@RequestMapping(value = "/map_test2.do", method = RequestMethod.GET)
	public String map_test2() {
		return "map_test2";
	}
	
	
	 

	
}