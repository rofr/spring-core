package hello;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessagePrinterWiringTests {

	private MessagePrinter messagePrinter;
	
	@Before
	public void init() {
		ApplicationContext ctx 
			= new AnnotationConfigApplicationContext(Application.class);
		messagePrinter = ctx.getBean(MessagePrinter.class);
	}

	@Test(expected=IllegalArgumentException.class)
	public void prefixCannotBeSetToNull() {
		messagePrinter.setPrefix(null);
	}

	
	@Test
	public void prefixIsWired() {
		String prefix = messagePrinter.getPrefix();
		assertNotNull(prefix);
	}
}
