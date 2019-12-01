package academy.learnprogramming.config.deleted;

import academy.learnprogramming.config.GameConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// this whole class was deleted for a reason that we do not using beans anymore.
// Therefore @ComponentScan was moved to GameConfig

@Configuration
@Import(GameConfig.class)   // importing config into config
@ComponentScan(basePackages = "academy.learnprogramming")
public class AppConfig {

    /*
    // == beans methods (redundant if annotation @Component used ) ==
    // (when not using annotation @Component in class, but defining beans here)
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
    */

}
