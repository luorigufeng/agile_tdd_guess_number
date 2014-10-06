package com.zte.ums.agile.homework.tdd3.guess_number;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

// 这个类叫GuessNunberBatchTest比较合适
// 为了便于git跟踪历史，这里不重名这个类了，另起一个GuessNumberSingleTest
@RunWith(Parameterized.class)
public class GuessNumberTest {
    private GuessNumber guessNumber;
    private String input;
    private String result;

    public GuessNumberTest(String input, String result) {
        this.input = input;
        this.result = result;
    }

    @Parameters(name = "{index}: The input number is \"{0}\" and  the bingo number is \"6789\". The result is \"{1}\".")
    public static Iterable<Object[]> cases() {
        return Arrays.asList(new Object[][]{
                {"1234","0A0B"},
                {"9234","0A1B"},
                {"9834","0A2B"},
                {"9874","0A3B"},
                {"9876","0A4B"},
                {"6234","1A0B"},
                {"6834","1A1B"},
                {"6874","1A2B"},
                {"6978","1A3B"},
                {"6734","2A0B"},
                {"6794","2A1B"},
                {"6798","2A2B"},
                {"6784","3A0B"},
                {"6789","4A0B"}
        });
    }

    @Before
    public void setUp() {
        this.guessNumber =  new GuessNumber();
    }

    @Test
    public void test_guess() {
        assertThat(this.guessNumber.guess(input), is(this.result));
    }

}