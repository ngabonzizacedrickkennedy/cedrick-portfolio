package com.ngabonzizacedrick.Portfolio.dto.contact;

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
public class ReplyMessageRequest {
    
    @NotBlank(message = "Reply message is required")
    @Size(min = 10, max = 5000, message = "Reply must be between 10 and 5000 characters")
    private String replyMessage;
    
    private Boolean sendEmail = true; // Whether to send the reply via email
}
