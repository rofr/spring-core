package hello;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AlternateMessageService implements MessageService, InitializingBean, DisposableBean {

	@Override
	public String getMessage() {
		return "Howdy folks!";
	}
	
	public AlternateMessageService(Counter counter) {
		counter.increment();
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean.destroy() called");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean.afterPropertiesSet() called");
		
	}

}
