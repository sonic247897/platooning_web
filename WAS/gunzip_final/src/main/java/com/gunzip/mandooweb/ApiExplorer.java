package com.gunzip.mandooweb;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

// 고속도로 API
public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552061/roadDgdgrHighway/getRestRoadDgdgrHighway"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZtdZwa%2FHIEL1O0xwoQ96aLM9AQLpJfdqWxiNoEEbg8t4b3XyY5pqbmY5s864FPRt1WiarbQZ%2FTWr%2B5%2FQn3tCsA%3D%3D"); /*Service Key*/
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
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}