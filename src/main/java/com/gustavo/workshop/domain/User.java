package com.gustavo.workshop.domain;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
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
}
