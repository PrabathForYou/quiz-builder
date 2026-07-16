package com.prabath.quiz_builder.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI quizBuilderOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Quiz Builder API")
                        .description("API documentation for managing questions and quizzes")
                        .version("1.0.0"));
    }
}
