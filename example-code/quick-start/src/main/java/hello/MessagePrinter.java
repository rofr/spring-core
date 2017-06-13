package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
	
	private MessageService service;
	public final static String DefaultPrefix = "NOT ASSIGNED: ";
	
	private String prefix = null;
	
	
	public String getPrefix() {
		return prefix;
	}
	
	public MessagePrinter(MessageService service) {
		this.service = service;
	}
	
	@Autowired
	public void setPrefix(String prefix) {
		if (prefix == null) throw new IllegalArgumentException("prefix");
		this.prefix = prefix;
	}
	
	public void printMessage(){
		System.out.print(prefix == null ? DefaultPrefix : prefix);
		System.out.println(": " + service.getMessage());
	}
}
