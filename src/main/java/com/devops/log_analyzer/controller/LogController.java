package com.devops.log_analyzer.controller;

import com.devops.log_analyzer.model.LogEntry;
import com.devops.log_analyzer.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/logs")

public class LogController {

    public final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/health")
    public String checkHealth() {
        return "El analizador de logs está funcionando correctamente.";
    }

    @GetMapping
    public List<LogEntry> getAllLogs() {
        return logService.getSampleLogs();
    }
}