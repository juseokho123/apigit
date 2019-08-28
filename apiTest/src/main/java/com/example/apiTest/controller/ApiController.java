package com.example.apiTest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ApiController {

	private final String apiUrl="http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp";
	
	@RequestMapping("/apiCall")
	public String apiCall() {
	
		return "/apiCall.html";
	}
	
	@RequestMapping(value ="/apiCallprocess", produces = "application/json")
	public  @ResponseBody List<Map<String,Object>> apiCall(@RequestParam(value="stnId",defaultValue = "108",required =false)String stnId) {
		
		System.out.println(stnId +"<< stnId");
		
		List<Map<String,Object>> apiList = new ArrayList<Map<String,Object>>();
		
		try {
			Document doc = Jsoup
					//커넥션 주소,data는 보낼 값 ,get방식인지 post방식인지 
					.connect(apiUrl)
					.data("stnId", stnId)
					.get();
			
			System.out.println(doc.html());
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return apiList;
	}
	
}
