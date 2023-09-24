package com.example;
import static spark.Spark.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        get("/numerosCal", Controller.numeros);
        get("/numeros", Controller.numerosForm);

    }
}