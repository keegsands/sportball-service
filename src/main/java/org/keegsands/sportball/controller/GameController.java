package org.keegsands.sportball.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/games")
public class GameController {
    @GetMapping()
    public String index() {
        return "Greetings from teams controller!";
    }
}
