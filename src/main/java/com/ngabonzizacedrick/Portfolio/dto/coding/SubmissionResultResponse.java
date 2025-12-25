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
class SubmissionResultResponse {
    
    private Long submissionId;
    private Boolean success;
    private String status; // ACCEPTED, WRONG_ANSWER, TIME_LIMIT_EXCEEDED, RUNTIME_ERROR, COMPILATION_ERROR
    private Integer passedTestCases;
    private Integer totalTestCases;
    private List<TestCaseResultResponse> testResults;
    private Integer executionTimeMs;
    private Integer memoryUsedKB;
    private Integer pointsEarned;
    private String errorMessage;
    private LocalDateTime submittedAt;
}
