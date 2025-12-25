package com.ngabonzizacedrick.Portfolio.dto.project;

import com.ngabonzizacedrick.Portfolio.model.Project;

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
class ProjectResponse {
    
    private Long id;
    private String title;
    private String description;
    private String detailedDescription;
    private List<String> technologies;
    private Set<String> tags;
    private String videoUrl;
    private String thumbnailUrl;
    private List<String> imageUrls;
    private String demoUrl;
    private String githubUrl;
    private Project.ProjectCategory category;
    private Boolean featured;
    private Boolean published;
    private Integer viewCount;
    private Integer displayOrder;
    private String startDate;
    private String endDate;
    private String createdByName;
    private Long createdById;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}