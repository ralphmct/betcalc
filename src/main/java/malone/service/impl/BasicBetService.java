package malone.service.impl;

import malone.service.BetService;
import org.springframework.stereotype.Component;

/**
 * Created by mct on 10/06/16.
 */
@Component
public class BasicBetService implements BetService {

    @Override
    public String calculateBet(int oddsPart1, int oddsPart2, int stake) {
        return "Your bet profit is: " + calculateProfit(oddsPart1, oddsPart2, stake);
    }

    private double calculateProfit(int oddsPart1, int oddsPart2, int stake) {

        return 0.0;
    }
}
