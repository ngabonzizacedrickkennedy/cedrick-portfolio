package com.ngabonzizacedrick.Portfolio.repository;

import com.ngabonzizacedrick.Portfolio.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    
    // Basic queries
    List<Skill> findByVisible(Boolean visible);
    
    List<Skill> findByCategory(Skill.SkillCategory category);
    
    List<Skill> findByVisibleAndCategory(Boolean visible, Skill.SkillCategory category);
    
    // Order by display order
    List<Skill> findByVisibleOrderByDisplayOrderAsc(Boolean visible);
    
    List<Skill> findByCategoryOrderByDisplayOrderAsc(Skill.SkillCategory category);
    
    List<Skill> findByVisibleAndCategoryOrderByDisplayOrderAsc(Boolean visible, Skill.SkillCategory category);
    
    // Proficiency queries
    @Query("SELECT s FROM Skill s WHERE s.visible = true AND s.proficiency >= :minProficiency ORDER BY s.proficiency DESC")
    List<Skill> findTopSkills(@Param("minProficiency") Integer minProficiency);
    
    List<Skill> findByVisibleAndProficiencyGreaterThanEqualOrderByProficiencyDesc(Boolean visible, Integer proficiency);
    
    // Years of experience queries
    @Query("SELECT s FROM Skill s WHERE s.visible = true AND s.yearsExperience >= :years ORDER BY s.yearsExperience DESC")
    List<Skill> findByMinYearsExperience(@Param("years") Double years);
    
    // Search queries
    @Query("SELECT s FROM Skill s WHERE s.visible = true AND " +
           "LOWER(s.name) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Skill> searchVisibleSkills(@Param("search") String search);
    
    // Count queries
    long countByVisible(Boolean visible);
    
    long countByCategory(Skill.SkillCategory category);
    
    long countByVisibleAndCategory(Boolean visible, Skill.SkillCategory category);
    
    // Exists queries
    boolean existsByName(String name);
    
    Optional<Skill> findByName(String name);
}