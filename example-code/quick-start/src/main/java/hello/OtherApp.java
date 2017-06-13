package hello;

import java.util.concurrent.SynchronousQueue;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OtherApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx 
			= new AnnotationConfigApplicationContext();
		
		ctx.refresh();
		System.out.println(ctx.getBeanDefinitionCount());
		
		MessagePrinter messagePrinter = ctx.getBean(MessagePrinter.class);
		messagePrinter.printMessage();
		
		int answer = (Integer) ctx.getBean("number");
		System.out.println(answer);
		ctx.close();
		
		
		//ctx.getBean(MessagePrinter.class);
	}
}
