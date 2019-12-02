package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
// @Getter // do not need that (there is no getter's). Or set @Getter(AccessLevel.NONE) on every field (?)
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    // == constants ==
    // private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class); // used before Lombok

    // == fields ==
    // @Autowired // replaced (here and below) via annotating constructor
    private final Game game;

    // == constructors ==
    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // == init ==
    @PostConstruct
    public void init() {
        log.info("game equals = {}", game);
    }

    // == public methods ==
    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {

        if(game.isGameWon()) {
            return "You guessed it! The number was " + game.getNumber();
        } else if(game.isGameLost()) {
            return "You lost. The number was " + game.getNumber();
        } else if(!game.isValidNumberRange()) {
            return "Invalid number range!";
        } else if(game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess?";
        } else {
            String direction = "Lower";

            if(game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }

            return direction + "! You have " + game.getRemainingGuesses() + " guesses left";
        }
    }
}
