package com.devops.log_analyzer.service; // <--- Fíjate que tenga el "_" y sea "service"

import com.devops.log_analyzer.model.LogEntry;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogService {
    private final List<LogEntry> logs = new ArrayList<>();

    public void saveLog(LogEntry entry) {
        logs.add(entry);
        saveToFile(entry);
    }

    private void saveToFile(LogEntry entry) {
        try (FileWriter fw = new FileWriter("logs_output.txt", true);
             PrintWriter out = new PrintWriter(fw)) {
            
            String logLine = String.format("[%s] %s - %s: %s (%d ms)",
                    entry.getTimestamp(), 
                    entry.getLevel(),
                    entry.getServiceName(),
                    entry.getMessage(),
                    entry.getResponseTimeMs());
            
            out.println(logLine);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public List<LogEntry> getAllLogs() {
        return logs;
    }

    public List<LogEntry> getLogsByLevel(String level) {
        return logs.stream()
                   .filter(log -> log.getLevel().equalsIgnoreCase(level))
                   .collect(Collectors.toList());
    }

    public java.util.Map<String, Long> getStats(){
        return logs.stream()
            .collect(Collectors.groupingBy(
                LogEntry::getLevel,
                Collectors.counting()
            ));
    }

}