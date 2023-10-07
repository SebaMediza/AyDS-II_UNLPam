package com.aydsii.porky;

import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

public class ProductoDAO {
    public static List<Producto> buscarProducto(){
        String querryString = "SELECT * FROM PRODUCTO";
        List<Producto> querryResult = null;
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            querryResult = connection.createQuery(querryString).executeAndFetch(Producto.class);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return querryResult;
    }

    public static List<Producto> masInformacion(int ID_PRODUCTO){
        String querryString = "SELECT * FROM PRODUCTO WHERE ID_PRODUCTO = " + String.valueOf(ID_PRODUCTO);
        List<Producto> querryResult = null;
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            querryResult = connection.createQuery(querryString).executeAndFetch(Producto.class);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return querryResult;
    }

    public static List<Producto> masInformacion(String nombre){
        String querryString = "SELECT * FROM PRODUCTO WHERE UPPER(NOMBRE) LIKE '%" + nombre + "%'";
        List<Producto> querryResult = null;
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            querryResult = connection.createQuery(querryString).executeAndFetch(Producto.class);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return querryResult;
    }

    public static void insertarProducto(String nombre, int precio_vta, int cant_porciones, String descripcion_producto, String img_producto){
        if (img_producto.length() == 0){
            img_producto = "null";
        }
        String querryString = "INSERT INTO producto (NOMBRE, PRECIO_VTA, CANT_PORCIONES, DESCRIPCION_PRODUCTO, img_producto) VALUES(" + "'" + nombre + "'" + ", " + String.valueOf(precio_vta) + ", " + String.valueOf(cant_porciones) + ", " + "'" + descripcion_producto + "'" + ", " + img_producto + ")";
        System.out.println(querryString);
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            connection.createQuery(querryString).executeUpdate();
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
    }
}
