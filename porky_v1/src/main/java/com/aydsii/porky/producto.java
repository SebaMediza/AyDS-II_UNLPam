package com.aydsii.porky;

import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import com.mysql.jdbc.Blob;

import lombok.Data;

@Data
public class producto {
    private int id_producto;
    private String nombre;
    private int precio_vta;
    private int cant_porciones;
    private String descripcion_producto;
    private Blob img_producto;

    public static List<producto> buscarProducto(){
        String querryString = "SELECT ID_PRODUCTO, NOMBRE, PRECIO_VTA, CANT_PORCIONES, DESCRIPCION_PRODUCTO FROM PRODUCTO WHERE ID_PRODUCTO = 1";
        //String querryString = "SELECT * FROM PRODUCTO WHERE ID_PRODUCTO = 1";
        List<producto> querryResult = null;
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            querryResult = connection.createQuery(querryString).executeAndFetch(producto.class);
            //System.out.println(querryResult);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return querryResult;
    }

    public static List<producto> masInformacion(String idProductoParam){
        String querryString = "SELECT ID_PRODUCTO, NOMBRE, PRECIO_VTA, CANT_PORCIONES, DESCRIPCION_PRODUCTO FROM PRODUCTO WHERE ID_PRODUCTO = :idProductoParam";
        //String querryString = "SELECT * FROM PRODUCTO WHERE ID_PRODUCTO = 1";
        List<producto> querryResult = null;
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            querryResult = connection.createQuery(querryString).addParameter("id_producto", idProductoParam).executeAndFetch(producto.class);
            System.out.println(querryResult);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return querryResult;
    }
}