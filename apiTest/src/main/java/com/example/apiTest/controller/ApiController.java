package com.example.apiTest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {

	@RequestMapping("/")
	public String apiCall() {
	
		return "/apiCall.html";
	}
	
	@RequestMapping(value ="/apiCallprocess", produces = "application/json")
	public  @ResponseBody List<Map<String,Object>> apiCall(@RequestParam(value="stnId",defaultValue = "108",required =false)String stnId) {
		
		System.out.println(stnId +"<< stnId");
		
		List<Map<String,Object>> apiList = new ArrayList<Map<String,Object>>();
		
		return apiList;
	}
	
}
