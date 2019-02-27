package com.gustavo.workshop.dto;


import com.gustavo.workshop.domain.User;
import lombok.*;

import java.io.Serializable;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private static final long serialVersionUID = -7090583085521105816L;
    private Integer id;
    private String name;
    private String email;

    public UserDto(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
    }
}
