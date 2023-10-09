package com.classroom.classroom.dto;

import com.classroom.classroom.entities.User;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

@Getter
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserDTO(User entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
