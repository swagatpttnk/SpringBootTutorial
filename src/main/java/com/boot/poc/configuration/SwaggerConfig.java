package com.boot.poc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration  //enable configuration
@EnableSwagger2  //enable swagger2
public class SwaggerConfig {
    //create Docket Bean
    //Swagger 2
    //All the paths
    //All the APIs
    public static final Contact DEFAULT_CONTACT = new Contact(
            "Swagat Pattnaik", "http://www.itrending.com", "itrending@gmail.com");

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Demo API Title", "Demo API to display Spring Boot concepts", "1.0",
            "urn:tos", DEFAULT_CONTACT,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Arrays.asList());

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<String>(Arrays.asList("application/json",
                    "application/xml","text/plain"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}
