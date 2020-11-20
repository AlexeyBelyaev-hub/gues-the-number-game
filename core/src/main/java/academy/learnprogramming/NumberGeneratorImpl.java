package academy.learnprogramming;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==
    @Getter(AccessLevel.NONE)
    private final Random random = new Random();

//    @Autowired
//    @MaxNumber
    private int maxNumber;

    private int minNumber;

    public NumberGeneratorImpl(@MinNumber int minNumber, @MaxNumber int maxNumber){
        this.minNumber=minNumber;
        this.maxNumber=maxNumber;
    }

    // == public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber-minNumber+1)+minNumber;
    }
}
