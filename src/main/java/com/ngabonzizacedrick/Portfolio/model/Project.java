package com.ngabonzizacedrick.Portfolio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project extends BaseEntity {

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 200)
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Description is required")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String detailedDescription;

    @ElementCollection
    @CollectionTable(name = "project_technologies", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "technology")
    private List<String> technologies = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "project_tags", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "tag")
    private Set<String> tags = new HashSet<>();

    @Column(name = "video_url")
    private String videoUrl; // S3 URL or YouTube URL

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @ElementCollection
    @CollectionTable(name = "project_images", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "image_url")
    private List<String> imageUrls = new ArrayList<>();

    @Column(name = "demo_url")
    private String demoUrl; // Live demo link

    @Column(name = "github_url")
    private String githubUrl; // Repository link

    @Column(name = "project_category")
    @Enumerated(EnumType.STRING)
    private ProjectCategory category;

    @Column(nullable = false)
    private Boolean featured = false;

    @Column(nullable = false)
    private Boolean published = true;

    @Column(nullable = false)
    private Integer viewCount = 0;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(name = "start_date")
    private String startDate; // e.g., "January 2024"

    @Column(name = "end_date")
    private String endDate; // e.g., "March 2024" or "Present"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private User createdBy;

    public enum ProjectCategory {
        WEB_DEVELOPMENT,
        MOBILE_DEVELOPMENT,
        DESKTOP_APPLICATION,
        MACHINE_LEARNING,
        DATA_SCIENCE,
        DEVOPS,
        GAME_DEVELOPMENT,
        IOT,
        BLOCKCHAIN,
        OTHER
    }

    public void incrementViewCount() {
        this.viewCount++;
    }
}