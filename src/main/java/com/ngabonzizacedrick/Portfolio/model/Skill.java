package com.ngabonzizacedrick.Portfolio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "skills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill extends BaseEntity {

    @NotBlank(message = "Skill name is required")
    @Size(min = 2, max = 100)
    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SkillCategory category;

    @Min(value = 0, message = "Proficiency must be between 0 and 100")
    @Max(value = 100, message = "Proficiency must be between 0 and 100")
    @Column(nullable = false)
    private Integer proficiency; // 0-100

    @Min(value = 0, message = "Years of experience cannot be negative")
    @Column(name = "years_experience")
    private Double yearsExperience;

    @Column(name = "icon_url")
    private String iconUrl; // URL to skill icon/logo

    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(nullable = false)
    private Boolean visible = true;

    public enum SkillCategory {
        FRONTEND,
        BACKEND,
        DATABASE,
        DEVOPS,
        MOBILE,
        CLOUD,
        TOOLS,
        SOFT_SKILLS,
        LANGUAGES,
        FRAMEWORKS,
        OTHER
    }

    public SkillLevel getSkillLevel() {
        if (proficiency >= 80) return SkillLevel.EXPERT;
        if (proficiency >= 60) return SkillLevel.ADVANCED;
        if (proficiency >= 40) return SkillLevel.INTERMEDIATE;
        return SkillLevel.BEGINNER;
    }

    public enum SkillLevel {
        BEGINNER,
        INTERMEDIATE,
        ADVANCED,
        EXPERT
    }
}