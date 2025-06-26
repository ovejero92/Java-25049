package com.TechLab.spring.controller;
import com.TechLab.spring.model.Producto;
import com.TechLab.spring.service.ProductoService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductController {



   @GetMapping("/list")
    public List<Producto> listarProductos() {
       return ProductoService.listarProductos();
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
