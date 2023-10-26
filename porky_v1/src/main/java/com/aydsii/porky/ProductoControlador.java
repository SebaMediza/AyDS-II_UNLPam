package com.aydsii.porky;

import java.util.HashMap;
import java.util.List;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

@SuppressWarnings("unchecked")
public class ProductoControlador {
    @SuppressWarnings("rawtypes")
    public static Route listarProductos = (Request request, Response response) -> {
        HashMap model = new HashMap();
        HashMap<Integer, Producto> RES = ProductoDAO.listarProductos(FireBaseController.getFirestoreConnection());
        model.put("RES", RES);
        model.put("template","template/carta.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };

    @SuppressWarnings("rawtypes")
    public static Route masInformacion = (Request request, Response response) -> {
        HashMap model = new HashMap();
        String temp = request.queryParams("id");
        HashMap<Integer, Producto> RES = ProductoDAO.ampliarProducto(FireBaseController.getFirestoreConnection(), temp);
        model.put("RES", RES);
        model.put("template","template/infoproducto.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };

    @SuppressWarnings("rawtypes")
    public static Route buscarNombre = (Request request, Response response) -> {
        HashMap model = new HashMap();
        String temp = request.queryParams("nombre");
        System.out.println(temp);
        HashMap<Integer, Producto> RES = ProductoDAO.buscarProductoNombre(FireBaseController.getFirestoreConnection(), temp);
        model.put("RES", RES);
        model.put("template","template/carta.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };

}
