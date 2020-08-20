package com.github.mbelduque.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

/*
 * Configure the Swagger library to expose the REST API
 * */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.mbelduque.apirest"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "API REST Demo",
                "API REST CRUD Endpoints",
                "0.0.1-SNAPSHOT",
                "Terms of service",
                new Contact("Mauricio Belduque", "https://github.com/mbelduque", "m.belduque@hotmail.com"),
                "Apache License Version 2.0",
                "https://apache.org/licesen.html",
                new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }

}
