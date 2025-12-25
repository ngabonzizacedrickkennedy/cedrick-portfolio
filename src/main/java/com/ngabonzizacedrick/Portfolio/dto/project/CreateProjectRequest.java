package com.ngabonzizacedrick.Portfolio.dto.project;

import com.ngabonzizacedrick.Portfolio.model.Project;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CreateProjectRequest {
    
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 200, message = "Title must be between 3 and 200 characters")
    private String title;
    
    @NotBlank(message = "Description is required")
    @Size(min = 10, message = "Description must be at least 10 characters")
    private String description;
    
    private String detailedDescription;
    
    private List<String> technologies = new ArrayList<>();
    
    private Set<String> tags = new HashSet<>();
    
    private String videoUrl;
    
    private String thumbnailUrl;
    
    private List<String> imageUrls = new ArrayList<>();
    
    private String demoUrl;
    
    private String githubUrl;
    
    @NotNull(message = "Category is required")
    private Project.ProjectCategory category;
    
    private Boolean featured = false;
    
    private Boolean published = true;
    
    private Integer displayOrder;
    
    private String startDate;
    
    private String endDate;
}