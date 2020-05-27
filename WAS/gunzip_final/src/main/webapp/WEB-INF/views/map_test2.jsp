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
	   
	   
	});
	function initTmap(){
		// map 생성
		// Tmapv2.Map을 이용하여, 지도가 들어갈 div, 넓이, 높이를 설정합니다.
		map = new Tmapv2.Map("map_div",  // "map" : 지도가 표시될 div의 id
		{
			center: new Tmapv2.LatLng(35.9571106,128.4550672), // 지도 초기 좌표
			width: "100%", // map의 width 설정
			height: "400px" // map의 height 설정
		});

		// 칠곡물류IC - 왜관IC (구글 지도 좌표)
        var polyline = new Tmapv2.Polyline({
            path: [
           
            	new Tmapv2.LatLng(35.9571106,128.4550672),
            	new Tmapv2.LatLng(35.9588822,128.4547668),
            	new Tmapv2.LatLng(35.9608622,128.4543806),
            	new Tmapv2.LatLng(35.9633979,128.4536081),
            	new Tmapv2.LatLng(35.9653431,128.4525781),
            	new Tmapv2.LatLng(35.9666977,128.4507757),
            	new Tmapv2.LatLng(35.9674618,128.4494453),
            	new Tmapv2.LatLng(35.968608,128.4475141),
            	new Tmapv2.LatLng(35.9698236,128.4450679),
            	new Tmapv2.LatLng(35.9712824,128.4424501),
            	new Tmapv2.LatLng(35.9722896,128.4406477),
            	new Tmapv2.LatLng(35.9732621,128.4388023),
            	new Tmapv2.LatLng(35.9742346,128.4366136),
            	new Tmapv2.LatLng(35.9753112,128.4348541),
            	new Tmapv2.LatLng(35.9769435,128.4328371)
            	
            	],
            strokeColor: "#dd00dd",
            strokeWeight: 6,
            map: map
        });
	}


	
	</script>


</head>
<body>

<div id="map_div"
style="width: 100%; height: 100%; border: 1px; border-style: solid; border-color: blue"></div>
<p id="result" />
</body>
</html>