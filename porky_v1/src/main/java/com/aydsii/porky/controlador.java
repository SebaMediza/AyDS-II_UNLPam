package com.aydsii.porky;

import java.util.HashMap;
import java.util.List;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

@SuppressWarnings("unchecked")
public class controlador {
    public static Route indice = (Request request, Response response) -> {
        HashMap<String, String> model = new HashMap<>();
        model.put("template","template/indice.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
    @SuppressWarnings("rawtypes")
    public static Route allProductos = (Request request, Response response) -> {
        HashMap model = new HashMap();
        List<producto> RES = producto.buscarProducto();
        System.out.print(RES);
        model.put("RES", RES);
        model.put("template","template/carta.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
}
