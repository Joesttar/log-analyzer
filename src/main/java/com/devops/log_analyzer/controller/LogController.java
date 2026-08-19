package com.devops.log_analyzer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devops.log_analyzer.model.LogEntry;


@RestController
@RequestMapping("api/logs")

public class LogController {

    @GetMapping("/health")
    public String checkHealth() {
        return "Log Analyzer Service is up and running";
    }

    @PostMapping
    public String receiveLog(@RequestBody LogEntry logEntry) {
        System.out.println("Log recibido: " + logEntry);

        return "Log procesado exitosamente con ID: " + logEntry.getId();
    }
}