package com.nordea.demobanking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

public class SpringDocConfig implements WebMvcConfigurer {
//
//	@Bean
//	public OpenAPI metaData() {
//		return new OpenAPI()
//				.info(new Info().title("Demo Banking REST API").description("Demo Banking Rest application")
//						.version("1.0.0").license(new License().name("Apache 2.0").url("https://springdoc.org")))
//				.externalDocs(new ExternalDocumentation());
//	}

	
	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
	   return new OpenAPI()
	    .components(new Components().addSecuritySchemes("basicScheme",
	            new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
	    .info(new Info().title("SpringShop API").version(appVersion)
	            .license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
}
