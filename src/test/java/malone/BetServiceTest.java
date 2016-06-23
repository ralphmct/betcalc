package java.malone;

import java.BetService;
import java.impl.BasicBetService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by mct on 14/06/16.
 */
public class BetServiceTest {

    private BetService betService;
    private String validResultString = "Your bet profit is: ";
    private String negativeStakeError = "Stake cannot be lower than 0!";

    @Before
    public void setUp() throws Exception {
        betService = new BasicBetService();
    }

    @Test
    public void testCalculateBetStakeOf10() throws Exception {
        double expectedResultProfit = 30.0;
        String expectedResultString = validResultString + expectedResultProfit;
        int stake = 10;
        int oddsPart1 = 3;
        int oddsPart2 = 1;

        String actualResult = betService.calculateBet(oddsPart1, oddsPart2, stake);

        assertThat(actualResult, is(equalTo(expectedResultString)));
    }

    @Test
    public void testCalculateBetStakeOf5() throws Exception {
        double expectedResultProfit = 15.0;
        String expectedResultString = validResultString + expectedResultProfit;
        int stake = 5;
        int oddsPart1 = 3;
        int oddsPart2 = 1;

        String actualResult = betService.calculateBet(oddsPart1, oddsPart2, stake);

        assertThat(actualResult, is(equalTo(expectedResultString)));
    }

    @Test
    public void testCalculateBetWithInvalidStake() throws Exception {
        String expectedResultString = negativeStakeError;
        int stake = -10;
        int oddsPart1 = 3;
        int oddsPart2 = 1;

        String actualResult = betService.calculateBet(oddsPart1, oddsPart2, stake);

        assertThat(actualResult, is(equalTo(expectedResultString)));
    }
}