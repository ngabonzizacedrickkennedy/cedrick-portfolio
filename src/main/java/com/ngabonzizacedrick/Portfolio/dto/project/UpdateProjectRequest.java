package com.ngabonzizacedrick.Portfolio.dto.project;
import com.ngabonzizacedrick.Portfolio.model.Project;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class UpdateProjectRequest {
    
    @Size(min = 3, max = 200, message = "Title must be between 3 and 200 characters")
    private String title;
    
    @Size(min = 10, message = "Description must be at least 10 characters")
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
    
    private Integer displayOrder;
    
    private String startDate;
    
    private String endDate;
}