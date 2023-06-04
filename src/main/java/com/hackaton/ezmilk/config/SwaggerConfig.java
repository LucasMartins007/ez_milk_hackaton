package com.hackaton.ezmilk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("appName")
                .select()
//                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
//                .paths(PathSelectors.ant(basePath))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("title")
                .description("description")
                .version("version")
                .build();
    }
}
