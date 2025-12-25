package com.ngabonzizacedrick.Portfolio.dto.contact;

import com.ngabonzizacedrick.Portfolio.model.ContactMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactMessageResponse {
    
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String subject;
    private String message;
    private Boolean read;
    private Boolean replied;
    private String replyMessage;
    private ContactMessage.MessageStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}