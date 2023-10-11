package com.aydsii.porky;
import static spark.Spark.*;


public class Main {
    public static void main(String[] args) {
        staticFiles.location("/public");
        //Lado del Cliente
        get("/home", ControladorCliente.indice);
        get("/productos", ProductoControlador.allProductos);
        get("/producto", ProductoControlador.nameQuerry);
        get("/masinfo", ProductoControlador.moreInfo);
        //Lado del administrador
        get("/admin", ControladorAdmin.admin);
        get("/admin/productos", ControladorAdmin.adminProductos);
        get("/admin/sobremi", ControladorAdmin.sobreMi);
        get("/admin/encargos", ControladorAdmin.encargos);
        get("/admin/productos/agregar", ControladorAdmin.addProducto);
        get("/admin/productos/agregado", ProductoControlador.productoAgregado);
        
    }
}