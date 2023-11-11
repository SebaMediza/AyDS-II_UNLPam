const btn_navbar = document.querySelector('.btn_navbar');
const btn_cls_nav = document.querySelector('#cls_navbar');
const navbar = document.querySelector('.navbar');
btn_navbar.onclick = function () {
    btn_navbar.style.transform = "translate(0,-15vh)";
    navbar.style.display = "flex";
    navbar.style.width = "10%";
}
btn_cls_nav.onclick = function () {
    btn_navbar.style.transform = "translate(0,0)";
    navbar.style.display = "none";
    navbar.style.width = "0%";
}
const btn_login = document.querySelector('.btn_login');
const modal_login = document.querySelector('.modal_login')
const btn_cls_login = document.querySelector('#cls_login');
btn_login.onclick = function () {
    modal_login.style.display = "flex";
}
btn_cls_login.onclick = function () {
    modal_login.style.display = "none";
}

const products = document.querySelectorAll(".product");
products.forEach((item) => item.addEventListener("click", 
    (e)=>{
        item.transform = "matrix(0,2,0,2,50%,50%)";
    }
))

function renderizarArchivo0() {
    const fileInput = document.getElementById('photo0');
    const imagenRenderizada = document.getElementById('imagenRenderizada0');
    const file = fileInput.files[0]; // Obtén el primer archivo seleccionado

    if (file) {
      const reader = new FileReader();

      reader.onload = function (e) {
        // Cuando la lectura del archivo esté completa, muestra la imagen
        imagenRenderizada.src = e.target.result;
        imagenRenderizada.style.display = 'block';
      };

      // Lee el contenido del archivo como una URL de datos
      reader.readAsDataURL(file);
    }
  }
function renderizarArchivo1() {
    const fileInput = document.getElementById('photo1');
    const imagenRenderizada = document.getElementById('imagenRenderizada1');
    const file = fileInput.files[0]; // Obtén el primer archivo seleccionado

    if (file) {
      const reader = new FileReader();

      reader.onload = function (e) {
        // Cuando la lectura del archivo esté completa, muestra la imagen
        imagenRenderizada.src = e.target.result;
        imagenRenderizada.style.display = 'block';
      };

      // Lee el contenido del archivo como una URL de datos
      reader.readAsDataURL(file);
    }
  }
function renderizarArchivo2() {
    const fileInput = document.getElementById('photo2');
    const imagenRenderizada = document.getElementById('imagenRenderizada2');
    const file = fileInput.files[0]; // Obtén el primer archivo seleccionado

    if (file) {
      const reader = new FileReader();

      reader.onload = function (e) {
        // Cuando la lectura del archivo esté completa, muestra la imagen
        imagenRenderizada.src = e.target.result;
        imagenRenderizada.style.display = 'block';
      };

      // Lee el contenido del archivo como una URL de datos
      reader.readAsDataURL(file);
    }
  }
function renderizarArchivo3() {
    const fileInput = document.getElementById('photo3');
    const imagenRenderizada = document.getElementById('imagenRenderizada3');
    const file = fileInput.files[0]; // Obtén el primer archivo seleccionado

    if (file) {
      const reader = new FileReader();

      reader.onload = function (e) {
        // Cuando la lectura del archivo esté completa, muestra la imagen
        imagenRenderizada.src = e.target.result;
        imagenRenderizada.style.display = 'block';
      };

      // Lee el contenido del archivo como una URL de datos
      reader.readAsDataURL(file);
    }
  }