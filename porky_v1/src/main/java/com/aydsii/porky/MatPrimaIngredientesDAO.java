package com.aydsii.porky;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

public class MatPrimaIngredientesDAO {
    public static List<MatPrimaIngredietes> ingredientesOf(int ID_PRODUCTO){
        String querryString = "SELECT mp.NOMBRE_MP, i.CANTIDAD, i.UNIDAD_MEDIDA FROM ingrediente i INNER JOIN materia_prima mp ON i.ID_MATERIA_PRIMA = mp.ID_MATERIA_PRIMA WHERE i.ID_PRODUCTO =  " + String.valueOf(ID_PRODUCTO);
        List<MatPrimaIngredietes> querryResult = null;
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            querryResult = connection.createQuery(querryString).executeAndFetch(MatPrimaIngredietes.class);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return querryResult;
    }
}
