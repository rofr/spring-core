package profiles;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

public class Tests {

	@Test
	public void verifyProfileIsTest() {
		
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "test");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		String message = context.getBean(String.class);
		assertEquals("test", message);
	}

}
