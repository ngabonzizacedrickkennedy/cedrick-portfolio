package com.ngabonzizacedrick.Portfolio.dto.coding;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class TestCaseResultResponse {
    
    private Integer testCaseNumber;
    private Boolean passed;
    private String input;
    private String expectedOutput;
    private String actualOutput;
    private String errorMessage;
    private Integer executionTimeMs;
}