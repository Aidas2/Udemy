package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import academy.learnprogramming.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "academy.learnprogramming") // inserted after deleting class AppConfig
@PropertySource("classpath:config/game.properties") // to enable reading from this file
public class GameConfig {

    // == fields ==
    @Value("${game.maxNumber:20}")      // value 20 used if value isn't found game.properties
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    @Value("${game.minNumber:5}")
    private  int minNumber;

    // == beans ==
    @Bean
    @MaxNumber  // our own custom annotation
    public  int maxNumber() {
        return  maxNumber;
    }

    @Bean
    @GuessCount // our own custom annotation
    public int guessCount() {
        return guessCount;
    }

    @Bean
    @MinNumber  // our own custom annotation
    public int minNumber() {
        return minNumber;
    }
}
