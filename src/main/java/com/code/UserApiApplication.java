package com.code;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@OpenAPIDefinition(
		info = @Info(
				title="User Api ",
				version = "1.0.0",
				description = "User Api Documentation "
		),
		servers = @Server(
				url ="https://localhost:8080",
				description = "User Open API url"
		)
)*/

public class UserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);


		System.err.println("PORT : localhost8080");
		System.err.println("Swagger documentation : "+"http://localhost:8080/swagger-ui/index.html#/");

	}

}
