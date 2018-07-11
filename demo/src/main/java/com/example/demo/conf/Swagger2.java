package com.example.demo.conf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2配置类
 * 
 * @author 41254
 *
 */
@Configuration
@ConditionalOnProperty(prefix = "api", name = "docs", havingValue = "enable", matchIfMissing = false)
// @ConditionalOnProperty(prefix = "api", value = { "enable" }, havingValue =
// "true", matchIfMissing = false)
public class Swagger2 {

	/*
	 * @Value("${swagger.enable}") private boolean enableSwagger;
	 */

	@Bean
	public Docket createRestApi() {
		// return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())/*
		// .enable(enableSwagger) */.select()

		return new Docket(DocumentationType.SWAGGER_2)
				.globalOperationParameters(Lists.newArrayList(new ParameterBuilder().name("")
						.modelRef(new ModelRef("string")).parameterType("header").build()))
				.select()

				.apis(RequestHandlerSelectors.basePackage("com.example.demo"))// controller包的路径
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("springboot利用swagger2构建api文档")
				.description("简单优雅的restful风格的API文档，http://www.baidu.com").termsOfServiceUrl("http://www.baidu.com")
				.version("1.0").build();
	}

}
