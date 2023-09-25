package com.example;
import static spark.Spark.*;
public class Main {
    public static void main(String[] args) {
        
        get("/numerosCal", Controller.numeros);
        get("/numeros", Controller.numerosForm);

    }
}