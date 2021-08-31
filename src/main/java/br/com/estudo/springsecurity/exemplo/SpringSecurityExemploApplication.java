package br.com.estudo.springsecurity.exemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.estudo.springsecurity.exemplo.jwt.JwtConfig;

@SpringBootApplication
@EnableConfigurationProperties(JwtConfig.class)
public class SpringSecurityExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityExemploApplication.class, args);
	}

}
