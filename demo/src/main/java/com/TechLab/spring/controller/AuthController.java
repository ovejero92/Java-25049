package com.TechLab.spring.controller;
import com.TechLab.spring.model.Usuario;
import com.TechLab.spring.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody Usuario user) {
        authService.registerUser(user.getUsername(), user.getPassword());
        return "Usuario creado con éxito";
    }

    //temporalmente solo para mostrar en front
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario user) {
        Optional<Usuario> usuario = authService.authenticate(user.getUsername(), user.getPassword());
        if (usuario.isPresent()) {
            boolean isAdmin = usuario.get().getRoles().stream()
                    .anyMatch(rol -> rol.getName().equals("ROLE_ADMIN"));
            return ResponseEntity.ok(Map.of(
                    "username", usuario.get().getUsername(),
                    "isAdmin", isAdmin
            ));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}