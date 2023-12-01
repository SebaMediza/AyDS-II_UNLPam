package com.aydsii.porky.Controller;

import com.aydsii.porky.DAOs.FireBaseDAO;
import com.aydsii.porky.DAOs.PresupuestoDAO;
import com.aydsii.porky.DAOs.ProductoDAO;
import com.aydsii.porky.model.Presupuesto;
import com.aydsii.porky.model.Producto;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import spark.ModelAndView;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

@RequiredArgsConstructor
@SuppressWarnings("unchecked")
public class PresupuestoController {

    private static Gson gson = new Gson();
    private ProductoDAO productoDAO;
    private FireBaseDAO fireBaseDAO;
    private PresupuestoDAO presupuestoDAO;

    public PresupuestoController(ProductoDAO productoDAO, PresupuestoDAO presupuestoDAO, FireBaseDAO fireBaseDAO) {
        this.productoDAO = productoDAO;
        this.presupuestoDAO = presupuestoDAO;
        this.fireBaseDAO = fireBaseDAO;
    }
    @SuppressWarnings("rawtypes")
    public Route renderPresupuestoForm = (request, response) -> {
        HashMap model = new HashMap<>();
        HashMap<Integer, Producto> productData = new HashMap<>();
        productData = productoDAO.listarProductos(fireBaseDAO.connectToDB());
        //System.out.println(productData);
        model.put("RES", productData);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/presupuesto.vsl"));
    };

    public Route handlePresupuestoRequest = (request, response) -> {
        try {
            Presupuesto presupuesto = gson.fromJson(request.body(), Presupuesto.class);
    
            presupuestoDAO.savePresupuesto(fireBaseDAO.connectToDB(), presupuesto);
    
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
