package com.aydsii.porky;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

@SuppressWarnings("unchecked")
public class ControladorAdmin {
    @SuppressWarnings("rawtypes")
    public static Route admin = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template/admin.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout2.vsl"));
    };

    @SuppressWarnings("rawtypes")
    public static Route adminProductos = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template/adminProductos.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout2.vsl"));
    };
    
    @SuppressWarnings("rawtypes")
    public static Route sobreMi = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template/sobreMi.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout2.vsl"));
    };
    
    @SuppressWarnings("rawtypes")
    public static Route encargos = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template/encargos.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout2.vsl"));
    };

    @SuppressWarnings("rawtypes")
    public static Route addProducto = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template/agregarProducto.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout2.vsl"));
    };
}
