package com.ngabonzizacedrick.Portfolio.repository;

import com.ngabonzizacedrick.Portfolio.model.Blog;
import com.ngabonzizacedrick.Portfolio.model.BlogCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    
    // Basic queries
    Optional<Blog> findBySlug(String slug);
    
    Optional<Blog> findBySlugAndPublished(String slug, Boolean published);
    
    List<Blog> findByPublished(Boolean published);
    
    Page<Blog> findByPublished(Boolean published, Pageable pageable);
    
    List<Blog> findByFeatured(Boolean featured);
    
    List<Blog> findByPublishedAndFeatured(Boolean published, Boolean featured);
    
    // Category queries
    List<Blog> findByCategory(BlogCategory category);
    
    Page<Blog> findByPublishedAndCategory(Boolean published, BlogCategory category, Pageable pageable);
    
    List<Blog> findByPublishedAndCategory(Boolean published, BlogCategory category);
    
    // Author queries
    List<Blog> findByAuthor_Id(Long authorId);
    
    Page<Blog> findByAuthor_Id(Long authorId, Pageable pageable);
    
    Page<Blog> findByPublishedAndAuthor_Id(Boolean published, Long authorId, Pageable pageable);
    
    // Tag queries
    @Query("SELECT b FROM Blog b WHERE :tag MEMBER OF b.tags AND b.published = true")
    Page<Blog> findByTag(@Param("tag") String tag, Pageable pageable);
    
    // Search queries
    @Query("SELECT b FROM Blog b WHERE b.published = true AND " +
           "(LOWER(b.title) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(b.excerpt) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(b.content) LIKE LOWER(CONCAT('%', :search, '%')))")
    Page<Blog> searchPublishedBlogs(@Param("search") String search, Pageable pageable);
    
    // Date range queries
    @Query("SELECT b FROM Blog b WHERE b.published = true AND b.publishedAt BETWEEN :start AND :end ORDER BY b.publishedAt DESC")
    List<Blog> findPublishedBetweenDates(
        @Param("start") LocalDateTime start,
        @Param("end") LocalDateTime end
    );
    
    // Popular blogs
    List<Blog> findTop5ByPublishedOrderByViewCountDesc(Boolean published);
    
    List<Blog> findTop10ByPublishedOrderByPublishedAtDesc(Boolean published);
    
    // View count
    @Modifying
    @Query("UPDATE Blog b SET b.viewCount = b.viewCount + 1 WHERE b.id = :id")
    void incrementViewCount(@Param("id") Long id);
    
    // Related blogs
    @Query("SELECT b FROM Blog b WHERE b.published = true AND b.category = :category AND b.id <> :excludeId ORDER BY b.publishedAt DESC")
    List<Blog> findRelatedBlogs(
        @Param("category") BlogCategory category,
        @Param("excludeId") Long excludeId,
        Pageable pageable
    );
    
    // Count queries
    long countByPublished(Boolean published);
    
    long countByCategory(BlogCategory category);
    
    long countByPublishedAndCategory(Boolean published, BlogCategory category);
    
    long countByAuthor_Id(Long authorId);
    
    // Exists queries
    boolean existsBySlug(String slug);
    
    // Comments enabled
    List<Blog> findByPublishedAndCommentsEnabled(Boolean published, Boolean commentsEnabled);
}