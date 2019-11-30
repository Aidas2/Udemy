package academy.learprogramming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "academy.learprogramming")
public class AppConfig {

    // == beans methods ==
    // (when not using annotations in class, but defining beans here)
    @Bean
    public NumberGenerator numberGenerator() {
        return  new NumberGeneratorImpl();
    }

    @Bean
    public Game game() {
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImpl();
    }

}
