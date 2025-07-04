    const carrito = new Carrito();
    const contenedor = document.getElementById("productos");

    productos.forEach(producto => {
      const nodo = producto.render();
      nodo.querySelector("button").addEventListener("click", () => {
        carrito.agregar(producto);
      });
      contenedor.appendChild(nodo);
    });