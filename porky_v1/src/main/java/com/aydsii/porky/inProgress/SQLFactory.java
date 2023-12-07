package com.aydsii.porky.inProgress;

import java.io.IOException;
import java.io.Serializable;

import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import com.aydsii.porky.DAO.ProductoDAO;

public class SQLFactory implements AbstractFactory{
    private static Sql2o sql2o;

    @Override
    public Object getConnection() throws IOException {
        if(sql2o == null){
            try {
                sql2o = new Sql2o("jdbc:mysql://localhost:3306/porky_cakes", "root", "");
                System.out.println("Conexion Establecida");
            } catch (Sql2oException sql2o) {
                System.out.println(sql2o);
            }
        }
        return sql2o;
    }

    @Override
    public <K extends Serializable, T> GenericDAO<K, T> getDAO(Class<T> entityType) {
        switch (entityType.getSimpleName()) {
            case "ProductoDAO":
                return (GenericDAO<K, T>) new ProductoDAO();
            //TODO: Agregar todas las demás clases
            default:
                return null;
        }
    }
    
}
