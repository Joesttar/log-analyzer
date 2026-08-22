package com.devops.log_analyzer.service;

import com.devops.log_analyzer.model.LogEntry;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service

public class LogService {
    public List<LogEntry> getSampleLogs(){
        List<LogEntry> logs = new ArrayList<>();

        logs.add(new LogEntry(
            "LOG-101",
            LocalDateTime.now(),
            "INFO",
            "auth.service",
            "Usuario autenticado correctamente",
            120
        ));

        logs.add(new LogEntry (
            "LOG-102",
            LocalDateTime.now(),
            "ERROR",
            "database-service",
            "Fallo de conexion a la base de datos PostgreSQL",
            4500
        ));

        logs.add(new LogEntry(
            "LOG-103",
            LocalDateTime.now(),
            "WARN",
            "payment-service",
            "Tiempo de respuesta elevado en la pasarela de pago",
            2100
        ));

        logs.add(new LogEntry(
            "LOG-104",
            LocalDateTime.now().minusMinutes(10),
            "WARN",
            "payment-service",
            "Tiempo de respuesta elevada en la pasarela de pago",
            80
        ));

        return logs;
    }

    public List<LogEntry> getLogsByLevel(String level) {
        List<LogEntry> allLogs = getSampleLogs();

        if (level == null || level.trim().isEmpty()){
            return allLogs;
        }
        return allLogs.stream()
            .filter(log -> log.getLevel().equalsIgnoreCase(level))
            .collect(Collectors.toList());
    }    
}