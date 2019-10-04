package com.xavier.mservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "freelancer")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Freelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "freelancer_id")
    private Long freelancerId;

    @NotNull(message = "freelancer-1")
    @Enumerated(EnumType.STRING)
    @Column(name = "freelancer_type")
    private FreelancerType freelancerType;

    @NotBlank(message = "freelancer-2")
    @Column(name = "job_title")
    private String jobTitle;

    @NotBlank(message = "freelancer-3")
    private String phone;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Enumerated(EnumType.STRING)
    private Province province;

    @Column(name = "about_you")
    private String aboutYou;

    @NotNull(message = "frelancer-4")
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @NotNull(message = "freelancer-5")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    private Boolean active;

    public boolean isNew() {
        return this.freelancerId == null;
    }
}
