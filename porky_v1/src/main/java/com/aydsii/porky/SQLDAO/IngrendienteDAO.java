package com.aydsii.porky.SQLDAO;

import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import com.aydsii.porky.Models.Ingrediente;

public class IngrendienteDAO {
    public static List<Ingrediente> ingredientesOf(int ID_PRODUCTO){
        String querryString = "SELECT * FROM INGREDIENTE WHERE ID_PRODUCTO =  " + String.valueOf(ID_PRODUCTO);
        List<Ingrediente> querryResult = null;
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            querryResult = connection.createQuery(querryString).executeAndFetch(Ingrediente.class);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return querryResult;
    }
}
