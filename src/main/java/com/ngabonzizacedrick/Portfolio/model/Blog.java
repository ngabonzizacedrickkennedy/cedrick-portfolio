package com.ngabonzizacedrick.Portfolio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "blogs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Blog extends BaseEntity {

    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 200)
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Slug is required")
    @Size(min = 5, max = 250)
    @Column(nullable = false, unique = true)
    private String slug;

    @NotBlank(message = "Content is required")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String excerpt; // Short summary for listings

    @Column(name = "featured_image_url")
    private String featuredImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private BlogCategory category;

    @ElementCollection
    @CollectionTable(name = "blog_tags", joinColumns = @JoinColumn(name = "blog_id"))
    @Column(name = "tag")
    private Set<String> tags = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(nullable = false)
    private Boolean published = false;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    @Column(nullable = false)
    private Boolean featured = false;

    @Column(nullable = false)
    private Integer viewCount = 0;

    @Column(name = "reading_time_minutes")
    private Integer readingTimeMinutes;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    // SEO fields
    @Column(name = "meta_title")
    private String metaTitle;

    @Column(name = "meta_description", length = 500)
    private String metaDescription;

    @ElementCollection
    @CollectionTable(name = "blog_meta_keywords", joinColumns = @JoinColumn(name = "blog_id"))
    @Column(name = "keyword")
    private Set<String> metaKeywords = new HashSet<>();

    @Column(nullable = false)
    private Boolean commentsEnabled = true;

    public void incrementViewCount() {
        this.viewCount++;
    }

    public void publish() {
        this.published = true;
        if (this.publishedAt == null) {
            this.publishedAt = LocalDateTime.now();
        }
    }

    public void unpublish() {
        this.published = false;
    }

    public Integer getApprovedCommentCount() {
        return (int) comments.stream()
                .filter(Comment::getApproved)
                .count();
    }
}