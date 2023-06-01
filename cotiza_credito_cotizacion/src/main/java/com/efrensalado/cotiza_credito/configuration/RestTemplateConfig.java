package com.efrensalado.cotiza_credito.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class RestTemplateConfig {

	@Bean
	public RestTemplate restTemplate () {
		return new RestTemplate();
	}
}
