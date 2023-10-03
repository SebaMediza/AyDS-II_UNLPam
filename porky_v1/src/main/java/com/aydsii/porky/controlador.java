package com.aydsii.porky;

import java.util.HashMap;
import java.util.List;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

@SuppressWarnings("unchecked")
public class Controlador {
    @SuppressWarnings("rawtypes")
    public static Route indice = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template/indice.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };

    @SuppressWarnings("rawtypes")
    public static Route allProductos = (Request request, Response response) -> {
        HashMap model = new HashMap();
        List<Producto> RES = ProductoDAO.buscarProducto();
        //System.out.print(RES);
        model.put("RES", RES);
        model.put("template","template/carta.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };

    @SuppressWarnings("rawtypes")
    public static Route moreInfo = (Request request, Response response) -> {
        HashMap model = new HashMap();
        List<Producto> RES = ProductoDAO.masInformacion(Integer.valueOf(request.queryParams("id")));
        List<Receta> RES2 = RecetaDAO.Receta(Integer.valueOf(request.queryParams("id")));
        //System.out.println(RES);
        model.put("RES", RES);
        model.put("RES2", RES2);
        model.put("template","template/infoproducto.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };

    @SuppressWarnings("rawtypes")
    public static Route nameQuerry = (Request request, Response response) -> {
        HashMap model = new HashMap();
        List<Producto> RES = ProductoDAO.masInformacion(request.queryParams("nombre"));
        System.out.print(RES);
        //List<Receta> RES2 = RecetaDAO.Receta(Integer.valueOf(request.queryParams(Integer.valueOf(RES.get(0)))));
        model.put("RES", RES);
        model.put("template","template/carta.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };

    @SuppressWarnings("rawtypes")
    public static Route admin = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template/infoproducto.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
}