package springdemo;

import org.springframework.stereotype.Component;

@Component
public class RestFortune implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "Today is day-off";
	}

}
