package com.aydsii.porky;
import static spark.Spark.*;


public class Main {
    public static void main(String[] args) {
        staticFiles.location("/public");
        get("/home", Controlador.indice);
        get("/productos", Controlador.allProductos);
        get("/masinfo", Controlador.moreInfo);
        get("/admin", Controlador.admin);
    }
}