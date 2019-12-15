package com.pacto.alegre.empreend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class EmpreendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpreendApplication.class, args);
	}

	@RestController
	public static class MainController {

		@RequestMapping("/")
		public String testMethod() {
			return "Method success!";
		}
	}

}
