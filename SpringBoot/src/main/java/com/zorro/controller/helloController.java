package com.zorro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	
	public String sayHello(){
		return "Hello Boss";
	}
}
