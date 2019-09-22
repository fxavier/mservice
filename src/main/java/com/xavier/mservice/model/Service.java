package com.xavier.mservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "service")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "service_id")
    private Long serviceId;

    @NotBlank(message = "service-1")
    @Column(name = "service_name")
    private String serviceName;

    @NotNull(message = "service-2")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
