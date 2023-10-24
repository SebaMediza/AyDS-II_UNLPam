package com.aydsii.porky;
import static spark.Spark.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.FirebaseAuthException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, FirebaseAuthException {
        staticFiles.location("/public");
        /*//Lado del Cliente
        get("/home", ControladorCliente.indice);
        get("/productos", ProductoControlador.allProductos);
        get("/producto", ProductoControlador.nameQuerry);
        get("/masinfo", ProductoControlador.moreInfo);
        //Lado del administrador
        get("/admin", ControladorAdmin.admin);
        get("/admin/productos", ControladorAdmin.adminProductos);
        get("/admin/sobremi", ControladorAdmin.sobreMi);
        get("/admin/encargos", ControladorAdmin.encargos);
        get("/admin/productos/agregar", ControladorAdmin.addProducto);
        get("/admin/productos/agregado", ControladorAdmin.productoAgregado);*/
        Firestore firestore = FireBaseController.getFirestoreConnection();
        //new getData(firestore);
        //getData.addData(firestore);
        //getData.queryData(firestore);
        getData.userAccess(firestore);
    }
}