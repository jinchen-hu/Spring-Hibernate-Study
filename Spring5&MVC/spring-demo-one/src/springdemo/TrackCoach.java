package springdemo;

public class TrackCoach implements Coach {

	private FortuneService forturnService;

	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}

	public TrackCoach(FortuneService fortuneService) {
		// TODO Auto-generated constructor stub
		this.forturnService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {

		return forturnService.getFortune();
	}

}
