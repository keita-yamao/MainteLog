package io.github.keita_yamao.maintelog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "PM管理システム"))
@SpringBootApplication
public class MaintelogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaintelogApplication.class, args);
	}
}
