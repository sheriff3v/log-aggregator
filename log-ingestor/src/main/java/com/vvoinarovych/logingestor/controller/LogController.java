package com.vvoinarovych.logingestor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
public class LogController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public LogController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<String> receiveLog(@RequestBody String log) {
        kafkaTemplate.send("logs", log);
        return ResponseEntity.ok("Log received");
    }
}
