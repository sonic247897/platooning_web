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
		Document document = documentBuilder.parse("kml/sample.kml");
				
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
	
	
	
	// TODO: 현정=====================================================
	
	// Ajax로 계산한 도로위험도지수 데이터를 요청하는 메소드
	//	=> 컨트롤러 메소드처럼 ModelAndView를 리턴하지 않고 일반 메소드처럼
	//	  조회한 데이터를 ArrayList로 리턴하면 jackson라이브러리가 자동으로
	//	 ArrayList<BoardVO>를 json으로 변환해서 리턴해준다.
		
	// ModelAndView를 리턴하면 DispatcherServlet이 페이지 위에서 아래부터 로딩
	// ResponseBody를 명시한 ArrayList를 json형식으로 일부만 로딩해줌
	// (나머지는 같고 '컨트롤러 단'과 '뷰의 요청, 출력 부분'만 바꿔주면 된다)
	int idx =0;
	
	@RequestMapping(value="/score/danger_score.do",
				method=RequestMethod.GET,
				produces="application/json;charset=utf-8") //json으로 변환해달라
	public @ResponseBody String dangerScore(String category) {
			// XML 읽어서 리스트에 저장하고 jsp에서 dangerScore 요청할 때마다
			// score = getResponseMessage(), 배열 idx++ [static 변수? 모듈러 연산 해줘야함]
			// 그러면 3초 sleep 안해줘도 됨
			String score = "";
			//score =  
			
			
			++idx;
			idx  = idx % 15;
			
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