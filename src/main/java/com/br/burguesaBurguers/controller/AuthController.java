package com.br.burguesaBurguers.controller;

import com.br.burguesaBurguers.dto.LoginRequestDTO;
import com.br.burguesaBurguers.dto.LoginResponseDTO;
import com.br.burguesaBurguers.dto.UserCreateDTO;
import com.br.burguesaBurguers.dto.UserResponseDTO;
import com.br.burguesaBurguers.service.AuthService;
import com.br.burguesaBurguers.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto) {
       return ResponseEntity.ok(authService.login(dto));
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> listUsers() {
        return ResponseEntity.ok(userService.listAll());
    }
}
