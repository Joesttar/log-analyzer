package com.devops.log_analyzer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LogEntry {
    id (string),
    timestamp (LocalDateTime),
    level (String -> "INFO", "WARN", "Error"),
    serviceName (String -> "payment-service"),
    message (string)
    
}