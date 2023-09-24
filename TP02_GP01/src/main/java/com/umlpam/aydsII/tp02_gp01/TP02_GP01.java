/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.umlpam.aydsII.tp02_gp01;
import static spark.Spark.get;

public class TP02_GP01 {
    public static void main(String[] args) {
        get("/palindromo", Controller.esPalindromo);
        get("/cantletras", Controller.cantLetras);
        get("/periarea", Controller.periArea);
        get("/operaciones", Controller.operaciones);
        get("/segs", Controller.timestamp);
        get("/equipo", Controller.equipos);
        get("/emergencia", Controller.telEmergencias);
        get("/libros", Controller.books);
        get("/dolar", Controller.dolar);
        get("/provincias", Controller.provincias);
    }
}
