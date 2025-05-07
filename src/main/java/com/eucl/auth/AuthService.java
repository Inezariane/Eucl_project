package com.eucl.auth;

import org.springframework.stereotype.Service;

import com.eucl.model.*;
import com.eucl.repository.UserRepository;
import com.eucl.security.JwtService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;



@Service
public class AuthService {

    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setRole(Role.USER);
        userRepository.save(user);

        String jwtToken = jwtService.generateToken(request.getEmail());
        return new AuthResponse(jwtToken);
    }
    public AuthResponse login(AuthRequest request){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );

        String jwtToken = jwtService.generateToken(request.getEmail());
        return new AuthResponse(jwtToken);
    }

}
