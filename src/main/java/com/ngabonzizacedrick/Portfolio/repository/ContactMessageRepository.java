package com.ngabonzizacedrick.Portfolio.repository;

import com.ngabonzizacedrick.Portfolio.model.ContactMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
    
    // Basic queries
    List<ContactMessage> findByRead(Boolean read);
    
    Page<ContactMessage> findByRead(Boolean read, Pageable pageable);
    
    List<ContactMessage> findByReplied(Boolean replied);
    
    Page<ContactMessage> findByReplied(Boolean replied, Pageable pageable);
    
    // Status queries
    List<ContactMessage> findByStatus(ContactMessage.MessageStatus status);
    
    Page<ContactMessage> findByStatus(ContactMessage.MessageStatus status, Pageable pageable);
    
    List<ContactMessage> findByStatusOrderByCreatedAtDesc(ContactMessage.MessageStatus status);
    
    // Email queries
    List<ContactMessage> findByEmail(String email);
    
    Page<ContactMessage> findByEmail(String email, Pageable pageable);
    
    // Recent messages
    List<ContactMessage> findTop10ByOrderByCreatedAtDesc();
    
    @Query("SELECT cm FROM ContactMessage cm WHERE cm.status = :status ORDER BY cm.createdAt DESC")
    List<ContactMessage> findRecentByStatus(@Param("status") ContactMessage.MessageStatus status, Pageable pageable);
    
    // Unread messages
    @Query("SELECT cm FROM ContactMessage cm WHERE cm.read = false ORDER BY cm.createdAt DESC")
    List<ContactMessage> findUnreadMessages();
    
    long countByRead(Boolean read);
    
    // Unreplied messages
    @Query("SELECT cm FROM ContactMessage cm WHERE cm.replied = false AND cm.status <> 'SPAM' ORDER BY cm.createdAt DESC")
    List<ContactMessage> findUnrepliedMessages();
    
    long countByReplied(Boolean replied);
    
    // Date range queries
    @Query("SELECT cm FROM ContactMessage cm WHERE cm.createdAt BETWEEN :start AND :end ORDER BY cm.createdAt DESC")
    List<ContactMessage> findMessagesBetweenDates(
        @Param("start") LocalDateTime start,
        @Param("end") LocalDateTime end
    );
    
    // Search queries
    @Query("SELECT cm FROM ContactMessage cm WHERE " +
           "LOWER(cm.name) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(cm.email) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(cm.subject) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(cm.message) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<ContactMessage> searchMessages(@Param("search") String search, Pageable pageable);
    
    // Count queries
    long countByStatus(ContactMessage.MessageStatus status);
    
    @Query("SELECT COUNT(cm) FROM ContactMessage cm WHERE cm.createdAt >= :since")
    long countMessagesSince(@Param("since") LocalDateTime since);
    
    // Statistics
    @Query("SELECT cm.status, COUNT(cm) FROM ContactMessage cm GROUP BY cm.status")
    List<Object[]> getMessageCountByStatus();
    
    @Query("SELECT DATE(cm.createdAt), COUNT(cm) FROM ContactMessage cm WHERE cm.createdAt >= :since GROUP BY DATE(cm.createdAt) ORDER BY DATE(cm.createdAt)")
    List<Object[]> getMessageCountByDay(@Param("since") LocalDateTime since);
}