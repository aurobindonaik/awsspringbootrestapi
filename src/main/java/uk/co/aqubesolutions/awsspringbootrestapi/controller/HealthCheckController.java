package uk.co.aqubesolutions.awsspringbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthz")
public class HealthCheckController {
    @GetMapping
    public String healthz(){
        return "{healthz:\"OK\"}";
    }
}
