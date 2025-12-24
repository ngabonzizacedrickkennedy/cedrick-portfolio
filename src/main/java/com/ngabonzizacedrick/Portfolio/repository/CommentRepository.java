package com.ngabonzizacedrick.Portfolio.repository;

import com.ngabonzizacedrick.Portfolio.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
    // Blog comments
    List<Comment> findByBlog_Id(Long blogId);
    
    List<Comment> findByBlog_IdAndApproved(Long blogId, Boolean approved);
    
    Page<Comment> findByBlog_IdAndApproved(Long blogId, Boolean approved, Pageable pageable);
    
    // Parent comments (top-level comments)
    List<Comment> findByBlog_IdAndParentCommentIsNullAndApproved(Long blogId, Boolean approved);
    
    // Replies to a comment
    List<Comment> findByParentComment_Id(Long parentCommentId);
    
    List<Comment> findByParentComment_IdAndApproved(Long parentCommentId, Boolean approved);
    
    // User comments
    List<Comment> findByUser_Id(Long userId);
    
    Page<Comment> findByUser_Id(Long userId, Pageable pageable);
    
    List<Comment> findByUser_IdAndApproved(Long userId, Boolean approved);
    
    // Approval status
    List<Comment> findByApproved(Boolean approved);
    
    Page<Comment> findByApproved(Boolean approved, Pageable pageable);
    
    List<Comment> findByApprovedOrderByCreatedAtDesc(Boolean approved);
    
    // Recent comments
    List<Comment> findTop10ByApprovedOrderByCreatedAtDesc(Boolean approved);
    
    // Count queries
    long countByBlog_Id(Long blogId);
    
    long countByBlog_IdAndApproved(Long blogId, Boolean approved);
    
    long countByUser_Id(Long userId);
    
    long countByApproved(Boolean approved);
    
    @Query("SELECT COUNT(c) FROM Comment c WHERE c.blog.id = :blogId AND c.parentComment IS NULL AND c.approved = true")
    long countTopLevelCommentsByBlogId(@Param("blogId") Long blogId);
    
    // Check if user has commented on blog
    boolean existsByBlog_IdAndUser_Id(Long blogId, Long userId);
}