package com.ngabonzizacedrick.Portfolio.dto.progress;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgressSummaryResponse {
    
    private UserProgressStatsResponse stats;
    private List<RecentActivityItem> recentActivity;
    private List<UserProgressResponse> inProgressChallenges;
    private List<UserProgressResponse> recentlyCompleted;
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecentActivityItem {
        private String type; // COMPLETED, ATTEMPTED, ACHIEVEMENT_EARNED
        private String title;
        private String description;
        private Integer pointsEarned;
        private LocalDateTime timestamp;
    }
}