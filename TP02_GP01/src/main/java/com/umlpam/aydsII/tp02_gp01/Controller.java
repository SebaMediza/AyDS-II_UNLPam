package com.umlpam.aydsII.tp02_gp01;

import spark.Request;
import spark.Response;
import spark.Route;
import java.util.HashMap; 
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


@SuppressWarnings("unchecked")
public class Controller {
    @SuppressWarnings("rawtypes")
    public static Route esPalindromo = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        boolean res = ej.esPalindromo(request.queryParams("palabra"));
        HashMap model = new HashMap();
        model.put("palabra", request.queryParams("palabra"));
        model.put("RES", res);
        model.put("template","template/esPalindromo.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
        //return "Resultado " + res;
    };
    
    public static Route cantLetras = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        int res = ej.cantCaracteres(request.queryParams("palabra"));
        return "La palabra tiene " + res + " letras";
    };
    
    public static Route periArea = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        double radio = Integer.parseInt(request.queryParams("radio"));
        return ej.periArea(radio);
    };
    
    public static Route operaciones = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        int a = Integer.parseInt(request.queryParams("a"));
        int b = Integer.parseInt(request.queryParams("b"));
        return ej.operaciones(a, b);
    };
    
    public static Route timestamp = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        int a = Integer.parseInt(request.queryParams("segs"));
        return ej.segConvertor(a);
    };
    
    public static Route equipos = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        int a = Integer.parseInt(request.queryParams("idequipo"));
        return ej.equiposFutbol(a);
    };
    
    public static Route telEmergencias = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        return ej.telEmergencias(request.queryParams("servicio"));
    };
    
    public static Route books = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        return ej.bookQuery(request.queryParams("autor"));
    };
    
    public static Route dolar = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        return ej.getDolarOficial();
    };
    
    public static Route provincias = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        return ej.provinciasArgentinas();
    };    
}
