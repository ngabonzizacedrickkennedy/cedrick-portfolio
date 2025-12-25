package com.ngabonzizacedrick.Portfolio.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalyticsResponse {
    
    private ViewsAnalytics views;
    private ContentAnalytics content;
    private UserAnalytics users;
    private PopularContentAnalytics popular;
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ViewsAnalytics {
        private List<DailyViews> dailyViews;
        private Map<String, Long> viewsBySource;
        private Map<String, Long> viewsByDevice;
        
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class DailyViews {
            private LocalDate date;
            private Long projectViews;
            private Long blogViews;
            private Long totalViews;
        }
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ContentAnalytics {
        private Map<String, Long> blogsByCategory;
        private Map<String, Long> projectsByCategory;
        private List<TagAnalytics> topTags;
        private Double averageReadingTime;
        
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class TagAnalytics {
            private String tag;
            private Long count;
            private Long views;
        }
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserAnalytics {
        private List<DailyUserActivity> dailyActivity;
        private Map<String, Long> usersByRole;
        private Long activeUsers;
        private Long newUsersThisWeek;
        
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class DailyUserActivity {
            private LocalDate date;
            private Long registrations;
            private Long activeUsers;
            private Long submissions;
        }
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PopularContentAnalytics {
        private List<PopularItem> topProjects;
        private List<PopularItem> topBlogs;
        private List<PopularItem> topChallenges;
        
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class PopularItem {
            private Long id;
            private String title;
            private Long views;
            private Long interactions; // comments, submissions, etc.
        }
    }
}