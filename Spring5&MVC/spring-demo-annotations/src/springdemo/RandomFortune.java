package springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortune implements FortuneService {

	private String[] data = { "Beware of the wolf in sheep's clothing", "Free Campground", "100k dollars", };

	@Override
	public String getDailyFortune() {
		return data[(int) new Random().nextInt(data.length)];
	}

}
