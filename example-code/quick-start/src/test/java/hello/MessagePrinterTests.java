package hello;

import static org.junit.Assert.*;

import org.junit.Test;

public class MessagePrinterTests {

	boolean getMessageCalled = false;
	
	@Test
	public void printMessage_calls_MessageService_getMessage() {
		
		
		final MessageService service = new MessageService(){
			@Override
			public String getMessage() {
				getMessageCalled = true;
				return "dummy";
			}
		};
		MessagePrinter target = new MessagePrinter(service);
		target.printMessage();
		assertTrue(getMessageCalled);
	}

}
