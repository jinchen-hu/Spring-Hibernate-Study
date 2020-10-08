package springdemo;

public class SadFortune implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "Today is a sad day";
	}

}
