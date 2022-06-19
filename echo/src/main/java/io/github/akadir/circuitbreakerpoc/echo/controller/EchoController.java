package io.github.akadir.circuitbreakerpoc.echo.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
    @CircuitBreaker(name = "echoCircuitBreaker", fallbackMethod = "echoFallback")
    public String echo() {
        return restTemplate.getForObject(narcissusUrl, String.class);
    }

    public String echoFallback(Exception e) {
        return "Narcissus is not responding to me, I think I'm gonna die. Reason: " + e.getMessage() + "\n";
    }
}
