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
            //System.out.println(querryResult);
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
            //System.out.println(querryResult);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return querryResult;
    }
}
