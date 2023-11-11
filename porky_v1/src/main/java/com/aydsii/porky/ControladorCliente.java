package com.aydsii.porky;

import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

@SuppressWarnings("unchecked")
@Slf4j
public class ControladorCliente {

    final static String adminUid = "Am0dLzqsvDVhyhhwLXbob4m484y2";

    @SuppressWarnings("rawtypes")
    public static Route indice = (Request request, Response response) -> {
        HashMap model = new HashMap();
        String layout = "";
        String uid = "";
        if (Main.userSession == null) {
            if (request.queryParams("uid") != null) {
                if (request.queryParams("uid").matches(adminUid)) {
                    uid = request.queryParams("uid");
                } else {
                    uid = "user";
                }
            }
            switch (uid) {
                case "user":
                    layout = "template/layoutUser.vsl";
                    Main.userSession = request.session(true);
                    uid = request.queryParams("uid");
                    Main.userSession.attribute("uid", uid);
                    break;
                case adminUid:
                    layout = "template/layoutAdmin.vsl";
                    Main.userSession = request.session(true);
                    Main.userSession.attribute("uid", uid);
                    log.info("Admin Loggeado");
                    break;
                default:
                    layout = "template/layout.vsl";
            }
        }else{
            if (Main.userSession != null && Main.userSession.attribute("uid").toString().matches(adminUid)) {
                layout = "template/layoutAdmin.vsl";
            }else{
                layout = "template/layoutUser.vsl";
            }
        }
        model.put("template", "template\\indice.vsl");
        // System.out.println(Main.userSession.attributes());
        return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
    };
    @SuppressWarnings("rawtypes")
    public static Route logIn = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template", "template\\login.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
    @SuppressWarnings("rawtypes")
    public static Route singUp = (Request request, Response response) -> {
        HashMap model = new HashMap();
        model.put("template", "template\\registro.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
    @SuppressWarnings("rawtypes")
    public static Route logOut = (Request request, Response response) -> {
        Main.userSession = request.session(false);
        if (Main.userSession != null) {
            Main.userSession.invalidate();
        }
        HashMap model = new HashMap();
        model.put("template", "template\\indice.vsl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "template/layout.vsl"));
    };
}