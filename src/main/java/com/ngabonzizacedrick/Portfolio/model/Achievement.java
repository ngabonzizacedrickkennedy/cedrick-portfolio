package com.ngabonzizacedrick.Portfolio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "achievements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Achievement extends BaseEntity {

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100)
    @Column(nullable = false, unique = true)
    private String title;

    @NotBlank(message = "Description is required")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "badge_color")
    private String badgeColor; // For UI theming

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AchievementType type;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AchievementRarity rarity;

    @Min(value = 0)
    @Column(nullable = false)
    private Integer pointsRequired = 0;

    @Min(value = 0)
    @Column(name = "challenges_required")
    private Integer challengesRequired = 0;

    @Column(nullable = false)
    private Boolean active = true;

    @ManyToMany(mappedBy = "achievements")
    private Set<User> users = new HashSet<>();

    public enum AchievementType {
        FIRST_STEPS,           // First challenge completed
        PROBLEM_SOLVER,        // N challenges completed
        SPEED_DEMON,           // Fast solution completion
        PERFECTIONIST,         // All test cases passed first try
        CONSISTENT_LEARNER,    // Daily streak
        LANGUAGE_MASTER,       // Master a specific language
        DIFFICULTY_CONQUEROR,  // Complete all challenges of a difficulty
        POINT_MILESTONE,       // Reach X points
        COMMUNITY_CONTRIBUTOR, // Comments/helpful feedback
        SPECIAL_EVENT          // Limited-time achievements
    }

    public enum AchievementRarity {
        COMMON,
        UNCOMMON,
        RARE,
        EPIC,
        LEGENDARY
    }

    @Entity
    @Table(name = "user_achievements",
           uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "achievement_id"}))
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserAchievement extends BaseEntity {
        
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        private User user;
        
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "achievement_id", nullable = false)
        private Achievement achievement;
        
        @Column(name = "earned_at", nullable = false)
        private LocalDateTime earnedAt;
        
        @Column(name = "progress_percentage")
        private Integer progressPercentage = 0;
        
        @Column(nullable = false)
        private Boolean unlocked = false;
        
        public void unlock() {
            this.unlocked = true;
            this.earnedAt = LocalDateTime.now();
            this.progressPercentage = 100;
        }
    }

    public Integer getUserCount() {
        return users != null ? users.size() : 0;
    }
}