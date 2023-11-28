package com.aydsii.porky;

import java.util.HashMap;
import java.util.Vector;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

@SuppressWarnings("unchecked")
public class CarritoController {
    private static Vector<String> carritoList = new Vector<>();
    
    public static Route carrito = (Request request, Response response) -> {
        carritoList.add(request.queryParams("item"));
        response.redirect("/productos");
        return null;
    };

    @SuppressWarnings("rawtypes")
    public static Route miCarrito = (Request request, Response response) -> {
        String layout = "";
        HashMap model = new HashMap();
        Vector<Producto> RES = new Vector<>();
        int totalCarrito = 0;
        RES = ProductoDAO.buscarProductoId(FireBaseController.getFirestoreConnection(), carritoList);
        for (Producto producto : RES) {
            totalCarrito += Integer.valueOf(producto.getPrecio_vta());
        }
        model.put("RES", RES);
        model.put("TOTAL", totalCarrito);
        model.put("template", "template/carrito.vsl");
        layout = Main.userSession == null ?  "template/layout.vsl" :  "template/layoutUser.vsl";
        return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
    };
}
