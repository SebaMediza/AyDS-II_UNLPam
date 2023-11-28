package com.aydsii.porky;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import spark.ModelAndView;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class PresupuestoController {

    private static Gson gson = new Gson();

    public static Route renderPresupuestoForm = (request, response) -> {
        HashMap model = new HashMap<>();
        HashMap<Integer, Producto> productData = new HashMap<>();
        productData = ProductoDAO.listarProductos(FireBaseController.getFirestoreConnection());

        model.put("RES", productData);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/presupuesto.vsl"));
    };

    public static Route handlePresupuestoRequest = (request, response) -> {
        try {
            Presupuesto presupuesto = gson.fromJson(request.body(), Presupuesto.class);
    
            PresupuestoDAO.savePresupuesto(FireBaseController.getFirestoreConnection(), presupuesto);
    
            request.session().attribute("alertMessage", "Presupuesto enviado");
            request.session().attribute("alertType", "cargado");
        } catch (Exception e) {
            e.printStackTrace();
    
            request.session().attribute("alertMessage", "Error enviando Presupuesto");
            request.session().attribute("alertType", "error");
        }
    
        response.redirect("/home");
        return null;
    };
}
