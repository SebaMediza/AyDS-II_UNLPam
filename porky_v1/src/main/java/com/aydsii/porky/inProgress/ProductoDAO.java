package com.aydsii.porky.inProgress;

import java.util.List;

import com.aydsii.porky.Models.Producto;
import com.google.cloud.firestore.Firestore;

public class ProductoDAO extends GenericDAO<String, Producto>{
    public ProductoDAO(Object connection) {
        super(connection);
    }

    @Override
    public String create(Producto model) {
        String id = null;

        return id;
    }

    @Override
    public List<Producto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Producto getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public void update(String id, Producto model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
