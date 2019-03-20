package com.gustavo.workshop.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Post")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post implements Serializable {
    private static final long serialVersionUID = 5586494874548170086L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private Date date;
    private String title;
    private String body;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "posts", targetEntity = User.class)
    @JsonManagedReference
    private List<User> user;
}
