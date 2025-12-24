package com.ngabonzizacedrick.Portfolio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "contact_messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactMessage extends BaseEntity {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100)
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(nullable = false)
    private String email;

    @Size(max = 20)
    private String phone;

    @NotBlank(message = "Subject is required")
    @Size(min = 5, max = 200)
    @Column(nullable = false)
    private String subject;

    @NotBlank(message = "Message is required")
    @Size(min = 10)
    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(nullable = false)
    private Boolean read = false;

    @Column(nullable = false)
    private Boolean replied = false;

    @Column(columnDefinition = "TEXT")
    private String replyMessage;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageStatus status;

    public enum MessageStatus {
        NEW,
        READ,
        REPLIED,
        ARCHIVED,
        SPAM
    }

    public void markAsRead() {
        this.read = true;
        if (this.status == MessageStatus.NEW) {
            this.status = MessageStatus.READ;
        }
    }

    public void markAsReplied(String reply) {
        this.replied = true;
        this.replyMessage = reply;
        this.status = MessageStatus.REPLIED;
    }
}