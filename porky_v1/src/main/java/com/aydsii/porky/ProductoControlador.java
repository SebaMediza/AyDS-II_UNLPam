package com.aydsii.porky;

import java.util.HashMap;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

@SuppressWarnings("unchecked")
public class ProductoControlador {
    @SuppressWarnings("rawtypes")
    public static Route listarProductos = (Request request, Response response) -> {
        String layout = "";
        HashMap model = new HashMap();
        HashMap<Integer, Producto> RES = ProductoDAO.listarProductos(FireBaseController.getFirestoreConnection());
        model.put("RES", RES);
        model.put("template","template/carta.vsl");
        layout = "template/layout.vsl";
        if (Main.userSession != null && !Main.userSession.attribute("uid").toString().matches(ControladorCliente.adminUid)) {
            layout = "template/layoutUser.vsl";
        }else{
            layout = "template/layoutAdmin.vsl";
        }
        return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
    };

    @SuppressWarnings("rawtypes")
    public static Route masInformacion = (Request request, Response response) -> {
        String layout = "";
        HashMap model = new HashMap();
        String temp = request.queryParams("id");
        HashMap<Integer, Producto> RES = ProductoDAO.ampliarProducto(FireBaseController.getFirestoreConnection(), temp);
        model.put("RES", RES);
        model.put("template","template/infoproducto.vsl");
        layout = "template/layout.vsl";
        if (Main.userSession != null && !Main.userSession.attribute("uid").toString().matches(ControladorCliente.adminUid)) {
            layout = "template/layoutUser.vsl";
        }else{
            layout = "template/layoutAdmin.vsl";
        }
        return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
    };

    @SuppressWarnings("rawtypes")
    public static Route buscarNombre = (Request request, Response response) -> {
        String layout = "";
        HashMap model = new HashMap();
        String temp = request.queryParams("nombre");
        HashMap<Integer, Producto> RES = ProductoDAO.buscarProductoNombre(FireBaseController.getFirestoreConnection(), temp);
        model.put("RES", RES);
        model.put("template","template/carta.vsl");
        layout = "template/layout.vsl";
        if (Main.userSession != null && !Main.userSession.attribute("uid").toString().matches(ControladorCliente.adminUid)) {
            layout = "template/layoutUser.vsl";
        }else{
            layout = "template/layoutAdmin.vsl";
        }
        return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
    };

    @SuppressWarnings("rawtypes")
    public static Route carrtio = (Request request, Response response) -> {
        HashMap model = new HashMap();
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layoutUser.vsl"));
    };
}
