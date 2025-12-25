package com.ngabonzizacedrick.Portfolio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "coding_challenges")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodingChallenge extends BaseEntity {

    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 200)
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Slug is required")
    @Column(nullable = false, unique = true)
    private String slug;

    @NotBlank(message = "Description is required")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String detailedDescription;

    @Column(columnDefinition = "TEXT")
    private String hints;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficulty;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProgrammingLanguage language;

    @Column(name = "starter_code", columnDefinition = "TEXT")
    private String starterCode;

    @Column(name = "solution_code", columnDefinition = "TEXT")
    private String solutionCode;

    @ElementCollection
    @CollectionTable(name = "challenge_test_cases", joinColumns = @JoinColumn(name = "challenge_id"))
    private List<TestCase> testCases = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "challenge_tags", joinColumns = @JoinColumn(name = "challenge_id"))
    @Column(name = "tag")
    private Set<String> tags = new HashSet<>();

    @Min(value = 0)
    @Column(nullable = false)
    private Integer points = 10;

    @Min(value = 0)
    @Column(name = "time_limit_seconds")
    private Integer timeLimitSeconds = 5;

    @Min(value = 0)
    @Column(name = "memory_limit_mb")
    private Integer memoryLimitMb = 128;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(nullable = false)
    private Integer attemptCount = 0;

    @Column(nullable = false)
    private Integer successCount = 0;

    @Column(name = "display_order")
    private Integer displayOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private User createdBy;

    // Enums
    public enum DifficultyLevel {
        EASY,
        MEDIUM,
        HARD,
        EXPERT
    }

    public enum ProgrammingLanguage {
        JAVA,
        PYTHON,
        JAVASCRIPT,
        TYPESCRIPT,
        C_PLUS_PLUS,
        C_SHARP,
        GO,
        RUST,
        PHP,
        RUBY
    }

    // Inner Embeddable Class for TestCase
    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class TestCase {
        
        @Column(name = "input", columnDefinition = "TEXT", nullable = false)
        private String input;
        
        @Column(name = "expected_output", columnDefinition = "TEXT", nullable = false)
        private String expectedOutput;
        
        @Column(name = "is_sample", nullable = false)
        private Boolean isSample = false;
        
        @Column(name = "explanation", columnDefinition = "TEXT")
        private String explanation;
        
        @Column(name = "test_order")
        private Integer testOrder;
    }

    // Business methods
    public void incrementAttemptCount() {
        this.attemptCount++;
    }

    public void incrementSuccessCount() {
        this.successCount++;
    }

    public Double getSuccessRate() {
        if (attemptCount == 0) return 0.0;
        return (successCount * 100.0) / attemptCount;
    }
    
    public List<TestCase> getSampleTestCases() {
        return testCases.stream()
                .filter(TestCase::getIsSample)
                .toList();
    }
    
    public List<TestCase> getHiddenTestCases() {
        return testCases.stream()
                .filter(tc -> !tc.getIsSample())
                .toList();
    }
}