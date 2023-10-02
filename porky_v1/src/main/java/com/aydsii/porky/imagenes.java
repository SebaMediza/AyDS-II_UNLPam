package com.aydsii.porky;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import com.mysql.jdbc.Blob;
import lombok.Data;

@Data
public class imagenes {
    private int id_imagen;
    private Blob scr;
    private String alt;

    public static List<imagenes> getImagenes(){
        String querryString = "SELECT SCR FROM IMAGENES WHERE ID_IMAGEN = 1";
        List<imagenes> querryResult = null;
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            querryResult = connection.createQuery(querryString).executeAndFetch(imagenes.class);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        System.out.println(querryResult);
        return querryResult;
    }
}
