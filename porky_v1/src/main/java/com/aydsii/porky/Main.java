package com.aydsii.porky;
import static spark.Spark.*;


public class Main {
    public static void main(String[] args) {
        staticFiles.location("/public");
        get("/home", Controlador.indice);
        get("/productos", Controlador.allProductos);
        get("/producto", Controlador.nameQuerry);
        get("/masinfo", Controlador.moreInfo);
        get("/admin", Controlador.admin);
        get("/admin/productos", Controlador.adminProductos);
        get("/admin/sobremi", Controlador.sobreMi);
        get("/admin/encargos", Controlador.encargos);
    }
}