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

    @SuppressWarnings("rawtypes")
    public static Route productoAgregado = (Request request, Response response) -> {
        HashMap model = new HashMap();
        String nombre = request.queryParams("name");
        int precio_vta = Integer.parseInt(request.queryParams("price"));
        int cant_porciones = Integer.parseInt(request.queryParams("cant_porciones"));
        String img_producto = request.queryParams("photo");
        String des_producto = request.queryParams("description");
        ProductoDAO.insertarProducto(FireBaseController.getFirestoreConnection(), nombre, precio_vta, cant_porciones, des_producto, img_producto, "", "", "");
        model.put("template","template/admin.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout2.vsl"));
    };
}
