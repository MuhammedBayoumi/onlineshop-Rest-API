package onlineshop.rest.api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.convert.Jsr310Converters;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = { OnlineshopRestApiApplication.class, Jsr310Converters.class })

public class OnlineshopRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineshopRestApiApplication.class, args);
	}
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
