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
class SubmitSolutionRequest {
    
    @NotNull(message = "Challenge ID is required")
    private Long challengeId;
    
    @NotBlank(message = "Solution code is required")
    private String code;
    
    @NotNull(message = "Language is required")
    private CodingChallenge.Language language;
}