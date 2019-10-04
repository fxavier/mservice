package com.xavier.mservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "project")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "project_id")
    private Long projectId;

    @NotBlank(message = "project-1")
    @Column(name = "project_name")
    private String projectName;

    private String description;

    @NotNull(message = "project-2")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Enumerated(EnumType.STRING)
    private Province province;

    @NotNull(message = "project-3")
    @Column(name = "initial_price")
    private BigDecimal initialPrice;

    @NotNull(message = "project-4")
    @Column(name = "final_price")
    private BigDecimal finalPrice;

    @Column(name = "posted_date")
    private LocalDate postedDate;

    @ManyToOne
    @JoinColumn(name = "posted_by")
    private UserAccount postedby;

    public Boolean active;

    public boolean isNew() {
        return this.projectId == null;
    }

}
