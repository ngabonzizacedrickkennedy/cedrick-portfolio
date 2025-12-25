
package com.ngabonzizacedrick.Portfolio.dto.blog;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CommentResponse {
    
    private Long id;
    private String content;
    private String authorName;
    private Long authorId;
    private Long parentCommentId;
    private Boolean approved;
    private Boolean edited;
    private List<CommentResponse> replies; // Nested comments
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}