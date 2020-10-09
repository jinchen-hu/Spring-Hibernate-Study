package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach sCoach = context.getBean("swimmingCoach", Coach.class);

		System.out.println(theCoach.getDailyWorkout());
		System.out.println(sCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(sCoach.getDailyFortune());

		context.close();
	}

}
