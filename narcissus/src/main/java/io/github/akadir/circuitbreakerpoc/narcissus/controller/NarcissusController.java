package io.github.akadir.circuitbreakerpoc.narcissus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/narcissus")
public class NarcissusController {

    @GetMapping
    public String narcissus() {
        return "Narcissus called by Echo";
    }
}
