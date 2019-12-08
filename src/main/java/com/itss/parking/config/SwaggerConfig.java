package com.itss.parking.config;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)  
			.select()								  
			.apis(RequestHandlerSelectors.basePackage("com.itss.parking.controller"))	
			.paths(PathSelectors.any())
			.build()
			.useDefaultResponseMessages(false)								   
			.globalResponseMessage(RequestMethod.GET, responseMessageForGET())
			.apiInfo(apiInfo())
			.directModelSubstitute(Timestamp.class, Long.class)
			.globalOperationParameters(
				Arrays.asList(new ParameterBuilder().name("Authorization").description("Header para token JWT")
				.modelRef(new ModelRef("string")).parameterType("header").required(false)
			.build()));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Parking API")
				.description("Testing Parking Management API")
				.version("1.0.0")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				.contact(new Contact("Douglas Japiassu", "https://github.com/douglasjapiassu", "douglas.japiassu@gmail.com"))
				.build();
	}

	private List<ResponseMessage> responseMessageForGET() {
		return new ArrayList<ResponseMessage>() {
			private static final long serialVersionUID = 1L;

			{
			add(new ResponseMessageBuilder()   
				.code(500)
				.message("500 message")
				.responseModel(new ModelRef("string"))
				.build());
			add(new ResponseMessageBuilder() 
				.code(403)
				.message("Forbidden!")
				.build());
		}};
	}

}
