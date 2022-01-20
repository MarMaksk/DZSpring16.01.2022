package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathOperation {

    @GetMapping("/correctFr")
    public boolean correctFraction(@RequestParam("up") int up, @RequestParam("down") int down) {
        return up < down;
    }

    @GetMapping("/reductionFr")
    public String reductionFraction(@RequestParam("up") int up, @RequestParam("down") int down) {
        String result = up + "/" + down;
        for (int i = 2; i < 8; i++) {
            if (up % i == 0 && down % i == 0) {
                up = up / i;
                down = down / i;
                return reductionFraction(up, down);
            }
        }
        return result;
    }

    @GetMapping("/sumFr")
    public String summaryFraction(@RequestParam("upF") int upF, @RequestParam("downF") int downF,
                                  @RequestParam("upS") int upS, @RequestParam("downS") int downS) {
        int downRes = downF * downS;
        int upRes = (downRes / downF * upF) + (downRes / downS * upS);
        return upRes + "/" + downRes;
    }

    @GetMapping("/subFr")
    public String substractionFraction(@RequestParam("upF") int upF, @RequestParam("downF") int downF,
                                       @RequestParam("upS") int upS, @RequestParam("downS") int downS) {
        int downRes = downF * downS;
        int upRes = (downRes / downF * upF) - (downRes / downS * upS);
        return upRes + "/" + downRes;
    }

    @GetMapping("/multiFr")
    public String multiplyFraction(@RequestParam("upF") int upF, @RequestParam("downF") int downF,
                                   @RequestParam("upS") int upS, @RequestParam("downS") int downS) {
        return (upF * upS) + "/" + (downF * downS);
    }

    @GetMapping("/divFr")
    public String divideFraction(@RequestParam("upF") int upF, @RequestParam("downF") int downF,
                                 @RequestParam("upS") int upS, @RequestParam("downS") int downS) {
        return (upF * downS) + "/" + (downF * upS);
    }
}
