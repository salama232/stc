package com.stc.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@Configuration
public class SwaggerConfig{

    private static final String SWAGGER_API_VERSION = "1.0";
   // private static final String LICENSE_TEXT = "License";
    private static final String title = "REST API";
    private static final String description = "RESTful API for Campaign Engine";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
            //    .license(LICENSE_TEXT)
                .version(SWAGGER_API_VERSION)
                .build();
    }

    @Bean
    public Docket productsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/api.*"))
                .build();
    }
//
//    
//    private ApiKey apiKey() { 
//        return new ApiKey("JWT", "Authorization", "header"); 
//    }
//    
//	public static final String AUTHORIZATION_HEADER = "Authorization";
//
//	  private ApiInfo apiInfo() {
//	    return new ApiInfo("Marakez Campaign Engine REST API",
//	        "Some custom description of API.",
//	        "1.0",
//	        "Terms of service",
//	        new Contact("Mohammed Salama", "www.Marakez.com", "mibrahim@marakez-moa.net"),
//	        "License of API",
//	        "API license URL");
//	  }
//
//	  @Bean
//	  public Docket api() {
//	    return new Docket(DocumentationType.SWAGGER_2)
//	        .apiInfo(apiInfo())
//	        .securityContexts(Arrays.asList(securityContext()))
//	        .securitySchemes(Arrays.asList(apiKey()))
//	        .select()
//	        .apis(RequestHandlerSelectors.any())
//	        .paths(PathSelectors.any())
//	        .build();
//	  }
//
//	  private ApiKey apiKey() {
//	    return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
//	  }
//
//	  private SecurityContext securityContext() {
//	    return SecurityContext.builder()
//	        .securityReferences(defaultAuth())
//	        .build();
//	  }
//
//	  List<SecurityReference> defaultAuth() {
//	    AuthorizationScope authorizationScope
//	        = new AuthorizationScope("global", "accessEverything");
//	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//	    authorizationScopes[0] = authorizationScope;
//	    return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
//	  }

    
}