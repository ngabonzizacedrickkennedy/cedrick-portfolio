package com.ngabonzizacedrick.Portfolio.dto.skill;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class BulkUpdateDisplayOrderRequest {
    
    @NotNull(message = "Skill order list is required")
    private List<SkillOrderItem> skills;
    
}