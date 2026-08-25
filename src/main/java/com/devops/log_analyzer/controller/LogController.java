package com.devops.log_analyzer.controller;

import com.devops.log_analyzer.model.LogEntry;
import com.devops.log_analyzer.service.LogService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("api/logs")

public class LogController {

  private final LogService logService;

    // Inyección de dependencias: Spring nos da el servicio automáticamente
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/health")
    public String checkHealth() {
        return "Log Analyzer Service is UP - " + LocalDateTime.now();
    }

    @PostMapping
    public String receiveLog(@RequestBody LogEntry logEntry) {
        logService.saveLog(logEntry); // Guardamos el log en la lista
        System.out.println("Log guardado de: " + logEntry.getServiceName());
        return "Log procesado y guardado correctamente";
    }

    @GetMapping
    public List<LogEntry> getAllLogs() {
        return logService.getAllLogs(); // Retornamos todos los logs guardados
    }

    @GetMapping("/filter")
        public List<LogEntry> filterLogs(@RequestParam String level){
            // RequestParam captura todo lo que venga despues del signo '?' en un URL
            return logService.getLogsByLevel((level));
        }
}