package academy.learprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // == fields ==
    @Autowired
    private Game game;
    private int guessCount = 10;

    // == init ==
    @PostConstruct
    public void init() {
        log.info("game equals = {}", game);
    }

    // == public methods ==
    @Override
    public String getMainMessage() {
        return "getMainMessage() called";
    }

    @Override
    public String getResultMessage() {
        return "getResultMessage() called";
    }
}
