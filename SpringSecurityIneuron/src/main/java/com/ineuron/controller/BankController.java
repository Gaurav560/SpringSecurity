package com.ineuron.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

	@GetMapping("/")
	public String welcomePage() {
		return "Welcome To ICICI Bank";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login please";
	}
	@GetMapping("/fundTransfer")
	public String fundTransferPage() {
		return "transferred 590000 to gaurav sharma";
	}
	@GetMapping("/aboutUs")
	public String aboutUsPage() {
		return "We are world's no'1 bank.";
	}

	
}
