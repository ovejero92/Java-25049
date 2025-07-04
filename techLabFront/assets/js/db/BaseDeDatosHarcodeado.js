const baseDeDatos = [
    {
        categoria: "electrodomésticos",
        productos: [
            { nombre: "calefactor", precio: 259075, descuento: 0.5, img: "https://http2.mlstatic.com/D_NQ_NP_938970-MLA45994715946_052021-O.webp" },
            { nombre: "caloventor", precio: 25999, descuento: 0.7, img: "https://http2.mlstatic.com/D_NQ_NP_832778-MLU70474474494_072023-O.webp" },
            { nombre: "Estufa hongo", precio: 211150, descuento: 0.7, img: "https://http2.mlstatic.com/D_NQ_NP_841221-MLU76793294957_062024-O.webp" },
            { nombre: "Estufa electrica", precio: 41929, descuento: 0.7, img: "https://http2.mlstatic.com/D_NQ_NP_643143-MLU74821429636_032024-O.webp" },
        ]
    },
    {
        categoria: "herramientas",
        productos: [
            { nombre: "Hidrolavadora", precio: 91681, descuento: 0.7, img: "https://http2.mlstatic.com/D_Q_NP_679173-MLU78381109839_082024-P.webp" },
            { nombre: "Taladro", precio: 109034, descuento: 0.7, img: "https://http2.mlstatic.com/D_Q_NP_656678-MLA69951087361_062023-P.webp" },
            { nombre: "Mini motosierra", precio: 211150, descuento: 0.7, img: "https://http2.mlstatic.com/D_Q_NP_742298-MLU74855802541_032024-P.webp" },
            { nombre: "Bordeadora", precio: 84364, descuento: 0.7, img: "https://http2.mlstatic.com/D_NQ_NP_643143-MLU74821429636_032024-O.webp" },
        ]
    }
];
/* sin filtro por todo */
function mostrarCategorias() {
    const categoriasContainer = document.getElementById('categorias');
    categoriasContainer.innerHTML = baseDeDatos.map(cat => `
        <div class="cursor-pointer " onclick="filtrarProductos('${cat.categoria}')">
            <h2 class="text-center mt-2 font-bold bg-gray-800 py-2 text-white">${cat.categoria}</h2>
        </div>
    `).join('');
}
/* con filtro por todo
function mostrarCategorias() {
    const categoriasContainer = document.getElementById('categorias');
    categoriasContainer.innerHTML = `
        <div class="cursor-pointer" onclick="filtrarProductos('Todos')">
            <h2 class="text-center mt-2 font-bold bg-indigo-500 py-2 text-white">Todos</h2>
        </div>
    ` + baseDeDatos.map(cat => `
        <div class="cursor-pointer" onclick="filtrarProductos('${cat.categoria}')">
            <h2 class="text-center mt-2 font-bold bg-gray-800 py-2 text-white">${cat.categoria}</h2>
        </div>
    `).join('');
} */


function mostrarProductos(productos) {
    const productosContainer = document.getElementById('productos');
    productosContainer.innerHTML = productos.map(prod => {
        const idSeguro = prod.nombre.replace(/\s+/g, '_').toLowerCase();
        return `
        <div class="border p-4">
            <img src="${prod.img}" alt="${prod.nombre}" class="w-full h-32 object-cover">
            <h3 class="mt-2 font-bold">${prod.nombre}</h3>
            <p class="text-gray-600">Precio: $${prod.precio}</p>
            <div class="flex items-center mt-2 relative">
                <button onclick="modificarCantidad('${idSeguro}', -1)" class="bg-gray-200 px-2">-</button>
                <span id="cantidad-${idSeguro}" class="mx-2">1</span>
                <button onclick="modificarCantidad('${idSeguro}', 1)" class="bg-gray-200 px-2 boton-mas">+</button>
            </div>
            <button  onclick='agregarAlCarrito(${JSON.stringify(prod)}, obtenerCantidad("${idSeguro}"))' class="mt-2 bg-indigo-500 hover:bg-indigo-600 text-white py-1 px-2 rounded agregar-carrito">Añadir al Carrito</button>
        </div>
        `;
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
/* sin filtro por todo */
function filtrarProductos(categoria) {
    const categoriaSeleccionada = baseDeDatos.find(cat => cat.categoria === categoria);
    mostrarProductos(categoriaSeleccionada.productos);
    // EXTRA
    // Quitar estilos de todas
    document.querySelectorAll('#categorias > div > h2').forEach(el => {
        el.classList.remove('bg-indigo-500');
        el.classList.add('bg-gray-800');
    });

    // Resaltar la categoría activa
    const activa = Array.from(document.querySelectorAll('#categorias > div > h2')).find(el => el.innerText === categoria);
    if (activa) {
        activa.classList.remove('bg-gray-800');
        activa.classList.add('bg-indigo-500');
    }
    // FIN EXTRA
}
/* con filtro por todo 
function filtrarProductos(categoria) {
    if (categoria === "Todos") {
        mostrarProductos(baseDeDatos.flatMap(cat => cat.productos));
    } else {
        const categoriaSeleccionada = baseDeDatos.find(cat => cat.categoria === categoria);
        mostrarProductos(categoriaSeleccionada.productos);
    }

    // Quitar estilos de todas
    document.querySelectorAll('#categorias > div > h2').forEach(el => {
        el.classList.remove('bg-indigo-500');
        el.classList.add('bg-gray-800');
    });

    // Resaltar la categoría activa
    const activa = Array.from(document.querySelectorAll('#categorias > div > h2')).find(el => el.innerText === categoria);
    if (activa) {
        activa.classList.remove('bg-gray-800');
        activa.classList.add('bg-indigo-500');
    }
}*/

/* CARRITO */
// Arreglo para almacenar los productos en el carrito
let carrito = [];

// Muestra el modal del carrito
function abrirCarrito() {
    document.getElementById('modalCarrito').classList.remove('hidden');
}

// Cierra el modal del carrito
function cerrarCarrito() {
    document.getElementById('modalCarrito').classList.add('hidden');
}

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
                <button onclick="eliminarProductoDelCarrito('${item.nombre}')" class="absolute top-2 -right-3 bg-indigo-900 hover:bg-indigo-200 hover:text-red-500 text-white font-bold px-2 rounded"><i class="fa-solid fa-trash-can-arrow-up"></i></button>
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


// Inicialización
mostrarCategorias();

/* sin filtro por todo */
mostrarProductos(baseDeDatos.flatMap(cat => cat.productos));

/* con filtro por todo
filtrarProductos("Todos");*/