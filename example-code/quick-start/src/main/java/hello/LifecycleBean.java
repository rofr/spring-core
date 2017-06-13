package hello;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LifecycleBean {

	private Counter counter;
		
	@Autowired
	public void setCounter(Counter counter) {
		this.counter = counter;
	}
	
	@PreDestroy
	private void destroyed() {
		System.out.println(toString() + " @PreDestroy" );
	}
	
	@PostConstruct
	private void init() {
		System.out.println(toString() + " @PostConstruct" );
		counter.increment();
	}
}
