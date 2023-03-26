package dev.lbelin.forumapi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "created_on", nullable = false)
    protected LocalDateTime createdOn;

    @Column(name = "updated_on", nullable = false)
    protected LocalDateTime updatedOn;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdOn = now;
        updatedOn = now;
    }
}
