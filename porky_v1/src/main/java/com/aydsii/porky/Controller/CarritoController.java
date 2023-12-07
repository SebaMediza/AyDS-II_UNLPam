package com.aydsii.porky.Controller;

import java.util.HashMap;
import java.util.Vector;

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
public class CarritoController {
    private static Vector<String> carritoList = new Vector<>();

    private ProductoDAO productoDAO;
    private FireBaseDAO fireBaseDAO;

    public CarritoController(ProductoDAO productoDAO, FireBaseDAO fireBaseDAO) {
        this.productoDAO = productoDAO;
        this.fireBaseDAO = fireBaseDAO;
    }
    
    public Route carrito = (Request request, Response response) -> {
        carritoList.add(request.queryParams("item"));
        response.redirect("/productos");
        return null;
    };

    @SuppressWarnings("rawtypes")
    public Route miCarrito = (Request request, Response response) -> {
        String layout = "";
        HashMap model = new HashMap();
        Vector<Producto> RES = new Vector<>();
        int totalCarrito = 0;
        RES = productoDAO.buscarProductoId(fireBaseDAO.connectToDB(), carritoList);
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
