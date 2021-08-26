package byCoders.desafio.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfiguration {

    @Value("${crud.swagger.path}")
    private String swaggerPath;

    public Docket crudApp() {

        List<Parameter> listaParametros = new ArrayList<Parameter>();

        return new Docket(DocumentationType.SWAGGER_2).host(swaggerPath)
                .groupName("All")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.byCoders.desafio"))
                .paths(PathSelectors.any())
                .build()
                .enableUrlTemplating(true)
                .globalOperationParameters(listaParametros);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Desafio bycoders API")
                .description("API desenvolvido para desafio bycoders")
                .termsOfServiceUrl("http://localhost:8080")
                .license("")
                .licenseUrl("http://localhost:8080")
                .version("2.0")
                .build();
    }
}
