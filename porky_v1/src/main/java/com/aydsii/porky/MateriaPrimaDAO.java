package com.aydsii.porky;

import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

public class MateriaPrimaDAO {
    public static List<MateriaPrima> materiaPrimaOf(int ID_PRODUCTO){
        String querryString = "SELECT MP.ID_MATERIA_PRIMA, MP.NOMBRE_MP FROM INGREDIENTE I INNER JOIN MATERIA_PRIMA MP ON I.ID_MATERIA_PRIMA = MP.ID_MATERIA_PRIMA WHERE I.ID_PRODUCTO =  " + String.valueOf(ID_PRODUCTO);
        List<MateriaPrima> querryResult = null;
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            querryResult = connection.createQuery(querryString).executeAndFetch(MateriaPrima.class);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return querryResult;
    }
}
