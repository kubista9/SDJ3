package via.dk.springrestexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringRestExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestExampleApplication.class, args);
	}

	@GetMapping("/topic")
	public String topic(@RequestParam(value = "topic", defaultValue = "Spring Boot REST") String topic){
		return String.format("<h1>This Spring BOOT!</h1> <br> <b>%s</b>, will be discussed in details", topic);
	}
}
