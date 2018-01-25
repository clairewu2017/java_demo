

import study.algorithm.FindK;
import study.algorithm.WorkGroup;
import study.annotation.Name;
import study.aop.Test;
import study.autowire.Zoo;
import study.concurrent.ConcurrentCalculator2;
import study.java8.MyOptional;
import study.java8.MyStreamGroupBy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;


public class TestApplication {
	public static void main(String[] args) throws Exception {

		new WorkGroup().test();
		FindK.test();
		//study.java8 test -------
		new MyStreamGroupBy().test();
		new MyOptional().test();
		//study.java8 test -------


		// study.concurrent test -------
		ConcurrentCalculator2 calculator = new ConcurrentCalculator2();
		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.print(calculator.sum(numbers));
		calculator.close();
		// study.concurrent test -------


		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// study.autowire test -----------
		Zoo zoo = (Zoo)context.getBean("zoo");
		System.out.println(zoo);
		// study.autowire test -----------

		// study.aop test begin----------
		Test bean = context.getBean(Test.class);
		bean.Case1();
		// study.aop test end------------

		// study.annotation begin--------
		Class demoClass = Class.forName("study.annotation.DemoClass");
		Annotation[] annotations = demoClass.getMethod("Case1").getAnnotations();
		for (Annotation annotation :
				annotations) {
			if (annotation instanceof Name)
			{
				Name name = (Name)annotation;
				System.out.println(name.community() + " " + name.originate());
			}
		}
		// study.annotation end----------
	}
}
