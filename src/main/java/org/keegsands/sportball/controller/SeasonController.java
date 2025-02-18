package org.keegsands.sportball.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/seasons")
public class SeasonController {
    @GetMapping()
    public String index() {
        return "Greetings from season controller!";
    }
}
