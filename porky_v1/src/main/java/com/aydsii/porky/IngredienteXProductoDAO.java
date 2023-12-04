package com.aydsii.porky;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import com.aydsii.porky.DAO.*;

public class IngredienteXProductoDAO {
    public static List<IngredienteXProducto> getPasosReceta(int ID_PRODUCTO) {
        String queryString = "SELECT * FROM PASOS_RECETA WHERE ID_PRODUCTO = " + String.valueOf(ID_PRODUCTO);
        List<IngredienteXProducto> queryResult = null;

        try (Connection connection = sql2oDAO.getSql2oDAO().open()) {
            queryResult = connection.createQuery(queryString).executeAndFetch(IngredienteXProducto.class);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return queryResult;
    }
}
