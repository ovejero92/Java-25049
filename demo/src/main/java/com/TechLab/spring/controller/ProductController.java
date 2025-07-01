package com.TechLab.spring.controller;
import com.TechLab.spring.model.Producto;
import com.TechLab.spring.service.ProductoService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductController {

    private  ProductoService productoService;

    @GetMapping("/list")
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @PostMapping("/")
    public String crearProducto(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }

    @GetMapping("/find/{id}")
    public Producto buscarProductos(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

    //   /buscar?nombre=mouse
    @GetMapping("/buscar")
    public String buscarProducto(@RequestParam String nombre, @RequestParam(required = false, defaultValue = "asc") String orden ) {
        return "buscando... nombre: " + nombre + " orden: " + orden;
    }


    // ../find/342 ->
    // ../find/{id}



}