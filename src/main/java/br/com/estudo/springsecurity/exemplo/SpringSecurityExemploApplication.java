package br.com.estudo.springsecurity.exemplo;

import br.com.estudo.springsecurity.exemplo.jwt.JwtConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties(JwtConfig.class)
@EnableTransactionManagement
public class SpringSecurityExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityExemploApplication.class, args);
	}

}
