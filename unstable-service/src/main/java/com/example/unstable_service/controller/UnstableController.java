package com.example.unstable_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class UnstableController {

    private final Random random = new Random();

    @GetMapping("/unstable")
    public String unstableEndpoint() throws InterruptedException {

        int delay = 200 + random.nextInt(1500); // 200–1700 ms
        Thread.sleep(delay);

        if (random.nextBoolean()) {
            throw new RuntimeException("Service FAILED randomly");
        }

        return "OK from Service after " + delay + " ms";
    }
}