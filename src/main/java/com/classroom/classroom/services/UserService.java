package com.classroom.classroom.services;

import com.classroom.classroom.dto.UserMinDTO;
import com.classroom.classroom.entities.User;
import com.classroom.classroom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserMinDTO> findAll(){
        List<User> result = userRepository.findAll();
        return result.stream().map(UserMinDTO::new).toList();
    }
}
