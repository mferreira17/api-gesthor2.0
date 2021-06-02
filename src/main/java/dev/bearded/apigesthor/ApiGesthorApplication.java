package dev.bearded.apigesthor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

@SpringBootApplication
public class ApiGesthorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGesthorApplication.class, args);
    }

    @Bean
    public ApiInfo apiInfo() {
        final ApiInfoBuilder builder = new ApiInfoBuilder();
        builder.title("Gesthor Spring Boot API").version("1.0").license("(C) Dev.Bearded")
                .description("Aqui estão todos os endpoints utilizados na API");
        return builder.build();
    }

}
