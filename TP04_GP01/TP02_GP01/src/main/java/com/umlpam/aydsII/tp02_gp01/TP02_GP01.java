package com.umlpam.aydsII.tp02_gp01;
import static spark.Spark.*;


public class TP02_GP01 {
    public static void main(String[] args) {
        get("/palindromo", Controller.palindromoForm);
        get("/esPalindromo", Controller.esPalindromo);

        get("/cantLetrasPalabra", Controller.cantLetras);
        get("/cantLetras", Controller.cantLetrasForm);

        get("/periareaCal", Controller.periArea);
        get("/periarea", Controller.periAreaForm);

        get("/operacionesCal", Controller.operaciones);
        get("/operaciones", Controller.operacionesForm);
        get("/calculadora", Controller.calcu);

        get("/segsCal", Controller.timestamp);
        get("/segs", Controller.segsForm);

        get("", Controller.equipos);
        get("/emergencia", Controller.telEmergencias);
        get("/libros", Controller.books);
        
        get("/dolar", Controller.dolar);

        get("/provincias", Controller.provincias);
    }
}
