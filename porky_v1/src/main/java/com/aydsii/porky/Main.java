package com.aydsii.porky;
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("/home", controlador.indice);
        get("/productos", controlador.allProductos);
        get("/masinfo", controlador.moreInfo);
    }
}