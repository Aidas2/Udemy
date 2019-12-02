package academy.learnprogramming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component  //@Component("game")
public class  GameImpl implements Game {

    // == constructors ==
//     created for constructor based dependency injection
//    public GameImpl(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }

    // == constants ==
    // private static final Logger log = LoggerFactory.getLogger(GameImpl.class); // used before Lombok

    // == fields ==
    // @Autowired // replaced (here and below) via annotating constructor
    @Getter(AccessLevel.NONE)   // because we do not need getter for this field
    private final NumberGenerator numberGenerator;

    // @Autowired
    // @GuessCount // our own custom annotation
    private final int guessCount;

    private int number;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Setter
    private int guess;

    // == constructors ==
    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    // == init ==
    @PostConstruct  // means that this will be auto initialized
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = numberGenerator.getMinNumber();
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("the number is {}", number);
    }

    @PreDestroy // means that this will be auto initialized (after ?)
    public void preDestroy() {
        log.info("in Game preDestroy()");
    }

    // == public methods ==
//    created for setter based dependency injection
//    later replaced with autowiring
//    public void setNumberGenerator(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }
/*  // used before Lombok
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public int getGuessCount() {
        return guessCount;
    }
*/
    @Override
    public void check() {

        checkValidNumberRange();

        if(validNumberRange) {
            if(guess > number) {
                biggest = guess -1;
            }

            if(guess < number) {
                smallest = guess + 1;
            }
        }

        remainingGuesses--;
    }

//    @Override // used before Lombok
//    public boolean isValidNumberRange() {
//        return validNumberRange;
//    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private methods ==
    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
