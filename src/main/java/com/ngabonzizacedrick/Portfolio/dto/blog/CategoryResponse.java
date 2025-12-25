package com.ngabonzizacedrick.Portfolio.dto.blog;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CategoryResponse {
    
    private Long id;
    private String name;
    private String slug;
    private String description;
    private Integer blogCount;
}