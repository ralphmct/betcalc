package malone.controller;

import malone.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BetController {

    private BetService oddsService;

    @Autowired
    public BetController(BetService oddsService) {
        this.oddsService = oddsService;
    }

    @RequestMapping(value="/bet/odds", method=RequestMethod.GET)
    public ResponseEntity<String> calculateOdds(@RequestParam("oddsPart1") int oddsPart1,
                                        @RequestParam("oddsPart2") int oddsPart2,
                                        @RequestParam("stake") int stake) {
        return ResponseEntity.ok(oddsService.calculateBet(oddsPart1, oddsPart2, stake));
    }

}
