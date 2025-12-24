package com.ngabonzizacedrick.Portfolio.repository;

import com.ngabonzizacedrick.Portfolio.model.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogCategoryRepository extends JpaRepository<BlogCategory, Long> {
    
    // Basic queries
    Optional<BlogCategory> findBySlug(String slug);
    
    Optional<BlogCategory> findByName(String name);
    
    List<BlogCategory> findByActive(Boolean active);
    
    // Order by display order
    List<BlogCategory> findByActiveOrderByDisplayOrderAsc(Boolean active);
    
    List<BlogCategory> findAllByOrderByDisplayOrderAsc();
    
    // Exists queries
    boolean existsBySlug(String slug);
    
    boolean existsByName(String name);
    
    // Count queries
    long countByActive(Boolean active);
}