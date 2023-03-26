package dev.lbelin.forumapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    @NotBlank
    @Column(name = "content", length = 65535, nullable = false)
    private String content;

    @OneToOne(optional = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User author;

    @NotNull
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "thread_id", referencedColumnName = "id")
    private Thread thread;
}
