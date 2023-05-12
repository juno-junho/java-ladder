package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaTest {
    private List<Integer> numbers;

    @BeforeEach
    public void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void printAllOld(){
        Lambda.printAllOld(numbers);
    }

    @Test
    public void printAllLambda(){
        Lambda.printAllLambda(numbers);
    }

    @Test
    public void runThread(){
        Lambda.runThread();
    }

    @Test
    public void sumAll(){
        Conditional condition = number -> true;

        int sum = Lambda.sumAll(numbers,condition);

        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumAllEven(){
        Conditional condition = number -> number % 2 == 0;

        int sum = Lambda.sumAll(numbers,condition);

        assertThat(sum).isEqualTo(12);
    }

    @Test
    public void sumAllOverThree(){
        Conditional condition = number -> number > 3;

        int sum = Lambda.sumAll(numbers,condition);

        assertThat(sum).isEqualTo(15);
    }
}
