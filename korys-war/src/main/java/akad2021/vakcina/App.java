package akad2021.vakcina;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import akad2021.vakcina.centras.Centras;
import akad2021.vakcina.centras.Kabina;
import akad2021.vakcina.centras.Vakcina;
import akad2021.vakcina.dao.CentrasDao;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class App extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}

	@Bean
	CommandLineRunner commandLineRunner (CentrasDao centrasDao) {
		return args ->{
			var centras = new Centras("test","nuoroda","tipinis aprasymas cia", "vieta",new ArrayList<Kabina>(), new ArrayList<Vakcina>());
			centrasDao.save(centras);
			var centrasdu = new Centras("test2","nuoroda2","tipinis aprasymas cia2","vieta", new ArrayList<Kabina>(), new ArrayList<Vakcina>());
			centrasDao.save(centrasdu);
		};
	}
	
	@Bean
	public Docket swaggerDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("akad2021.vakcina")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("LT Egzaminas REST Documentation").version("1.0-SNAPSHOT").build();
	}
}