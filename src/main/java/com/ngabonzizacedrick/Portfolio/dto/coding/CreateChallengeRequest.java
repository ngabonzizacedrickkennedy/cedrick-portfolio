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
class CreateChallengeRequest {
    
    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 200, message = "Title must be between 5 and 200 characters")
    private String title;
    
    @NotBlank(message = "Description is required")
    @Size(min = 20, message = "Description must be at least 20 characters")
    private String description;
    
    @NotNull(message = "Difficulty is required")
    private CodingChallenge.Difficulty difficulty;
    
    @NotNull(message = "Programming language is required")
    private CodingChallenge.Language language;
    
    @NotBlank(message = "Solution template is required")
    private String solutionTemplate;
    
    @NotNull(message = "Test cases are required")
    @Size(min = 1, message = "At least one test case is required")
    private List<TestCaseRequest> testCases;
    
    private Set<String> tags;
    
    @Min(value = 1, message = "Points must be at least 1")
    @Max(value = 1000, message = "Points cannot exceed 1000")
    private Integer points;
    
    @Min(value = 1, message = "Time limit must be at least 1 second")
    @Max(value = 60, message = "Time limit cannot exceed 60 seconds")
    private Integer timeLimitSeconds;
    
    @Min(value = 1, message = "Memory limit must be at least 1 MB")
    @Max(value = 512, message = "Memory limit cannot exceed 512 MB")
    private Integer memoryLimitMB;
    
    private String hints;
    
    private String editorialSolution;
    
    private Boolean active = true;
}
