package springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("happyFortune")
	private FortuneService fortune;

	@Override
	public String getDailyWorkout() {
		return "Proctice yourr backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortune.getDailyFortune();
	}

	@PostConstruct
	public void init() {
		System.out.println("init tennis coach");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("destroy the bean");
	}

}
