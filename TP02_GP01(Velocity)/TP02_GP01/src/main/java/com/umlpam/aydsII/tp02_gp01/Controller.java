package com.umlpam.aydsII.tp02_gp01;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.lang.reflect.Type;

//import org.apache.commons.collections.BoundedFifoBuffer;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class Controller {

    //palindromo
    public static Route palindromoForm = (Request request, Response response) -> {
        
        HashMap<String, String> model = new HashMap<>();
       
        model.put("template","template/palindromo-form.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };

    public static Route esPalindromo = (Request request, Response response) ->{
        Ejercicios ej = new Ejercicios();
        boolean res = ej.esPalindromo(request.queryParams("palabra"));
        String finalreString;
        if (res){
            finalreString = "true"; 
        }else
            finalreString = "false";
        
        HashMap<String, String> model = new HashMap<>();
        model.put("palabra", request.queryParams("palabra"));
        model.put("RES", finalreString);
        model.put("template","template/palindromo.vsl");

        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
    
    //Contador de letras
    public static Route cantLetrasForm = (Request request, Response response) -> {
        
        HashMap<String, String> model = new HashMap<>();
       
        model.put("template","template/cantLetrasForm.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };

    public static Route cantLetras = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        Integer res = ej.cantCaracteres(request.queryParams("palabra"));
        
        HashMap<String, String> model = new HashMap<>();
        model.put("palabra", request.queryParams("palabra"));
        model.put("RES", res.toString());
        model.put("template","template/cantLetras.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));

    };
    
    //perimetro y area

    public static Route periAreaForm = (Request request, Response response) -> {
        
        HashMap<String, String> model = new HashMap<>();
       
        model.put("template","template/radioForm.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };

    public static Route periArea = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        double radio = Integer.parseInt(request.queryParams("radio"));

        HashMap<String, String> model = new HashMap<>();
        model.put("radio", request.queryParams("radio"));
        model.put("RES", ej.periArea(radio));

        model.put("template","template/radio.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
    
    //Suma y resta
    public static Route operacionesForm = (Request request, Response response) -> {
        
        HashMap<String, String> model = new HashMap<>();
       
        model.put("template","template/operacionesForm.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };

    public static Route operaciones = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        int a = Integer.parseInt(request.queryParams("a"));
        int b = Integer.parseInt(request.queryParams("b"));
        String op = request.queryParams("op");

        HashMap<String, String> model = new HashMap<>();
        model.put("a", request.queryParams("a"));
        model.put("b", request.queryParams("b"));
        model.put("op", request.queryParams("op"));

        model.put("RES", ej.operaciones(a, b, op));
        model.put("template","template/operaciones.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
    
    //Segundos a Dias, Horas, Minutos y segundos
    public static Route segsForm = (Request request, Response response) -> {
        
        HashMap<String, String> model = new HashMap<>();
       
        model.put("template","template/segsForm.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
    
    public static Route timestamp = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        int a = Integer.parseInt(request.queryParams("segs"));
        
        HashMap<String, String> model = new HashMap<>();
        model.put("segs", request.queryParams("segs"));
        model.put("RES", ej.segConvertor(a));
        model.put("template","template/segs.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));

    };
    
    public static Route equipos = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        String a = request.queryParams("idequipo");
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
        
        HashMap model = new HashMap();

        String json = ej.getDolarOficial();

        Gson g = new Gson();
        Type listType = new TypeToken<List<Ejercicios>>(){}.getType();
        List<Ejercicios> dolares = g.fromJson(json, listType);

        
        model.put("RES", dolares);
        model.put("template","template/dolar.vsl");

        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
        //return ej.getDolarOficial();
    };
    
    public static Route provincias = (Request request, Response response) -> {
        Ejercicios ej = new Ejercicios();
        return ej.provinciasArgentinas();
    };    
}
