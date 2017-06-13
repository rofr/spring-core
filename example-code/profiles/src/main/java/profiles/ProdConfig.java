package profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!test")
public class ProdConfig {
	
	@Bean
	public String getMessage() {
		return "not test";
	}
}
