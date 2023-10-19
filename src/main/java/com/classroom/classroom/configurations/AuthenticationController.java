package com.classroom.classroom.configurations;

import com.classroom.classroom.entities.AuthenticationDTO;
import com.classroom.classroom.entities.LoginResponseDTO;
import com.classroom.classroom.entities.RegisterDTO;
import com.classroom.classroom.entities.User;
import com.classroom.classroom.repository.UserRepository;
import com.classroom.classroom.services.AuthenticationService;
import com.classroom.classroom.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "auth")
public class AuthenticationController {
    @Autowired
    private UserRepository repository;
    @Autowired
    AuthenticationService authenticate;

    @Autowired
    TokenService tokenService;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
//        if(this.repository.findByLogin(data.login()) != null)
//            return ResponseEntity.badRequest().build();
        System.out.println(data.login());
//        var usernameToken = new UsernamePasswordAuthenticationToken(
//                data.login(), data.password());
//
//        System.out.println(usernameToken);
        System.out.println(data.login());
        System.out.println(data.password());

//        var auth = this.authenticate.authenticateUserByLogin(usernameToken.getPrincipal().toString(), usernameToken.getPrincipal().toString())
        var auth = this.authenticate.authenticateUserByLogin(data.login(), data.password());
        var token = tokenService.generateToken(auth);
//
        return ResponseEntity.ok(new LoginResponseDTO(token));
//        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if(this.repository.findByLogin(data.login()) != null)
            return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        User newUser = new User(data.firstName(),
                data.lastName(),
                data.login(),
                encryptedPassword,
                data.role()
        );

        this.repository.save(newUser);

        return ResponseEntity.ok().build();

    }

}
