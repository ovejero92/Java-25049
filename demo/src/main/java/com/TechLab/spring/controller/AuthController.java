package com.TechLab.spring.controller;

import com.TechLab.spring.model.Usuario;
import com.TechLab.spring.service.AuthService;
import com.TechLab.spring.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Inyectamos lo que necesitamos para la autenticación y creación del token
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public String register(@RequestBody Usuario user) {
        authService.registerUser(user.getUsername(), user.getPassword());
        return "Usuario creado con éxito";
    }

    // CAMBIO: El login ahora devuelve un token JWT
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario user) {
        // Autenticamos al usuario con el AuthenticationManager
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        // Si la autenticación es exitosa, generamos el token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        final String jwt = jwtService.generateToken(userDetails);

        // Devolvemos el token en la respuesta
        return ResponseEntity.ok(Map.of("token", jwt));
    }
}
