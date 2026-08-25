package com.devops.log_analyzer.model;

import java.time.LocalDateTime;

public class LogEntry {
    private String id;
    private LocalDateTime timestamp;
    private String level;
    private String serviceName;
    private String message;
    private long responseTimeMs;

    // Constructor vacío (necesario para Spring)
    public LogEntry() {}

    // Constructor con todos los campos
    public LogEntry(String id, LocalDateTime timestamp, String level, String serviceName, String message, long responseTimeMs) {
        this.id = id;
        this.timestamp = timestamp;
        this.level = level;
        this.serviceName = serviceName;
        this.message = message;
        this.responseTimeMs = responseTimeMs;
    }

    // --- GETTERS (Lo que el compilador no encontraba) ---
    public String getId() { return id; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getLevel() { return level; }
    public String getServiceName() { return serviceName; }
    public String getMessage() { return message; }
    public long getResponseTimeMs() { return responseTimeMs; }

    // --- SETTERS ---
    public void setId(String id) { this.id = id; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public void setLevel(String level) { this.level = level; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
    public void setMessage(String message) { this.message = message; }
    public void setResponseTimeMs(long responseTimeMs) { this.responseTimeMs = responseTimeMs; }
}