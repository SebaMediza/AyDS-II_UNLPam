package com.aydsii.porky.Controller;

import java.util.HashMap;

import com.aydsii.porky.Main;
import com.aydsii.porky.DAO.FireBaseDAO;
import com.aydsii.porky.DAO.ProductoDAO;
import com.aydsii.porky.Models.Producto;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

@SuppressWarnings("unchecked")
public class ProductoController {
    private ProductoDAO productoDAO;
    private FireBaseDAO fireBaseDAO;

    public ProductoController(ProductoDAO productoDAO, FireBaseDAO fireBaseDAO) {
        this.productoDAO = productoDAO;
        this.fireBaseDAO = fireBaseDAO;
    }

    @SuppressWarnings("rawtypes")
    public Route listarProductos = (Request request, Response response) -> {
        String layout = "";
        HashMap model = new HashMap();
        HashMap<Integer, Producto> RES = productoDAO.listarProductos(fireBaseDAO.connectToDB());
        model.put("RES", RES);
        model.put("template","template/carta.vsl");
        layout = "template/layout.vsl";
        if (Main.userSession != null && !Main.userSession.attribute("uid").toString().matches(UsuarioController.adminUid)) {
            layout = "template/layoutUser.vsl";
        }else{
            layout = "template/layoutAdmin.vsl";
        }
        return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
    };

    @SuppressWarnings("rawtypes")
    public Route masInformacion = (Request request, Response response) -> {
        String layout = "";
        HashMap model = new HashMap();
        String temp = request.queryParams("id");
        HashMap<Integer, Producto> RES = productoDAO.ampliarProducto(fireBaseDAO.connectToDB(), temp);
        model.put("RES", RES);
        model.put("template","template/infoproducto.vsl");
        layout = "template/layout.vsl";
        if (Main.userSession != null && !Main.userSession.attribute("uid").toString().matches(UsuarioController.adminUid)) {
            layout = "template/layoutUser.vsl";
        }else{
            layout = "template/layoutAdmin.vsl";
        }
        return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
    };

    @SuppressWarnings("rawtypes")
    public Route buscarNombre = (Request request, Response response) -> {
        String layout = "";
        HashMap model = new HashMap();
        String temp = request.queryParams("nombre");
        HashMap<Integer, Producto> RES = productoDAO.buscarProductoNombre(fireBaseDAO.connectToDB(), temp);
        model.put("RES", RES);
        model.put("template","template/carta.vsl");
        layout = "template/layout.vsl";
        if (Main.userSession != null && !Main.userSession.attribute("uid").toString().matches(UsuarioController.adminUid)) {
            layout = "template/layoutUser.vsl";
        }else{
            layout = "template/layoutAdmin.vsl";
        }
        return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
    };

    public Route adminProductos = (Request request, Response response) -> {
        HashMap model = new HashMap();
        HashMap<Integer, Producto> RES = productoDAO.listarProductos(fireBaseDAO.connectToDB());
        model.put("RES", RES);
        model.put("template","template/adminProductos.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout2.vsl"));
    };
    @SuppressWarnings("rawtypes")
    public Route crearProducto = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template","template/agregarProducto.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout2.vsl"));
    };

    @SuppressWarnings("rawtypes")
    public Route cargarProducto = (Request request, Response response) -> {
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
