package com.efrensalado.cotiza_credito;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {
 
    @Bean
    public Docket api() {
 
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.efrensalado.cotiza_credito"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
        }   
     
        private ApiInfo getApiInfo() {
            return new ApiInfo(
                    "Cotiza Credito API",
                    "Documentación de API de cotizacion de creditos",
                    "1.0",
                    "",
                    new Contact("efrensalado", "", "efrensalado@gmail.com"),
                    "LICENSE",
                    "LICENSE URL",
                    Collections.emptyList()
                    );
        }
        
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addRedirectViewController("/api/v2/api-docs", "/v2/api-docs");
            registry.addRedirectViewController("/api/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
            registry.addRedirectViewController("/api/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
            registry.addRedirectViewController("/api/swagger-resources", "/swagger-resources");
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/api/swagger-ui.html**").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
            registry.addResourceHandler("/api/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
}
     