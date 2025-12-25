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
class ProjectListResponse {
    
    private Long id;
    private String title;
    private String description; // Short description only
    private List<String> technologies;
    private Set<String> tags;
    private String thumbnailUrl;
    private String demoUrl;
    private String githubUrl;
    private Project.ProjectCategory category;
    private Boolean featured;
    private Integer viewCount;
    private String startDate;
    private String endDate;
    private LocalDateTime createdAt;
}
