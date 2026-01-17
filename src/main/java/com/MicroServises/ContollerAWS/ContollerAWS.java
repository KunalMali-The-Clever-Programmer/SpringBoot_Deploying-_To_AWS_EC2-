package com.MicroServises.ContollerAWS;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContollerAWS {
	
	
	@GetMapping("/home")
	public String Home() {	
		return "This is Home Contoller";
	}
	
	@GetMapping("/test")
	public String Test() {	
		return "This is test Contoller";
	}

}
