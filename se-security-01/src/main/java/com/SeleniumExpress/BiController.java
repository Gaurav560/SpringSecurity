package com.SeleniumExpress;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BiController {

	@GetMapping("/bye")
	public String sayBye() {
		return "bye everyone";
	}
}
