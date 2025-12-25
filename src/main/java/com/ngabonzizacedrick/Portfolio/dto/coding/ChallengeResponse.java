package com.ngabonzizacedrick.Portfolio.dto.coding;

import com.ngabonzizacedrick.Portfolio.model.CodingChallenge;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ChallengeResponse {
    
    private Long id;
    private String title;
    private String slug;
    private String description;
    private CodingChallenge.DifficultyLevel difficulty;
    private CodingChallenge.ProgrammingLanguage language;
    private String solutionTemplate;
    private List<TestCaseResponse> sampleTestCases; // Only sample test cases
    private Set<String> tags;
    private Integer points;
    private Integer timeLimitSeconds;
    private Integer memoryLimitMB;
    private String hints;
    private Integer totalSubmissions;
    private Integer successfulSubmissions;
    private Double successRate;
    private Boolean active;
    private Boolean solved; // Has current user solved this?
    private LocalDateTime createdAt;
}