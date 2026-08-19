package com.devops.log_analyzer.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LogEntry {
   private String id;
   private LocalDateTime timestamp;
   private String level;
   private String serviceName;
   private String message;
   private long responseTimeMs;
}