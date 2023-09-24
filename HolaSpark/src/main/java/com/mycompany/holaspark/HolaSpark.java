package com.mycompany.holaspark;

import static spark.Spark.* ;
public class HolaSpark {
    public static void main(String[] args) { 
        //get("/hola", (req, res) -> "Hola Spark");
        get("/hola", (req, res) -> {
            return "Hola Spark " + req.queryParams("nombre") + " " +  req.queryParams("apellido"); 
        }); 
    }
} 

