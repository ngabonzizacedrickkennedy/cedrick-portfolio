package com.ngabonzizacedrick.Portfolio.repository;

import com.ngabonzizacedrick.Portfolio.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    
    // Basic queries
    List<Project> findByPublished(Boolean published);
    
    List<Project> findByFeatured(Boolean featured);
    
    List<Project> findByPublishedAndFeatured(Boolean published, Boolean featured);
    
    // Pagination
    Page<Project> findByPublished(Boolean published, Pageable pageable);
    
    Page<Project> findByCategory(Project.ProjectCategory category, Pageable pageable);
    
    Page<Project> findByPublishedAndCategory(Boolean published, Project.ProjectCategory category, Pageable pageable);
    
    // Category queries
    List<Project> findByCategory(Project.ProjectCategory category);
    
    List<Project> findByPublishedAndCategory(Boolean published, Project.ProjectCategory category);
    
    // Technology queries
    @Query("SELECT p FROM Project p WHERE :technology MEMBER OF p.technologies AND p.published = true")
    List<Project> findByTechnology(@Param("technology") String technology);
    
    // Tag queries
    @Query("SELECT p FROM Project p WHERE :tag MEMBER OF p.tags AND p.published = true")
    List<Project> findByTag(@Param("tag") String tag);
    
    // Search queries
    @Query("SELECT p FROM Project p WHERE p.published = true AND " +
           "(LOWER(p.title) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(p.description) LIKE LOWER(CONCAT('%', :search, '%')))")
    Page<Project> searchPublishedProjects(@Param("search") String search, Pageable pageable);
    
    // Order by display order
    List<Project> findByPublishedOrderByDisplayOrderAsc(Boolean published);
    
    // View count queries
    List<Project> findTop5ByPublishedOrderByViewCountDesc(Boolean published);
    
    @Modifying
    @Query("UPDATE Project p SET p.viewCount = p.viewCount + 1 WHERE p.id = :id")
    void incrementViewCount(@Param("id") Long id);
    
    // User's projects
    List<Project> findByCreatedBy_Id(Long userId);
    
    Page<Project> findByCreatedBy_Id(Long userId, Pageable pageable);
    
    // Count queries
    long countByPublished(Boolean published);
    
    long countByCategory(Project.ProjectCategory category);
    
    long countByFeatured(Boolean featured);
    
    // Exists queries
    boolean existsByTitle(String title);
}