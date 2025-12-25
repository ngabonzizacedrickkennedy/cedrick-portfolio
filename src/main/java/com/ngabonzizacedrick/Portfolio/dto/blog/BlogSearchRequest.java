package com.ngabonzizacedrick.Portfolio.dto.blog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class BlogSearchRequest {
    
    private String query;
    private Long categoryId;
    private Set<String> tags;
    private Boolean published;
    private String sortBy = "createdAt"; // createdAt, viewCount, title
    private String sortDirection = "DESC";
    private Integer page = 0;
    private Integer size = 10;
}