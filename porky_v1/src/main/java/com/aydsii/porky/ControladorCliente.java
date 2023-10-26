package com.aydsii.porky;

import java.util.HashMap;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

@SuppressWarnings("unchecked")
public class ControladorCliente {
    @SuppressWarnings("rawtypes")
    public static Route indice = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template\\indice.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
    @SuppressWarnings("rawtypes")
    public static Route logIn = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template\\login.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
}