package com.gustavo.workshop.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "USUARIO")
public class User implements Serializable {
    private static final long serialVersionUID = -1586463984827296965L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "nome", length = 50)
    private String name;
    @Column(name = "email", length = 60)
    private String email;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post.class)
    @JsonBackReference
    private List<Post> posts;

    public User(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(Integer id, String name, String email, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.posts = posts;
    }
}
