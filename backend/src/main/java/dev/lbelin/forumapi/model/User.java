package dev.lbelin.forumapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NotBlank
    @Column(name = "username", length = 255, nullable = false)
    private String username;

    @NotBlank
    @Column(name = "password", length = 4096, nullable = false)
    private String password;

    @NotBlank
    @Email
    @Column(name = "email", length = 255, nullable = false)
    private String email;
}
