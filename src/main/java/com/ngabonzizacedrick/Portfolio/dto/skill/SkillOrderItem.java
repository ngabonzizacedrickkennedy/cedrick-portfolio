package com.ngabonzizacedrick.Portfolio.dto.skill;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


 @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class SkillOrderItem {
        @NotNull(message = "Skill ID is required")
        private Long id;
        
        @NotNull(message = "Display order is required")
        private Integer displayOrder;
    }
