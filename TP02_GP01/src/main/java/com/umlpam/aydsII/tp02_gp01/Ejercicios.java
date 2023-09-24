/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umlpam.aydsII.tp02_gp01;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class Ejercicios {
    final int policia = 911;
    final int emergenciasMedicas = 107;
    final int defensaCivil = 103;
    final int emergenciaAmbiental = 105;
    final int asistenciaAlSuicida = 135;
    final int extraviados = 142;
    final int violenciaGenero = 144;
    final int bomberos = 100;
    
    /*
    Ejercicio 1: Dada una palabra ingresada por el usuario, devolver si es 
    palíndromo o no.
    */
    public Boolean esPalindromo(String palabra){
        palabra = palabra.replaceAll("\\s", "").toLowerCase();
        String palabraInvertida = new StringBuilder(palabra).reverse().toString();
        Boolean res = false;
        if(palabra.equals(palabraInvertida)){
            res = true;
        }
    return res;
    }
    
    /*
    Ejercicio 2: Dada una palabra ingresada por el usuario, devolver su longitud.
    */
    public int cantCaracteres(String palabra){
        int cantLetras = 0;
        for (int i=0;i<palabra.length();i++){
            cantLetras++;
        }
    return cantLetras;
    }
    
    /*
    Ejercicio 3: Dado el radio de una circunferencia ingresados por el usuario,
    calcular su perímetro y área.
    */
    public String periArea(double radio){
        double perimetro = 2 * Math.PI * radio;
        double area = Math.PI * Math.pow(radio, 2.0);
    return "El area del circulo es: " + area + " y su perimetro es: " + perimetro;
    }
    
    /*
    Ejercicio 4: Dados dos números ingresados por el usuario, realizar la suma y
    resta de ambos.
    */
    public String operaciones(int a, int b){
        return "La suma de los numeros es " + (a + b) + " y la resta: " + (a - b);
    }
    
    /*
    Ejercicio 5: Dada una cantidad de segundos ingresados por el usuario,
    convertirlos en hora, minutos y segundos.
    */
    public String segConvertor(int seg){
        int horas = seg / 3600; // 1 hora tiene 3600 segundos
        int minutos = (seg % 3600) / 60; // 1 minuto tiene 60 segundos
        int segundos = seg % 60;
    return horas + " Horas, " + minutos + " Minutos, " +  segundos + " Segundos";
    }
    
    /*
    Ejercicio 6: Dado un equipo de fútbol solicitado por el usuario, devolver los
    partidos de fútbol jugados por el equipo, en qué campeonatos y el resultado
    obtenido. Por ejemplo, al consultar sobre “Boca”, se deberá devolver:
    o [{"equipo1":"Independiente","equipo2":"Racing","resultado":"Ganó Racing 3-1","ronda":"Final Libertadores","jugado":true}]
    */
    public String equiposFutbol(int teamID) throws Exception{
        final String apiKey = "d75abd6f1ff60020d80852164b2bfb33bfd726daa7b86c4dd9c83201b46a91c8";
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://apiv2.allsportsapi.com/football/?&met=Teams&teamId=" + teamID + "&APIkey=" +  apiKey);
        HttpResponse response = client.execute(request);
        String json = EntityUtils.toString(response.getEntity());
    return json;
    }
    
    /*
    Ejercicio 7: Devolver los teléfonos para emergencias, según el dato solicitado
    por el usuario. Por ejemplo, si solicita “policía”, que devuelva “911”. Lo mismo
    con los bomberos, violencia de género y otros, cargados en memoria durante la
    ejecución del programa.
    */
    public String telEmergencias(String servicio){
        int numeroEmergencia = -1;
        if (servicio.equals("policia")){
            numeroEmergencia = policia;
        }
        if (servicio.equals("emergencias medicas")){
            numeroEmergencia = emergenciasMedicas;
        }
        if (servicio.equals("defensa civil")){
            numeroEmergencia = defensaCivil;
        }
        if (servicio.equals("emergencia ambiental")){
            numeroEmergencia = emergenciaAmbiental;
        }
        if (servicio.equals("asistencia al suicida")){
            numeroEmergencia = asistenciaAlSuicida;
        }
        if (servicio.equals("extraviados")){
            numeroEmergencia = extraviados;
        }
        if (servicio.equals("violencia de genero")){
            numeroEmergencia = violenciaGenero;
        }
        if (servicio.equals("bomberos")){
            numeroEmergencia = bomberos; 
        }
    return "El numero de la " + servicio + " es " + numeroEmergencia;
    }
    
    /*
    Ejercicio 8: Dado un autor ingresado por el usuario, devolver los libros escritos
    por él.
    */
    public String bookQuery(String autor) throws Exception{
        String apiKey = "AIzaSyCPZ7lrg-xj2rdA3I_3DMRWApBaD6-dMa0";
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://www.googleapis.com/books/v1/volumes?q=inauthor:" + autor + "&key=" + apiKey);
        HttpResponse response = client.execute(request);
        String json = EntityUtils.toString(response.getEntity());
    return json;
    }
    
    /*
    Ejercicio 9: Utilizar la API https://dolarapi.com para mostrar el valor de las
    distintas cotizaciones del dólar a la fecha.
    */
    public String getDolarOficial() throws Exception {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://dolarapi.com/v1/dolares/oficial");
        HttpResponse response = httpClient.execute(httpGet);
        String json = EntityUtils.toString(response.getEntity());
    return json;
    }
    
    /*
    Ejercicio 10: Obtener las provincias de Argentina a partir de la información
    suministrada por la API https://datosgobar.github.io/georef-ar-api/
    */
    public String provinciasArgentinas() throws Exception{
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://apis.datos.gob.ar/georef/api/provincias");
        HttpResponse response = httpClient.execute(httpGet);
        String json = EntityUtils.toString(response.getEntity());
    return json;
    }
}
