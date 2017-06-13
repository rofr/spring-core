import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import m02.Calculator;

public class Tests {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		Calculator calculator = ctx.getBean(Calculator.class);
		int sum = calculator.sum();
		assertEquals(10+20+30+40+50, sum);
	}

}
