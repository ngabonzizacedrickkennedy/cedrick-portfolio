package com.ngabonzizacedrick.Portfolio.dto.project;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class UploadVideoRequest {
    
    @NotNull(message = "Project ID is required")
    private Long projectId;
    
   
    private String videoTitle;
    
    private String videoDescription;
}