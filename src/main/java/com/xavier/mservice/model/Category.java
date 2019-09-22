package com.xavier.mservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "category")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "category_id")
    private Long categoryId;

    @NotBlank(message = "category-1")
    @Column(name = "category_name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    public boolean isNew() {
        return this.categoryId == null;
    }

    public boolean exist() {
        return this.categoryId != null;
    }
}
