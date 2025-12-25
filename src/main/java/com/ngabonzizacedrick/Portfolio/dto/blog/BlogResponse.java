package com.ngabonzizacedrick.Portfolio.dto.blog;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class BlogResponse {
    
    private Long id;
    private String title;
    private String slug;
    private String content;
    private String excerpt;
    private String featuredImageUrl;
    private CategoryResponse category;
    private Set<String> tags;
    private Set<String> metaKeywords;
    private String metaDescription;
    private Boolean published;
    private Boolean allowComments;
    private Integer viewCount;
    private Integer commentCount;
    private Integer readingTimeMinutes;
    private String authorName;
    private Long authorId;
    private LocalDateTime publishedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}