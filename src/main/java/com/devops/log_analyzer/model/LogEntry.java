package com.devops.log_analyzer.model;

import java.time.LocalDateTime;

public class LogEntry {
   private String id;
   private LocalDateTime timestamp;
   private String level;
   private String serviceName;
   private String message;
   private long responseTimeMs;


public LogEntry() {}

public LogEntry(String id, LocalDateTime timestamp, String level, String serviceName, String message, long responseTimeMs){
   this.id = id;
   this.timestamp = timestamp;
   this.level = level;
   this.serviceName = serviceName;
   this.message = message;
   this.responseTimeMs = responseTimeMs;
}

public String getId() { return id;}
public void setId(String id) { this.id = id; }

public LocalDateTime getTimestamp() { return timestamp; }
public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

public String getLevel() { return level; }
public void setLevel(String level) { this.level = level; }

public String getServiceName() { return serviceName; }
public void setServiceName(String serviceName) { this.serviceName = serviceName; }

public String getMessage(){ return message; }
public void setMessage(String message) { this.message = message; }

public long getResponseTimeMs() { return responseTimeMs; }
public void setReponseTimeMs(long responseTimeMs) { this.responseTimeMs = responseTimeMs; }

@Override

public String toString(){
   return "LogEntry{" +
         "id='" + id + '\'' +
         ", timestamp= " + timestamp +
         ", level='" + level + '\'' +
         ", serviceName='" + serviceName + '\'' +
         ", message='" + message + '\'' +
         ", reponseTimeMs=" + responseTimeMs +
         '}';
   }
}