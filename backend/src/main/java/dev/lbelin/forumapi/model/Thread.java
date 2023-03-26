package dev.lbelin.forumapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "threads")
public class Thread extends BaseEntity {

    @NotBlank
    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @NotBlank
    @Column(name = "description", length = 65535, nullable = false)
    private String description;

    @OneToOne(optional = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User author;

    @OneToMany(mappedBy = "thread")
    private List<Post> posts;
}
