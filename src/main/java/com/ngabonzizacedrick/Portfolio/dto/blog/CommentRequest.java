
package com.ngabonzizacedrick.Portfolio.dto.blog;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CommentRequest {
    
    @NotBlank(message = "Comment content is required")
    @Size(min = 3, max = 1000, message = "Comment must be between 3 and 1000 characters")
    private String content;
    
    private Long parentCommentId; // For nested replies
}