package com.ngabonzizacedrick.Portfolio.dto.progress;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardResponse {
    
    private List<LeaderboardEntry> entries;
    private Integer currentUserRank;
    private LeaderboardEntry currentUserEntry;
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LeaderboardEntry {
        private Integer rank;
        private Long userId;
        private String username;
        private String fullName;
        private String profilePictureUrl;
        private Integer totalPoints;
        private Integer challengesCompleted;
        private Double successRate;
        private Boolean isCurrentUser;
    }
}