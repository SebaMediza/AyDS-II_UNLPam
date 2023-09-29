package com.umlpam.aydsII.tp02_gp01;
import static spark.Spark.*;


public class TP02_GP01 {
    public static void main(String[] args) {
        get("/indice", Controller.indice);

        get("/palindromo", Controller.palindromoForm); //este
        get("/esPalindromo", Controller.esPalindromo);

        get("/cantLetrasPalabra", Controller.cantLetras);
        get("/cantLetras", Controller.cantLetrasForm); //este

        get("/periareaCal", Controller.periArea);
        get("/periarea", Controller.periAreaForm); //este

        get("/operacionesCal", Controller.operaciones);
        get("/operaciones", Controller.operacionesForm); //este
        
        get("/calculadora", Controller.calcu); //este

        get("/segsCal", Controller.timestamp);
        get("/segs", Controller.segsForm); //este

        get("/emergencia", Controller.telEmergencias);
        get("/libros", Controller.books);
        
        get("/dolar", Controller.dolar); //este

        get("/provincias", Controller.provincias);

        get("/partidos", Controller.partidos); //este
        get("/mostrarPartidos", Controller.mostrarPartidos);
    }
}
