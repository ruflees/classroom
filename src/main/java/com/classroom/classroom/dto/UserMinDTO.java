package com.classroom.classroom.dto;

import com.classroom.classroom.entities.User;
import com.classroom.classroom.projections.UserMinProjection;

public class UserMinDTO {
    private Long id;
    private String firstName;
    private String lastName;

    public UserMinDTO(User entity){
        id = entity.getId();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
    }

    public void UserMinDTO(UserMinProjection projection){
        id = projection.getId();
        firstName = projection.getFirstName();
        lastName = projection.getLastName();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
