<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xxc04b74e7bc0940dabf45e6cbfcd31748"></script>
<!-- <style type="text/css">
/* 거리표시 팝업*/
.mPop {
	border: 1px;
	background-color: #FFF;
	font-size: 12px;
	border-color: #FF0000;
	border-style: solid;
	text-align: center;
}
/*공통사용 클래스*/
.mPopStyle {
	border: 1px;
	background-color: #FFF;
	font-size: 12px;
	border-color: #FF0000;
	border-style: solid;
	text-align: left;
}
</style> -->
<script type="text/javascript">
	//var map;
	var markerList = [];
	var beforeMarkerList = [];
	
	function initMap(){
		
		map = new Tmapv2.Map("map_div", {
			center: new Tmapv2.LatLng(37.57004566771894,126.97682516925155),
			width: "100%",
			height: "400px"
			});
		map.setZoom(15);
		
		
		// 2. 위치 조회
		if(window.XMLHttpRequest){
		xhttp=new XMLHttpRequest();
		}else{
		xhttp=new ActiveXObject("Microsoft.XMLDOM");
		}
		
		xhttp.open("GET","/gunzip_final/kml/sample.kml",false);
		xhttp.send();
		var prtcl = xhttp.responseXML;
		var marker;
		var beforeMarker;
		var popup,popup2;
		var beforePopup,beforePopup2;
		var prtclString = new XMLSerializer().serializeToString(prtcl);//xml to String
		xmlDoc = $.parseXML( prtclString ),
		$xml = $( xmlDoc ),
		$intRate = $xml.find("Placemark");
		function myFunction(cnt, checkLevel){
		$intRate.each(function(index, element) {
		var name = element.getElementsByTagName("name")[0].childNodes[0].nodeValue;
		var number = element.getElementsByTagName("number")[0].childNodes[0].nodeValue;
		var affiliation = element.getElementsByTagName("affiliation")[0].childNodes[0].nodeValue;
		var distance = element.getElementsByTagName("distance")[cnt].childNodes[0].nodeValue;
		var speed = element.getElementsByTagName("speed")[cnt].childNodes[0].nodeValue;
		var content =
		'<div class="wrap">' +
		' <div class="info">' +
		' <div class="title">' +
		' '+name +
		' </div>' +
		' <div class="body">' +
		' <div class="desc">' +
		' <div><span>차량번호</span> '+number+'</div>' +
		' <div><span>소속지사</span> '+affiliation+'</div>' +
		' <div><span>운행거리</span> '+distance+'km</div>' +
		' <div><span>현재속도</span> '+speed+'km/h</div>' +
		' </div>' +
		' </div>' +
		' </div>' +
		'</div>';
		 
		//현재위치 바로 이전 위치를 그리기 위한 부분
		if(cnt > 0 && cnt >= 1 && cnt < 42 && checkLevel != 4){
		
		var beforePoint = element.getElementsByTagName("coordinates")[cnt-1].childNodes[0].nodeValue.split(',');
		var beforeIcon = '/gunzip_final/dist/img/before_car.png';
		beforeMarker = new Tmapv2.Marker({
		position: new Tmapv2.LatLng(beforePoint[1]=1,beforePoint[0]= 1),
		icon: beforeIcon,
		map: map
		});
		beforeMarkerList.push(beforeMarker);
		
		       }
		var point = element.getElementsByTagName("coordinates")[cnt].childNodes[0].nodeValue.split(',');
		var icons = '/gunzip_final/dist/img/pin_car.png';
		marker = new Tmapv2.Marker({
		position: new Tmapv2.LatLng(point[1]=1,point[0]= 1),
		icon: icons,
		map: map
		});
		markerList.push(marker);
		});
		}
		
		//myFunction(0); - checkLevel 변수가 없다고 에러나서 주석처리함
		
		// 3. 위치 관제 시작
		var cnt = 1;
		myVar = setInterval(function(){
		RESET_MARKER();
		var count = $xml.find("Placemark")[0].getElementsByTagName("coordinates").length;
		console.log(count);
		if(cnt == count){
		cnt = 0;
		RESET_MARKER(); //기존 마크지우기
		RESET_MARKER2(); //이전 마크 지우기
		}
		myFunction(cnt);
		cnt++;
		}, 1000);
		function RESET_MARKER(){
		for (var i = 0; i < markerList.length; i++) {
		if(undefined != markerList[i]){
		markerList[i].setMap(null);
		
		if(i == markerList.length-1){
		markerList = [];
		}
		}
		}
		}
		function RESET_MARKER2(){
		for (var i = 0; i < beforeMarkerList.length; i++) {
		if(undefined != beforeMarkerList[i]){
		beforeMarkerList[i].setMap(null);
		
		if(i == beforeMarkerList.length-1){
		beforeMarkerList = [];
		}
		}
		}
		}
		
		// 4. 위치 관제 종료
		clearTimeout(myVar);
		markerList=[];
		RESET_MARKER2();
		var lastIndex = $intRate.find("coordinates").length-1;
		myFunction(lastIndex,0);
		
		var result ='총 거리 : 4.412km 총 소요시간 : 22분 ';
		var resultDiv = document.getElementById("result");
		resultDiv.innerHTML = result;
	
	}
	</script>
</head>
<body onload="initMap();">
	<div id="map_div"
		style="width: 100%; height: 100%; border: 1px; border-style: solid; border-color: blue"></div>
	<p id="result" />
</body>
</html>