package kr.or.ksmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication

@Controller
public class WarFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarFileApplication.class, args);
	}
	
	@GetMapping("/")
	public @ResponseBody String home() {
		return "ksmart.or.kr";
	}

}
