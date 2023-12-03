package com.aydsii.porky;

import static spark.Spark.*;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import spark.Session;

import com.aydsii.porky.AbtractFactory.DAOFactory;
import com.aydsii.porky.Controller.CarritoController;
import com.aydsii.porky.Controller.AdminController;
import com.aydsii.porky.Controller.ClienteController;
import com.aydsii.porky.Controller.PresupuestoController;
import com.aydsii.porky.Controller.ProductoController;
import com.aydsii.porky.DAO.FireBaseDAO;
import com.aydsii.porky.DAO.PresupuestoDAO;
import com.aydsii.porky.DAO.ProductoDAO;
import com.google.firebase.auth.FirebaseAuthException;


public class Main {
    public static Session userSession;
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, FirebaseAuthException {
        
        DAOFactory daoFactory = new DAOFactory();
        ProductoDAO productoDAO = daoFactory.getProductoDAO();
        FireBaseDAO fireBaseDAO = daoFactory.getFireBaseDAO();
        PresupuestoDAO presupuestoDAO = daoFactory.getPresupuestoDAO();

        ClienteController controladorCliente = new ClienteController();
        ProductoController productoControlador = new ProductoController(productoDAO, fireBaseDAO);
        CarritoController carritoController = new CarritoController(productoDAO, fireBaseDAO);
        AdminController controladorAdmin = new AdminController(productoDAO, fireBaseDAO);
        PresupuestoController presupuestoController = new PresupuestoController(productoDAO, presupuestoDAO, fireBaseDAO);
        
        staticFiles.location("/public");
        //Lado del Cliente
        get("/home", controladorCliente.indice);
        get("/login", controladorCliente.logIn);
        get("/login", controladorCliente.logIn);
        get("/singup", controladorCliente.singUp);
        get("/logout", controladorCliente.logOut);
        //Presupuesto
        get("/presupuesto", presupuestoController.renderPresupuestoForm);
        post("/enviarPresupuesto", "application/json", presupuestoController.handlePresupuestoRequest);
        //Productos
        get("/productos", productoControlador.listarProductos);
        get("/producto", productoControlador.buscarNombre);
        get("/masinfo", productoControlador.masInformacion);
        //Carrito
        get("/carrito", carritoController.carrito);
        get("/micarrito", carritoController.miCarrito);
        //Lado del administrador
        get("/admin", controladorAdmin.admin);
        get("/admin/productos", controladorAdmin.adminProductos);
        get("/admin/sobremi", controladorAdmin.sobreMi);
        get("/admin/encargos", controladorAdmin.encargos);
        get("/admin/productos/agregar", controladorAdmin.addProducto);
        get("/admin/agregado", controladorAdmin.productoAgregado);
    }
}