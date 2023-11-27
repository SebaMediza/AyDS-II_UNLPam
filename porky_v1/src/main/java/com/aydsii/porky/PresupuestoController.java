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
    private static PresupuestoService presupuestoService;

    public static Route renderPresupuestoForm = (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        Map<Integer, Producto> productData = ProductoDAO.listarProductos(FireBaseController.getFirestoreConnection());

        // Convert productData to JSON
        Gson gson = new Gson();
        String productDataJson = gson.toJson(productData);

        model.put("productDataJson", productDataJson);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/presupuesto.vsl"));
    };

    public static Route handlePresupuestoRequest = (request, response) -> {
        try {
            // Parse JSON from the form
            Presupuesto presupuesto = gson.fromJson(request.body(), Presupuesto.class);
    
            // Save to the service
            presupuestoService.savePresupuesto(presupuesto);
    
            // Set success message
            request.session().attribute("alertMessage", "Presupuesto enviado");
            request.session().attribute("alertType", "success");
        } catch (Exception e) {
            e.printStackTrace(); // Log or handle the exception as needed
    
            // Set error message
            request.session().attribute("alertMessage", "Error enviando Presupuesto");
            request.session().attribute("alertType", "error");
        }
    
        // Redirect to "/home" after handling the request
        response.redirect("/home");
        return "";
    };
}
