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
        HashMap<Integer, Producto> RES = ProductoDAO.listarProductos(FireBaseController.getFirestoreConnection());
        model.put("RES", RES);
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
        System.out.println("En controlador admin");
        HashMap model = new HashMap();
        String nombre = request.queryParams("name");
        int precio_vta = Integer.parseInt(request.queryParams("price"));
        int cant_porciones = Integer.parseInt(request.queryParams("cant_porciones"));
        String des_producto = request.queryParams("description");
        // String img_producto0 = request.queryParams("img_producto0");
        // String img_producto1 = request.queryParams("img_producto1");
        // String img_producto2 = request.queryParams("img_producto2");
        // String img_producto3 = request.queryParams("img_producto3");
        System.out.println(nombre);
        System.out.println(precio_vta);
        System.out.println(cant_porciones);
        System.out.println(des_producto);
        // System.out.println(img_producto0);
        // System.out.println(img_producto1);
        // System.out.println(img_producto2);
        // System.out.println(img_producto3);
        // ProductoDAO.insertarProducto(FireBaseController.getFirestoreConnection(), nombre, precio_vta, cant_porciones, des_producto, img_producto0, img_producto1, img_producto2, img_producto3);
        ProductoDAO.insertarProducto(FireBaseController.getFirestoreConnection(), nombre, precio_vta, cant_porciones, des_producto, "", "", "", "");
        model.put("template","template/admin.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout2.vsl"));
    };
}
