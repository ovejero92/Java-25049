package com.TechLab.spring.service;
import com.TechLab.spring.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService{
    // simular un base de datos en memoria
    private final List<Producto> productos = new ArrayList<>();
    private Long contadorId = 1L;


    @Override
    public String crearProducto(Producto producto) {
        productos.add(producto);
        return "Producto creado correctamente";
    }

    public List<Producto> listarProductos() {
        return productos;
    }

    @Override
    public Producto buscarPorId(Long id) {
        if(id >= 0 && id < productos.size()) {
            return productos.get(id.intValue());
        }
        return null;
    }
}