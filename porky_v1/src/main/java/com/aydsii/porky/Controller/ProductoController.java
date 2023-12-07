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
        if (Main.userSession != null && !Main.userSession.attribute("uid").toString().matches(ClienteController.adminUid)) {
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
        if (Main.userSession != null && !Main.userSession.attribute("uid").toString().matches(ClienteController.adminUid)) {
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
        if (Main.userSession != null && !Main.userSession.attribute("uid").toString().matches(ClienteController.adminUid)) {
            layout = "template/layoutUser.vsl";
        }else{
            layout = "template/layoutAdmin.vsl";
        }
        return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
    };
}
