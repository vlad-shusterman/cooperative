package by.bsuir.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"by.bsuir"})
@EnableMongoRepositories(basePackages = "by.bsuir")
@EnableSwagger2 // {@link http://localhost:8080/swagger-ui.html}
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
