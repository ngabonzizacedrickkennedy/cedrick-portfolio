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
public class ContactMessageListResponse {
    
    private Long id;
    private String name;
    private String email;
    private String subject;
    private Boolean read;
    private Boolean replied;
    private ContactMessage.MessageStatus status;
    private LocalDateTime createdAt;
}