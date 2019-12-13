package com.example.demo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author:WANGJING
 * @Date: 2019/12/11 14:43
 */
@Configuration
@EnableWebMvc

@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket buildDocket() {
//        ParameterBuilder aParameterBuilder = new ParameterBuilder();
//        aParameterBuilder
//                .parameterType("header") //参数类型支持header, cookie, body, query etc
//                .name("x-auth-token") //参数名
//                .defaultValue("21423423") //默认值
//                .description("header中token字段测试")
//                .modelRef(new ModelRef("string"))//指定参数值的类型
//                .required(false).build(); //非必需，这里是全局配置，然而在登陆的时候是不用验证的
//        List<Parameter> aParameters = new ArrayList<Parameter>();
//        aParameters.add(aParameterBuilder.build());

		return new Docket(DocumentationType.SWAGGER_2).groupName("sj")
				.apiInfo(buildApiInf())
//                .globalOperationParameters(aParameters)
//        .host("localhost:20000")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))//controller路径
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo buildApiInf() {
		return new ApiInfoBuilder()
				.title("RestAPI Docs")
				.termsOfServiceUrl("http://www.github.com/kongchen/swagger-maven-plugin")
				.build();

	}
}