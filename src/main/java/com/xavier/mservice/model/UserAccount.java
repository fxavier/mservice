package com.xavier.mservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user_account")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "user_id")
    private Long userId;

    @NotBlank(message = "user-1")
    private String firstName;

    @NotBlank(message = "user-2")
    private String lastName;

    @NotBlank(message = "user-3")
    private String email;

    @NotBlank(message = "user-4")
    private String password;

    private Boolean active;

    public boolean isNew() {
        return this.userId == null;
    }

    public boolean exists() {
        return this.userId != null;
    }

}
