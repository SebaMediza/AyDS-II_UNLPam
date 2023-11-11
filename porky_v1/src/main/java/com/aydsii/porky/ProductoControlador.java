package com.aydsii.porky;

import java.util.HashMap;
import java.util.Vector;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

@SuppressWarnings("unchecked")
public class ProductoControlador {
    private static Vector<String> carritoList = new Vector<>();
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

    public static Route carrito = (Request request, Response response) -> {
        String item = request.queryParams("item"); 
        carritoList.add(item);
        for (String string : carritoList) {
            System.out.println(string);
        }
        //System.out.println(item);
        //HashMap model = new HashMap();
        response.redirect("/productos");
        //return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layoutUser.vsl"));
        return null;
    };
    
    @SuppressWarnings("rawtypes")
    public static Route miCarrito = (Request request, Response response) -> {
        String layout = "";
        HashMap model = new HashMap();
        Vector<Producto> RES = new Vector<>();
        RES = ProductoDAO.buscarProductoId(FireBaseController.getFirestoreConnection(), carritoList);
        for (Producto producto : RES){
            System.out.println(producto.getNombre());
        }
        model.put("RES", RES);
        model.put("template","template/carrito.vsl");
        layout = "template/layout.vsl";
        if (Main.userSession != null ) {
            layout = "template/layoutUser.vsl";
        }
        return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
    };
}
