package io.github.akadir.circuitbreakerpoc.echo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/echo")
public class EchoController {
    private final String narcissusUrl;
    private final RestTemplate restTemplate;

    @Autowired
    public EchoController(RestTemplate restTemplate, @Value("${narcissus.url}") final String narcissusUrl) {
        this.restTemplate = restTemplate;
        this.narcissusUrl = narcissusUrl;
    }

    @GetMapping
    public String echo() {
        return restTemplate.getForObject(narcissusUrl, String.class);
    }
}
