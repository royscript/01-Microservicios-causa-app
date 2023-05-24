package cl.amisoft.causaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CausaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CausaAppApplication.class, args);
	}

}
