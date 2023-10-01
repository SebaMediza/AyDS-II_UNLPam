package com.aydsii.porky;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

public class controlador {
    public static Route indice = (Request request, Response response) ->{
        HashMap<String, String> model = new HashMap<>();
        model.put("template","template/indice.vsl");
        System.out.println(producto.buscarProducto());
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
}
