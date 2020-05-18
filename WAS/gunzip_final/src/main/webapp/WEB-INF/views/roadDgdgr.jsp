<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>도로위험도지수</title>
	<script>
		var xhr = new XMLHttpRequest();
		var url = 'http://apis.data.go.kr/B552061/roadDgdgrLink/getRestRoadDgdgrLink'; /*URL*/
		var queryParams = '?' + encodeURIComponent('ServiceKey') + '='+'ZtdZwa%2FHIEL1O0xwoQ96aLM9AQLpJfdqWxiNoEEbg8t4b3XyY5pqbmY5s864FPRt1WiarbQZ%2FTWr%2B5%2FQn3tCsA%3D%3D'; /*Service Key*/
		queryParams += '&' + encodeURIComponent('ServiceKey') + '=' + encodeURIComponent('ZtdZwa%2FHIEL1O0xwoQ96aLM9AQLpJfdqWxiNoEEbg8t4b3XyY5pqbmY5s864FPRt1WiarbQZ%2FTWr%2B5%2FQn3tCsA%3D%3D'); /**/
		queryParams += '&' + encodeURIComponent('searchLineString') + '=' + encodeURIComponent('LineString(127.92136742775328 37.326002556009065, 127.92102024291988 37.32579424030431)'); /**/
		queryParams += '&' + encodeURIComponent('vhctyCd') + '=' + encodeURIComponent('4'); /**/
		queryParams += '&' + encodeURIComponent('type') + '=' + encodeURIComponent('json'); /**/
		queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
		queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
		xhr.open('GET', url + queryParams);
		xhr.onreadystatechange = function () {
		    if (this.readyState == 4) {
		        alert('Status: '+this.status+'nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+'nBody: '+this.responseText);
		    }
		};
	
		xhr.send('');
	</script>
	
</head>
<body>

</body>
</html>