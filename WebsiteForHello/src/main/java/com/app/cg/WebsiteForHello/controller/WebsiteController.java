package com.app.cg.WebsiteForHello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class WebsiteController {

	@Autowired
	private RestTemplate restTemplate;

	
	  @RequestMapping("/") 
	  public String index()
	  {
		  return "index"; 
		  }
	 
	@RequestMapping("/hello")
	public String hello(Model model) 
	{
		ResponseEntity<String> entity=restTemplate.getForEntity("http://client-application/hello",String.class);
		String hello=entity.getBody();
		model.addAttribute("hello",hello);
		return "hello";
	}
		
		
	
}
