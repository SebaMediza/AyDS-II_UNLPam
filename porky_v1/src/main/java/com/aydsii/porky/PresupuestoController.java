package com.aydsii.porky;

import java.util.HashMap;
import java.util.Vector;

import io.grpc.InternalGlobalInterceptors;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

public class PresupuestoController {
    private static Vector<Integer> productosCargados = new Vector<Integer>();

    public static Route presupuesto = (Request request, Response response) -> {
        String layout = "template/layout.vsl";
        HashMap model = new HashMap();
        Vector<Producto> RES = new Vector<>();
        HashMap<Integer, String> options = new HashMap<>();
        HashMap<Integer, Producto> hashMapProductos = ProductoDAO.listarProductos(FireBaseController.getFirestoreConnection());
        
        hashMapProductos.forEach((id, producto) -> {
            if (!productosCargados.contains(id))
                options.put(Integer.parseInt(producto.getId()), producto.getNombre());
        });

        model.put("RES", RES);
        model.put("options", options);
        model.put("template", "template/presupuesto.vsl");
        
        return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
    };
}
