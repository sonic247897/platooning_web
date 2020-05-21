<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<script
src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appkey=l7xxc04b74e7bc0940dabf45e6cbfcd31748"></script>
<script type="text/javascript">
	$(function() {
	   initTmap();
	   changeLoad(3);
	   
	});

	var map;
	//현재위치를 그릴 레이어 변수
	var markerLayer;
	//현재위치의 바로 이전위치를 그릴 레이어 변수
	var beforeMarkerLayer;
	//위치관제를 위한 변수
	var myVar;
	var markerList = [];
	var beforeMarkerList = [];
	var pointArray = [];

	function initTmap(){
	   
	    // 1. 지도 띄우기
	   map = new Tmapv2.Map("map_div", {
	      center: new Tmapv2.LatLng(37.57004566771894,126.97682516925155),
	      width: "100%",
	      height: "400px"
	   });
	   map.setZoom(15);
	   /* //현재위치의 바로 이전위치를 그릴 레이어 생성
	   beforeMarkerLayer = new Tmap.Layer.Markers();
	   //현재위치를 그릴 레이어 생성
	   markerLayer = new Tmap.Layer.Markers(); */
	   
	}

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
	
	
	
		
	function myFunction(cnt, checkLevel){
	    $intRate.each(function(index, element) {
	       var name = element.getElementsByTagName("name")[0].childNodes[0].nodeValue;
	       var number = element.getElementsByTagName("number")[0].childNodes[0].nodeValue;
	       var affiliation = element.getElementsByTagName("affiliation")[0].childNodes[0].nodeValue;
	       var distance = element.getElementsByTagName("distance")[cnt].childNodes[0].nodeValue;
	       var speed = element.getElementsByTagName("speed")[cnt].childNodes[0].nodeValue;
	       var content = 
	                '<div class="wrap">' + 
	                   '    <div class="info">' + 
	                   '        <div class="title">' + 
	                   '            '+name + 
	                   '        </div>' + 
	                   '        <div class="body">' + 
	                   '            <div class="desc">' + 
	                   '                <div><span>차량번호</span> '+number+'</div>' +  
	                   '                <div><span>소속지사</span> '+affiliation+'</div>' + 
	                   '                <div><span>운행거리</span> '+distance+'km</div>' + 
	                   '                <div><span>현재속도</span> '+speed+'km/h</div>' + 
	                   '            </div>' + 
	                   '        </div>' + 
	                   '    </div>' +     
	                   '</div>';
	       
	       //현재위치 바로 이전 위치를 그리기 위한 부분
	       if(cnt > 0 && cnt >= 1 && cnt < 42 && checkLevel != 4){
	          //현재위치 갱신후 이전위치에 있던 마커 삭제
	          //markerLayer.clearMarkers();
	          
	          var beforePoint = element.getElementsByTagName("coordinates")[cnt-1].childNodes[0].nodeValue.split(',');
	          var beforeIcon = '/gunzip_final/dist/img/before_car.png';
	          //var beforeLonlat = new Tmap.LonLat(beforePoint[0],beforePoint[1]).transform("EPSG:4326", "EPSG:3857");
	          //beforeMarker = new Tmap.Marker(beforeLonlat, beforeIcon);
	          beforeMarker = new Tmapv2.Marker({
	            position: new Tmapv2.LatLng(beforePoint[1]*=1,beforePoint[0]*= 1),
	            icon: beforeIcon,
	            map: map
	         });
	          beforeMarkerList.push(beforeMarker);
	          
	       }
	       
	       var point = element.getElementsByTagName("coordinates")[cnt].childNodes[0].nodeValue.split(',');
	      var icons = '/gunzip_final/dist/img/pin_car.png';
	     
	      marker = new Tmapv2.Marker({
	            position: new Tmapv2.LatLng(point[1]*=1,point[0]*= 1),
	            icon: icons,
	            map: map
	         });
	          markerList.push(marker);
	          map.setCenter(new Tmapv2.LatLng(point[1]*=1,point[0]*= 1));
	          
	    });
	    
	}

	//위치 관제 총 4단계 -> 단계별로 진행을 위한 함수
	function changeLoad(checkLevel){
	   
	 
	   //위치 관제 시작을 선택했을 경우
	   if(checkLevel==3||checkLevel>=3){
		   
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
			var number = $intRate.find("number");
		   
			console.log("마커리스트 : "+markerList);
		    console.log("비포마커리스트 : "+beforeMarkerList);
	      //result창에 있는 내용 제거
	      var result = "";
	      var resultDiv = document.getElementById("result");
	      resultDiv.innerHTML = result;
	     
	      
	      // 3. 위치 관제 시작
	      var cnt = 1;
	      myVar = setInterval(function(){
	         //markerLayer.clearMarkers();
	         RESET_MARKER();
	         var count = $xml.find("Placemark")[0].getElementsByTagName("coordinates").length;
	         console.log(count);
	         if(cnt == count){
	            cnt = 0;
	            RESET_MARKER();
	            RESET_MARKER2();
	            //markerLayer.clearMarkers();
	            //beforeMarkerLayer.clearMarkers();
	         }
	         myFunction(cnt); 
	         cnt++;
	      }, 1000);
		
	   }
	   
	}
	
	</script>


</head>
<body>

<div id="map_div"
style="width: 100%; height: 100%; border: 1px; border-style: solid; border-color: blue"></div>
<p id="result" />
</body>
</html>