package ummto.l3.travelagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("ummto.l3.travelagency")
public class AppRunner {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppRunner.class, args);
	}

}
