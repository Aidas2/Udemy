package academy.learnprogramming.console;

import academy.learnprogramming.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

//    private static final Logger log = LoggerFactory.getLogger(Main.class); // used before Lombok

//    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // create context (container)
        ConfigurableApplicationContext context
//                = new ClassPathXmlApplicationContext(CONFIG_LOCATION);    // this was for beans.xml
//                = new AnnotationConfigApplicationContext(AppConfig.class); // used before deleting whole class
                = new AnnotationConfigApplicationContext(GameConfig.class);

        /* // do not need anymore (used just for testing)
        // get number generator bean from context (container)
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);

        // call method next() to get a random number
        int number = numberGenerator.next();

        // log generated number
        log.info("number = {}", number);

        // get game bean from context (container)
        // Game game = context.getBean(Game.class); // do not need anymore as passed as field in messageGenerator (?)

        // call reset() method
        // game.reset(); // moved to beans.xml

        // get message generator bean from context (container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessage= {}", messageGenerator.getMainMessage());
        log.info("getResultMessage= {}", messageGenerator.getResultMessage());

         */

        // close context (container)
        context.close();



    }
}
