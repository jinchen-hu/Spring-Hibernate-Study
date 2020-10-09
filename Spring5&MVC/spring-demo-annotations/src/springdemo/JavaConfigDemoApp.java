package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println("\n====================\n");
		SwimCoach sCoach = context.getBean("swimCoach", SwimCoach.class);
		System.out.println(sCoach.getDailyFortune());
		System.out.println(sCoach.getDailyWorkout());
		System.out.println(sCoach.getEmail());
		System.out.println(sCoach.getTeam());

		context.close();
	}
}
