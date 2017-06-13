package hello;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={Application.class})
public class SpringFacilitatedMessagePrinterWiringTests {

	@Autowired
	private MessagePrinter messagePrinter;
	
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
