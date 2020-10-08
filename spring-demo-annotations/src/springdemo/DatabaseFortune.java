package springdemo;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortune implements FortuneService {

	@Override
	public String getDailyFortune() {
		return null;
	}

}
