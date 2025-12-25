package com.ngabonzizacedrick.Portfolio.dto.blog;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CreateBlogRequest {
    
    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 200, message = "Title must be between 5 and 200 characters")
    private String title;
    
    @NotBlank(message = "Content is required")
    @Size(min = 50, message = "Content must be at least 50 characters")
    private String content;
    
    @NotBlank(message = "Excerpt is required")
    @Size(max = 300, message = "Excerpt cannot exceed 300 characters")
    private String excerpt;
    
    private String featuredImageUrl;
    
    @NotNull(message = "Category ID is required")
    private Long categoryId;
    
    private Set<String> tags = new HashSet<>();
    
    private Set<String> metaKeywords = new HashSet<>();
    
    @Size(max = 160, message = "Meta description cannot exceed 160 characters")
    private String metaDescription;
    
    private Boolean published = false;
    
    private Boolean allowComments = true;
}