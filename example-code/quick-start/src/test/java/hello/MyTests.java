package hello;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTests {

	@Test
	public void nonPopulatedContainer() {
		AnnotationConfigApplicationContext ctx 
		= new AnnotationConfigApplicationContext();
		for (String name : ctx.getBeanDefinitionNames()) {
			System.out.println(name);
			BeanDefinition beanDef = ctx.getBeanDefinition(name);
			System.out.println(beanDef);
			System.out.println();
		}
	}
	
	@Test
	public void displayBeanDefinitions() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		for (String name : ctx.getBeanDefinitionNames()) {
			System.out.println(name);
			BeanDefinition beanDef = ctx.getBeanDefinition(name);
			System.out.println(beanDef);
			System.out.println();
		}
	}
	
	@Test
	public void beanMethodIsSingleton() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		MessageService svc1 = ctx.getBean(MessageService.class);
		MessageService svc2 = ctx.getBean(MessageService.class);
		System.out.println("svc1.toString()" + svc1.toString());
		System.out.println("svc1.toString()" + svc2.toString());
		assertSame(svc1, svc2);
	}
	
	@Test
	public void beanMethodReturnsNewInstanceWhenCalledOutsideOfContext() {
		Application app = new Application();
		MessageService svc1 = app.mockMessageService("a");
		MessageService svc2 = app.mockMessageService("b");
		System.out.println("svc1.toString()" + svc1.toString());
		System.out.println("svc1.toString()" + svc2.toString());
		assertNotSame(svc1, svc2);
	}
	
	@Test
	public void lifecycleBean() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		LifecycleBean lcBean = ctx.getBean(LifecycleBean.class);
		
	}
	
	@Test
	public void verifySingleton() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		Counter c1  = ctx.getBean(Counter.class);
		c1.increment();
		Counter c2 = ctx.getBean(Counter.class);
		assertSame(c1,c2);
		assertEquals(c1.getValue(),c2.getValue());
	}
	
	@Test
	public void verifyPrototype() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		Counter c1  = ctx.getBean("proto", Counter.class);
		assertEquals(0, c1.getValue());
		c1.increment();
		assertEquals(1, c1.getValue());
		Counter c2 = ctx.getBean("proto", Counter.class);
		assertNotSame(c1,c2);
		assertNotEquals(c1.getValue(),c2.getValue());
	}

	@Test
	public void verifyLazy() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		Counter counter = ctx.getBean(Counter.class);
		int current = counter.getValue();
		ctx.getBean(AlternateMessageService.class);
		assertEquals(current + 1, counter.getValue());
		ctx.close(); //trigger destroy methods
	}
	@Test
	public void demoPropertiesFile() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		PropertyReader reader = ctx.getBean(PropertyReader.class);
		String message = reader.getMessage();
		assertEquals("Hallo Welt", message);
	}
}
