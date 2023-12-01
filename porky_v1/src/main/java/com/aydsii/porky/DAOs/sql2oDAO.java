package com.aydsii.porky.DAOs;

import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class sql2oDAO {
    protected static Sql2o sql2o;

    public static Sql2o getSql2oDAO() {
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

}
