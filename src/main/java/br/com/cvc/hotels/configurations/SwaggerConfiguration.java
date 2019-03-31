package br.com.cvc.hotels.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Jonathan Taquita (takita.jonathan@gmail.com)
 * @since 2019.03.30
 *
 * Class for configuration swagger
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     * Method for configure interface swagger API
     *
     * @return void
     */
    @Bean
    public Docket hotelsAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.cvc.hotels.controllers"))
                .paths(PathSelectors.any())
                .build();
    }


}
