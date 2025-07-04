let productosGlobal = [];
let isAdmin = false;

window.onload = async () => {
    await fetchProductos();
    verificarLogin();
    actualizarNavbar();
};
// Verifica si el usuario está logueado como admin
function verificarLogin() {
    isAdmin = localStorage.getItem("isAdmin") === "true";
}


// LOGIN
async function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const response = await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
    });

    if (response.ok) {
        const data = await response.json();
        isAdmin = data.isAdmin;
        localStorage.setItem("username", data.username);
        localStorage.setItem("isAdmin", isAdmin);
        cerrarLogin();
        await fetchProductos();
        // TO DELETE ⬇️
        actualizarNavbar(); // <<---
        alert("Bienvenido " + data.username);
    } else {
        alert("Login fallido");
    }
}

async function fetchProductos() {
    const response = await fetch("http://localhost:8080/producto/list");
    const productos = await response.json();
    productosGlobal = productos;
    mostrarProductos(productosGlobal);
}

// Muestra productos y agrega botones admin si corresponde
function mostrarProductos(productos) {
    const productosContainer = document.getElementById('productos');
    productosContainer.innerHTML = productos.map(prod => {
        const idSeguro = prod.nombre.replace(/\s+/g, '_').toLowerCase();

        return `
        <div class="border p-4">
            <img src="${prod.img}" alt="${prod.nombre}" class="w-full h-32 object-cover">
            <h3 class="mt-2 font-bold">${prod.nombre}</h3>
            <p class="text-gray-600">Precio: $${prod.precio}</p>
            <div class="flex items-center mt-2">
                <button onclick="modificarCantidad('${idSeguro}', -1)" class="bg-gray-200 px-2">-</button>
                <span id="cantidad-${idSeguro}" class="mx-2">1</span>
                <button onclick="modificarCantidad('${idSeguro}', 1)" class="bg-gray-200 px-2">+</button>
            </div>
            <button onclick='agregarAlCarrito(${JSON.stringify(prod)}, obtenerCantidad("${idSeguro}"))' 
                class="mt-2 bg-indigo-500 hover:bg-indigo-600 text-white py-1 px-2 rounded">
                Añadir al Carrito
            </button>
            ${isAdmin ? `
                <button onclick="eliminarProducto(${prod.id})" class="mt-2 w-full bg-red-500 hover:bg-red-600 text-white py-1 rounded">Eliminar</button>
                <button onclick="editarProducto(${prod.id})" class="mt-2 w-full bg-yellow-500 hover:bg-yellow-600 text-white py-1 rounded">Editar</button>
            ` : ""}
        </div>`;
    }).join('');
}


/* EXTRA*/
function modificarCantidad(idSeguro, delta) {
    const cantidadSpan = document.getElementById(`cantidad-${idSeguro}`);
    let cantidad = parseInt(cantidadSpan.innerText) + delta;
    if (cantidad < 1) cantidad = 1;
    cantidadSpan.innerText = cantidad;
}
/* EXTRA*/
function obtenerCantidad(idSeguro) {
    return parseInt(document.getElementById(`cantidad-${idSeguro}`).innerText);
}

/* CARRITO */
// Arreglo para almacenar los productos en el carrito
let carrito = [];

// Muestra el modal del carrito
function abrirCarrito() { document.getElementById('modalCarrito').classList.remove('hidden');}

// Cierra el modal del carrito
function cerrarCarrito(){document.getElementById('modalCarrito').classList.add('hidden');}
function abrirLogin(){document.getElementById('modal_login').classList.remove('hidden')}
function cerrarLogin(){document.getElementById('modal_login').classList.add('hidden')}

// Añade un producto al carrito
function agregarAlCarrito(producto, cantidad = 1) {
    const productoExistente = carrito.find(item => item.nombre === producto.nombre);

    if (productoExistente) {
        productoExistente.cantidad += cantidad;
    } else {
        carrito.push({ ...producto, cantidad });
    }

    actualizarCarrito();
}

// Actualiza el contenido del carrito
function actualizarCarrito() {
    const contenidoCarrito = document.getElementById('contenidoCarrito');
    const carritoCount = document.getElementById('countCard')
    let html = '';
    
    carrito.forEach(item => {
        html += `
           <div class="flex justify-between items-center border-b pb-2 text-white">
                <div class="bg-indigo-500 w-full flex items-center justify-between p-2 rounded relative">
                <span>${item.nombre}</span>
                <div class="flex items-center relative">
                    <span class="absolute -top-[1.3rem] -left-[1.5rem] text-black font-bold bg-indigo-500 rounded-xl px-2">cantidad</span>
                    <button onclick="cambiarCantidad('${item.nombre}', -1)">-</button>
                    <span class="mx-2">${item.cantidad}</span>
                    <button onclick="cambiarCantidad('${item.nombre}', 1)" class="mr-[2rem]">+</button>
                    <span class="absolute -top-[1.3rem] left-[5.8rem] text-black font-bold bg-indigo-500 rounded-xl px-2">total</span>
                    <span class="ml-4 mr-4">$${item.precio * item.cantidad}</span>
                </div>
                <button onclick="eliminarProductoDelCarrito('${item.id}')" class="absolute top-2 -right-3 bg-indigo-900 hover:bg-indigo-200 hover:text-red-500 text-white font-bold px-2 rounded"><i class="fa-solid fa-trash-can-arrow-up"></i></button>
                </div>
            </div>
        `;
    });
    contenidoCarrito.innerHTML = html;

    const total = carrito.reduce((sum, item) => sum + item.precio * item.cantidad, 0);
    document.getElementById('totalCarrito').innerText = total;

    /* extra */
    // Actualiza la visibilidad y el contenido del contador del carrito
    const totalItems = carrito.reduce((sum, item) => sum + item.cantidad, 0);
    if (totalItems > 0) {
        carritoCount.classList.remove('hidden');
        carritoCount.innerText = totalItems;
    } else {
        carritoCount.classList.add('hidden');
    }
}

function BorrarTodoElCarrito() {
    carrito = [];
    actualizarCarrito();
}

function eliminarProductoDelCarrito(nombre) {
    carrito = carrito.filter(item => item.nombre !== nombre);
    actualizarCarrito();
}


// EXTRA DE FUNCION DE CANTIDAD 
function cambiarCantidad(nombre, delta) {
    const producto = carrito.find(item => item.nombre === nombre);
    if (producto) {
        producto.cantidad += delta;
        if (producto.cantidad <= 0) {
            carrito = carrito.filter(item => item.nombre !== nombre);
        }
        actualizarCarrito();
    }
}

// EXTRA FInal para realizar la compra
// Función para finalizar la compra
function finalizarCompra() {
    const resumenCompra = carrito.map(item => `
        ${item.nombre} (x${item.cantidad}): $${item.precio * item.cantidad}
    `).join('\n');

    const total = carrito.reduce((sum, item) => sum + item.precio * item.cantidad, 0);

    Swal.fire({
        title: 'Resumen de Compra',
        html: `<pre class="mr-[5rem]">${resumenCompra}</pre><br>Total: $${total}`,
        showCancelButton: true,
        confirmButtonText: 'Confirmar Compra',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire({
                title: 'Procesando compra...',
                html: 'Por favor espere un momento.',
                timer: 15000,
                timerProgressBar: true,
                showConfirmButton: false,
                willClose: () => {
                    Swal.fire({
                        icon: 'success',
                        title: 'Compra Confirmada',
                        text: 'Su pedido llegará en las próximas 24 horas. Para consultas, contáctenos al 1234-5678.'
                    }).then(() => {
                       //  carrito = []; Vacía el carrito
                       // actualizarCarrito();  Actualiza la vista del carrito
                        BorrarTodoElCarrito();
                        cerrarCarrito();
                    });
                }
            });
        }
    });
}



// === ADMIN: Eliminar producto ===
async function eliminarProducto(id) {
    const confirmacion = confirm("¿Estás seguro que querés eliminar este producto?");
    if (!confirmacion) return;

    const response = await fetch(`http://localhost:8080/producto/delete/${id}`, {
        method: 'DELETE',
         headers: {
        "Authorization": "Bearer " + localStorage.getItem("token"),
        "Content-Type": "application/json"
    }
    });

    if (response.ok) {
        alert("Producto eliminado");
        await fetchProductos();
    } else {
        alert("Error al eliminar producto");
    }
}

// === ADMIN: Editar producto (puedes personalizar esta lógica) ===
function editarProducto(id) {
    alert("Funcionalidad de edición pendiente para el producto ID: " + id);
}


