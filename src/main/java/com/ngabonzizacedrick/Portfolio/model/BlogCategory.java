package com.ngabonzizacedrick.Portfolio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blog_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogCategory extends BaseEntity {

    @NotBlank(message = "Category name is required")
    @Size(min = 2, max = 100)
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank(message = "Slug is required")
    @Size(min = 2, max = 100)
    @Column(nullable = false, unique = true)
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "color_code")
    private String colorCode; // For UI theming (e.g., "#FF5733")

    @Column(nullable = false)
    private Boolean active = true;

    @Column(name = "display_order")
    private Integer displayOrder;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Blog> blogs = new ArrayList<>();

    public Integer getBlogCount() {
        return blogs != null ? blogs.size() : 0;
    }
}