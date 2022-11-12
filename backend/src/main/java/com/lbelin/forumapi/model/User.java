package com.lbelin.forumapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name="username", length = 255, nullable = false)
    private String username;

    @NotBlank
    @Column(name="password", length = 4096, nullable = false)
    private String password;

    @NotBlank
    @Column(name="email", length = 255, nullable = false)
    private String email;

    @NotBlank
    @Column(name="created_on", nullable = false)
    private Date createdOn;

    @NotBlank
    @Column(name="updated_on", nullable = false)
    private Date updatedOn;
}
