package com.devops.log_analyzer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devops.log_analyzer.model.LogEntry;
import com.devops.log_analyzer.service.LogService;


@RestController
@RequestMapping("api/logs")

public class LogController {

 private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/health")
    public String checkHealth() {
        return "El analizador de logs está funcionando correctamente.";
    }

    // @RequestParam(required = false) hace que el parámetro ?level= sea opcional
    @GetMapping
    public List<LogEntry> getLogs(@RequestParam(required = false) String level) {
        return logService.getLogsByLevel(level);
    }
}