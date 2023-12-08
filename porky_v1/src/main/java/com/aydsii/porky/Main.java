package com.aydsii.porky;

import static spark.Spark.*;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import spark.Session;

import com.aydsii.porky.AbtractFactory.DAOFactory;
import com.aydsii.porky.Controller.CarritoController;
import com.aydsii.porky.Controller.PresupuestoController;
import com.aydsii.porky.Controller.ProductoController;
import com.aydsii.porky.Controller.UsuarioController;
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

        UsuarioController usuarioController = new UsuarioController(productoDAO, fireBaseDAO);
        ProductoController productoController = new ProductoController(productoDAO, fireBaseDAO);
        CarritoController carritoController = new CarritoController(productoDAO, fireBaseDAO);
        PresupuestoController presupuestoController = new PresupuestoController(productoDAO, presupuestoDAO, fireBaseDAO);
        
        staticFiles.location("/public");
        //Lado del Cliente
        get("/home", usuarioController.indice);
        get("/login", usuarioController.logIn);
        get("/singup", usuarioController.singUp);
        get("/logout", usuarioController.logOut);
        //Presupuesto
        get("/presupuesto", presupuestoController.crearPresupuesto);
        post("/enviarPresupuesto", "application/json", presupuestoController.enviarPresupuesto);
        //Productos
        get("/productos", productoController.listarProductos);
        get("/producto", productoController.buscarNombre);
        get("/masinfo", productoController.masInformacion);
        get("/admin/productos", productoController.adminProductos);
        get("/admin/productos/crear", productoController.crearProducto);
        get("/admin/productos/cargar", productoController.cargarProducto);
        //Carrito
        get("/cargarCarrito", carritoController.cargarCarrito);
        get("/verCarrito", carritoController.verCarrito);
        //Lado del administrador
        get("/admin", usuarioController.admin);
        get("/admin/sobremi", usuarioController.sobreMi);
        get("/admin/encargos", usuarioController.encargos);
    }
}