package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		CricketCoach theCoach2 = context.getBean("myCricketCoach", CricketCoach.class);

		System.out.println(theCoach);
		System.out.println(theCoach2);
		System.out.println(theCoach == theCoach2);

		context.close();

	}

}
