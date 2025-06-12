package com.TechLab.spring;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductController {

    @GetMapping("/platillo1")
    public String platillo1() {
        return "Hola mundo";
    }

    @PostMapping("/platillo1")
    public String postPlatillo1(){
        return "Subir platillo";
    }
}
