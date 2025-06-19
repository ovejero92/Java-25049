package com.TechLab.spring.controller;
import com.TechLab.spring.model.Producto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductController {

   @GetMapping("/list")
    public String listaProductos() {
       return "Productos";
   }

   @PostMapping("/")
    public String crearProducto(@RequestBody Producto producto){
       return "creando producto..." + producto;
   }

   @GetMapping("/find/{id}")
    public String buscarProductos(@PathVariable Long id) {
       return "buscando ..." + id;
   }

   //   /buscar?nombre=mouse
   @GetMapping("/buscar")
   public String buscarProducto(@RequestParam String nombre, @RequestParam(required = false, defaultValue = "asc") String orden ) {
       return "buscando... nombre: " + nombre + " orden: " + orden;
   }


   // ../find/342 ->
    // ../find/{id}



}
