package com.aydsii.porky;

import java.util.HashMap;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

@SuppressWarnings("unchecked")
public class ControladorCliente {
    final static String adminUid = "Am0dLzqsvDVhyhhwLXbob4m484y2";
    @SuppressWarnings("rawtypes")
    public static Route indice = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template\\indice.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
    @SuppressWarnings("rawtypes")
    public static Route indiceLogeado = (Request request, Response response) -> {
        HashMap model = new HashMap();
        String layout = "";
        String uid = request.queryParams("uid");
        System.out.println(uid);
        if(uid.matches(adminUid)){
            layout = "template/layoutAdmin.vsl";
        }else{
            layout = "template/layout.vsl";
        }
        model.put("template","template\\indice.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
    };
    @SuppressWarnings("rawtypes")
    public static Route logIn = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template\\login.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
    @SuppressWarnings("rawtypes")
    public static Route singUp = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template\\registro.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
}