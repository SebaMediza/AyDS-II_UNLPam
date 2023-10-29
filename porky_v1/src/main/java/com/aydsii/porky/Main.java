package com.aydsii.porky;
import static spark.Spark.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import com.google.firebase.auth.FirebaseAuthException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, FirebaseAuthException {
        staticFiles.location("/public");
        //Lado del Cliente
        get("/home", ControladorCliente.indice);
        get("/productos", ProductoControlador.listarProductos);
        get("/producto", ProductoControlador.buscarNombre);
        get("/masinfo", ProductoControlador.masInformacion);
        get("/login", ControladorCliente.logIn);
        //Lado del administrador
        get("/admin", ControladorAdmin.admin);
        get("/admin/productos", ControladorAdmin.adminProductos);
        get("/admin/sobremi", ControladorAdmin.sobreMi);
        get("/admin/encargos", ControladorAdmin.encargos);
        get("/admin/productos/agregar", ControladorAdmin.addProducto);
        get("/admin/agregado", ControladorAdmin.productoAgregado);
    }
}