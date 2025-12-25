package com.ngabonzizacedrick.Portfolio.dto.skill;

import com.ngabonzizacedrick.Portfolio.model.Skill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Map;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class SkillsByCategoryResponse {
    
    private Map<Skill.SkillCategory, List<SkillResponse>> skillsByCategory;
    private Integer totalSkills;
    private Double averageProficiency;
}