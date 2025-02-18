package org.keegsands.sportball.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController()
public class SportballController {
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
