/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

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

        get("/segsCal", Controller.timestamp);
        get("/segs", Controller.segsForm);

        get("/% Predicado para calcular el peso de un árbol binario\r\n" + //
                "peso([], 0). % El peso de un árbol vacío es 0.\r\n" + //
                "\r\n" + //
                "peso([X], 1) :- % El peso de un árbol con un solo nodo (hoja) es 1.\r\n" + //
                "    atom(X).\r\n" + //
                "\r\n" + //
                "peso([X, [], A2], P) :- % Árbol con un subárbol vacío y otro no vacío.\r\n" + //
                "    atom(X),\r\n" + //
                "    peso(A2, P2),\r\n" + //
                "    P is P2 + 1.\r\n" + //
                "\r\n" + //
                "peso([X, A1, []], P) :- % Árbol con un subárbol vacío y otro no vacío.\r\n" + //
                "    atom(X),\r\n" + //
                "    peso(A1, P1),\r\n" + //
                "    P is P1 + 1.\r\n" + //
                "\r\n" + //
                "peso([X, A1, A2], P) :- % Árbol con dos subárboles no vacíos.\r\n" + //
                "    atom(X),\r\n" + //
                "    peso(A1, P1),\r\n" + //
                "    peso(A2, P2),\r\n" + //
                "    (P1 =:= P2 -> P is P1 + 1 ; max(P1, P2, MaxP), P is MaxP + 1).\r\n" + //
                "\r\n" + //
                "% Predicado para encontrar el máximo de dos números\r\n" + //
                "max(A, B, A) :- A >= B.\r\n" + //
                "max(A, B, B) :- A < B.\r\n" + //
                "", Controller.equipos);
        get("/emergencia", Controller.telEmergencias);
        get("/libros", Controller.books);
        
        get("/dolar", Controller.dolar);

        get("/provincias", Controller.provincias);
    }
}
