  class Producto {
      constructor(id, nombre, precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
      }

      render() {
        const div = document.createElement("div");
        div.className = "producto";
        div.innerHTML = `
          <h3>${this.nombre}</h3>
          <p>Precio: $${this.precio}</p>
          <button data-id="${this.id}">Agregar al carrito</button>
        `;
        return div;
      }
    }

    class Carrito {
      constructor() {
        this.items = [];
      }

      agregar(producto) {
        const item = this.items.find(p => p.id === producto.id);
        if (item) {
          item.cantidad++;
        } else {
          this.items.push({ ...producto, cantidad: 1 });
        }
        this.render();
      }

      calcularTotal() {
        return this.items.reduce((acc, item) => acc + item.precio * item.cantidad, 0);
      }

      render() {
        const carritoDiv = document.getElementById("carrito");
        carritoDiv.innerHTML = "";
        this.items.forEach(item => {
          const div = document.createElement("div");
          div.className = "carrito";
          div.innerHTML = `${item.nombre} x${item.cantidad} = $${item.precio * item.cantidad}`;
          carritoDiv.appendChild(div);
        });

        document.getElementById("total").textContent = this.calcularTotal();
      }
    }