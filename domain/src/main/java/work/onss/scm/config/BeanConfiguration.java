package work.onss.scm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BeanConfiguration {

    @Bean
    public BCryptPasswordEncoder encoding(){
        return new BCryptPasswordEncoder();
    }
}
