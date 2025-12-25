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
class TestCaseRequest {
    
    @NotBlank(message = "Input is required")
    private String input;
    
    @NotBlank(message = "Expected output is required")
    private String expectedOutput;
    
    @NotNull(message = "Sample flag is required")
    private Boolean isSample; // Sample test cases are visible to users
    
    private String explanation;
}