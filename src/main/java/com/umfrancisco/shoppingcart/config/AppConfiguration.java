package com.umfrancisco.shoppingcart.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class AppConfiguration {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("E-Commerce de Jogos Eletrônicos e Hardware")
						.version("1.0")
						.description("Este projeto é uma API REST de um sistema de e-commerce de Jogos Eletrônicos e Hardware desenvolvida com foco em boas práticas de arquitetura, organização de código e padrões utilizados no mercado."));
	}
}
