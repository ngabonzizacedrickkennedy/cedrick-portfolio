package com.ngabonzizacedrick.Portfolio.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_progress", 
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "challenge_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProgress extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", nullable = false)
    private CodingChallenge challenge;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProgressStatus status;

    @Column(name = "submitted_code", columnDefinition = "TEXT")
    private String submittedCode;

    @Column(nullable = false)
    private Integer attempts = 0;

    @Column(name = "test_cases_passed")
    private Integer testCasesPassed = 0;

    @Column(name = "total_test_cases")
    private Integer totalTestCases = 0;

    @Column(name = "execution_time_ms")
    private Long executionTimeMs;

    @Column(name = "memory_used_mb")
    private Integer memoryUsedMb;

    @Column(name = "points_earned")
    private Integer pointsEarned = 0;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "first_attempted_at")
    private LocalDateTime firstAttemptedAt;

    @Column(name = "last_attempted_at")
    private LocalDateTime lastAttemptedAt;

    @Column(columnDefinition = "TEXT")
    private String feedback;

    @Column(name = "is_optimal_solution")
    private Boolean isOptimalSolution = false;

    public enum ProgressStatus {
        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED,
        FAILED
    }

    public void recordAttempt() {
        this.attempts++;
        this.lastAttemptedAt = LocalDateTime.now();
        if (this.firstAttemptedAt == null) {
            this.firstAttemptedAt = LocalDateTime.now();
        }
        if (this.status == ProgressStatus.NOT_STARTED) {
            this.status = ProgressStatus.IN_PROGRESS;
        }
    }

    public void markAsCompleted(Integer points) {
        this.status = ProgressStatus.COMPLETED;
        this.completedAt = LocalDateTime.now();
        this.pointsEarned = points;
    }

    public void markAsFailed() {
        this.status = ProgressStatus.FAILED;
    }

    public Double getSuccessRate() {
        if (totalTestCases == 0) return 0.0;
        return (testCasesPassed * 100.0) / totalTestCases;
    }

    public Boolean isPassed() {
        return testCasesPassed != null && 
               totalTestCases != null && 
               testCasesPassed.equals(totalTestCases);
    }
}