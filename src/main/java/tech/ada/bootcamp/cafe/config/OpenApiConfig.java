package tech.ada.bootcamp.cafe.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI defaultOpenApiConfig(){
        return new OpenAPI()
                .info(new Info().title("Pagamento Café Service")
                        .description("Estrutura padrão de projeto para o pagamento do café")
                        .version("0.0.1"));
    }
}
