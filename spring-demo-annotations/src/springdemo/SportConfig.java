package springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	// define bean for fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortune();
	}

	// define bean for coach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
