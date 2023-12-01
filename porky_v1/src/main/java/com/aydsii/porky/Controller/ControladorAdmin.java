package com.aydsii.porky.Controller;

import java.util.HashMap;

import com.aydsii.porky.DAOs.FireBaseDAO;
import com.aydsii.porky.DAOs.ProductoDAO;
import com.aydsii.porky.model.Producto;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

@SuppressWarnings("unchecked")
public class ControladorAdmin {
    private ProductoDAO productoDAO;
    private FireBaseDAO fireBaseDAO;

    public ControladorAdmin(ProductoDAO productoDAO, FireBaseDAO fireBaseDAO) {
        this.productoDAO = productoDAO;
        this.fireBaseDAO = fireBaseDAO;
    }
    @SuppressWarnings("rawtypes")
    public Route admin = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template/admin.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout2.vsl"));
    };

    @SuppressWarnings("rawtypes")
    public Route adminProductos = (Request request, Response response) -> {
        HashMap model = new HashMap();
        HashMap<Integer, Producto> RES = productoDAO.listarProductos(fireBaseDAO.connectToDB());
        model.put("RES", RES);
        model.put("template","template/adminProductos.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout2.vsl"));
    };
    
    @SuppressWarnings("rawtypes")
    public Route sobreMi = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template/sobreMi.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout2.vsl"));
    };
    
    @SuppressWarnings("rawtypes")
    public Route encargos = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template/encargos.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout2.vsl"));
    };

    @SuppressWarnings("rawtypes")
    public Route addProducto = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template/agregarProducto.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout2.vsl"));
    };

    @SuppressWarnings("rawtypes")
    public Route productoAgregado = (Request request, Response response) -> {
        System.out.println("En controlador admin");
        String nombre = request.queryParams("name");
        String precio_vta = request.queryParams("price");
        String cant_porciones = request.queryParams("cant_porciones");
        String des_producto = request.queryParams("description");
        String img_producto0 = request.queryParams("img_producto0");
        String img_producto1 = request.queryParams("img_producto1");
        String img_producto2 = request.queryParams("img_producto2");
        String img_producto3 = request.queryParams("img_producto3");
        productoDAO.insertarProducto(fireBaseDAO.connectToDB(), nombre, precio_vta, cant_porciones, des_producto, img_producto0, img_producto1, img_producto2, img_producto3);
        HashMap model = new HashMap();
        model.put("template","template/admin.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout2.vsl"));
    };
}
