package com.ngabonzizacedrick.Portfolio.dto.blog;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class UpdateBlogRequest {
    
    @Size(min = 5, max = 200, message = "Title must be between 5 and 200 characters")
    private String title;
    
    @Size(min = 50, message = "Content must be at least 50 characters")
    private String content;
    
    @Size(max = 300, message = "Excerpt cannot exceed 300 characters")
    private String excerpt;
    
    private String featuredImageUrl;
    
    private Long categoryId;
    
    private Set<String> tags;
    
    private Set<String> metaKeywords;
    
    @Size(max = 160, message = "Meta description cannot exceed 160 characters")
    private String metaDescription;
    
    private Boolean published;
    
    private Boolean allowComments;
}