package com.ngabonzizacedrick.Portfolio.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardStatsResponse {
    
    // Overview stats
    private OverviewStats overview;
    
    // Content stats
    private ContentStats content;
    
    // User engagement
    private EngagementStats engagement;
    
    // Coding platform stats
    private CodingPlatformStats codingPlatform;
    
    // Recent activities
    private List<ActivityItem> recentActivities;
    
    // Charts data
    private Map<String, Object> chartsData;
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OverviewStats {
        private Long totalUsers;
        private Long totalProjects;
        private Long totalBlogs;
        private Long totalSkills;
        private Long totalContactMessages;
        private Long unreadMessages;
        private Long totalCodingChallenges;
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ContentStats {
        private Long publishedProjects;
        private Long draftProjects;
        private Long featuredProjects;
        private Long publishedBlogs;
        private Long draftBlogs;
        private Long featuredBlogs;
        private Long totalBlogViews;
        private Long totalProjectViews;
        private Long totalComments;
        private Long pendingComments;
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EngagementStats {
        private Long totalViews;
        private Long viewsThisWeek;
        private Long viewsThisMonth;
        private Double averageViewsPerDay;
        private Long totalComments;
        private Long commentsThisWeek;
        private Long contactMessagesThisWeek;
        private Long contactMessagesThisMonth;
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CodingPlatformStats {
        private Long totalChallenges;
        private Long activeChallenges;
        private Long totalSubmissions;
        private Long successfulSubmissions;
        private Double overallSuccessRate;
        private Long activeUsers;
        private Long totalAchievements;
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ActivityItem {
        private String type; // PROJECT_CREATED, BLOG_PUBLISHED, USER_REGISTERED, etc.
        private String description;
        private String timestamp;
        private String icon;
        private String color;
    }
}