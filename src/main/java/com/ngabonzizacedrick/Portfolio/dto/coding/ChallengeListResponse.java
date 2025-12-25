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
class ChallengeListResponse {
    
    private Long id;
    private String title;
    private String slug;
    private CodingChallenge.Difficulty difficulty;
    private CodingChallenge.Language language;
    private Set<String> tags;
    private Integer points;
    private Integer totalSubmissions;
    private Double successRate;
    private Boolean solved;
}