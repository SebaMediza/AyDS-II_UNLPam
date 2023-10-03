package com.aydsii.porky;

import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import lombok.Data;

@Data
public class Producto {
    private int id_producto;
    private String nombre;
    private int precio_vta;
    private int cant_porciones;
    private String descripcion_producto;
    private String img_producto;

    public static List<Producto> buscarProducto(){
        String querryString = "SELECT * FROM PRODUCTO";
        List<Producto> querryResult = null;
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            querryResult = connection.createQuery(querryString).executeAndFetch(Producto.class);
            //System.out.println(querryResult);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return querryResult;
    }

    public static List<Producto> masInformacion(int ID_PRODUCTO){
        String querryString = "SELECT * FROM PRODUCTOS WHERE ID_PRODUCTO = :ID_PRODUCTO";
        List<Producto> querryResult = null;
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            querryResult = connection.createQuery(querryString).addParameter("id_producto", ID_PRODUCTO).executeAndFetch(Producto.class);
            System.out.println(querryResult);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return querryResult;
    }
}