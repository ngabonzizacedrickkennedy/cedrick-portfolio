package com.ngabonzizacedrick.Portfolio.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemHealthResponse {
    
    private String status; // HEALTHY, DEGRADED, DOWN
    private LocalDateTime timestamp;
    private DatabaseHealth database;
    private StorageHealth storage;
    private ApiHealth api;
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatabaseHealth {
        private String status;
        private Long responseTimeMs;
        private Long totalRecords;
        private String databaseSize;
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StorageHealth {
        private String status;
        private Long totalFiles;
        private String usedSpace;
        private String availableSpace;
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ApiHealth {
        private String status;
        private Long averageResponseTimeMs;
        private Long requestsPerMinute;
        private Long errorRate;
    }
}