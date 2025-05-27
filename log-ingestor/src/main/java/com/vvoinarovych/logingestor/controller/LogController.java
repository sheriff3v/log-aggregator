package com.vvoinarovych.logingestor.controller;

import com.vvoinarovych.model.LogMessage;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
@AllArgsConstructor
public class LogController {
    private final KafkaTemplate<String, LogMessage> kafkaTemplate;


    @PostMapping
    public ResponseEntity<String> receiveLog(@RequestBody LogMessage log) {
        kafkaTemplate.send("logs", log);
        return ResponseEntity.ok("Log received");
    }
}
