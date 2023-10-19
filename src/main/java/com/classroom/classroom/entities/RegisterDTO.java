package com.classroom.classroom.entities;

import com.classroom.classroom.entities.UserRole;

public record RegisterDTO(String firstName,
                          String lastName,
                          String login,
                          String password,
                          UserRole role) {
}
