package com.example;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.List;

//import org.apache.commons.collections.BoundedFifoBuffer;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

@SuppressWarnings("unchecked")
public class Controller {
    public static Route numerosForm = (Request request, Response response)->{
        HashMap<String, String> model = new HashMap<>();
        
        model.put("template","template/numerosForm.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
    @SuppressWarnings("rawtypes")
    public static Route numeros = (Request request, Response response) -> {
        Numeros num = new Numeros();
        int a = Integer.parseInt(request.queryParams("a"));
        int b = Integer.parseInt(request.queryParams("b"));
        int c = Integer.parseInt(request.queryParams("c"));
        int d = Integer.parseInt(request.queryParams("d"));
        int e = Integer.parseInt(request.queryParams("e"));
        int f = Integer.parseInt(request.queryParams("f"));
        boolean idButton = Boolean.parseBoolean(request.queryParams("idButton")) ;

        List<Integer> listanumeros = num.listnumeros(a, b, c, d, e , f, idButton);

        HashMap model = new HashMap();
        model.put("a", request.queryParams("a"));
        model.put("b", request.queryParams("b"));
        model.put("c", request.queryParams("c"));
        model.put("d", request.queryParams("d"));
        model.put("e", request.queryParams("e"));
        model.put("f", request.queryParams("f"));
        model.put("idButton", idButton);

        model.put("RES", listanumeros);

        model.put("template","template/numeros.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };

}
