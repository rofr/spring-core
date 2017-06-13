package hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@ComponentScan()
//@Configuration
public class Application {

	@Primary
	@Bean
	public MessageService mockMessageService(final String mood) {
		System.out.println("calling mockMessageService(), mood = " + mood);
		return () -> "Hello, " + mood + " World";
	}
	
	@Primary
	@Bean
	public String defaultMood() {
		return "Happy";
	}
	
	@Bean("sad")
	public String sadMood() {
		return "Sad";
	}
	
	@Primary
	@Bean
	public Counter singletonCounter() {
		return new Counter();
	}
	
	@Bean(name="proto")
	@Scope("prototype")
	public Counter prototypeCounter() {
		return new Counter();
	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx 
			= new AnnotationConfigApplicationContext(Application.class);
		MessagePrinter messagePrinter = ctx.getBean(MessagePrinter.class);
		messagePrinter.printMessage();
		ctx.close();
	}

}
