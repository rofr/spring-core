package profiles;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@ActiveProfiles({"test", "noop"})
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class SpringTests {
	
	@Autowired
	private String injected;
	
	@Test
	public void verifyProfileIsTest() {
		assertEquals("test", injected);
	}
}
