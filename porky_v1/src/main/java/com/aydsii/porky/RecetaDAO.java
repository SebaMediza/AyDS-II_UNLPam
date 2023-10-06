package com.aydsii.porky;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

public class RecetaDAO {
    public static List<Receta> receta(int ID_PRODUCTO){
        String querryString = "SELECT * FROM PASOS_RECETA WHERE ID_PRODUCTO = " + String.valueOf(ID_PRODUCTO);
        List<Receta> querryResult = null;
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            querryResult = connection.createQuery(querryString).executeAndFetch(Receta.class);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return querryResult;
    }
}
