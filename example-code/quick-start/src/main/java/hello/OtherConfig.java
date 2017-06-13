package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfig {

	@Bean("number")
	public Integer number(){
		return 42;
	}
}
