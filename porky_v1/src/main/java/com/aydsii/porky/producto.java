package com.aydsii.porky;

import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import lombok.Data;

@Data
public class producto {
    private int id_producto;
    private String nombre;
    private int precio_vta;
    private int cant_porciones;
    private String descripcion_producto;
    private byte[] imagen;

    public static List<producto> buscarProducto(){
        String querryString = "SELECT ID_PRODUCTO, NOMBRE, PRECIO_VTA, CANT_PORCIONES, DESCRIPCION_PRODUCTO FROM PRODUCTO WHERE ID_PRODUCTO = 1";
        List<producto> querryResult = null;
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            querryResult = connection.createQuery(querryString).executeAndFetch(producto.class);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return querryResult;
    }
}