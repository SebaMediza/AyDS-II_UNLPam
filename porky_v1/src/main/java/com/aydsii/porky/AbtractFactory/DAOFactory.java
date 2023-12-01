package com.aydsii.porky.AbtractFactory;

import com.aydsii.porky.DAOs.FireBaseDAO;
import com.aydsii.porky.DAOs.PresupuestoDAO;
import com.aydsii.porky.DAOs.ProductoDAO;

public class DAOFactory implements DAOAbstractFactory {

    @Override
    public ProductoDAO getProductoDAO() {
        return new ProductoDAO();
    }

    @Override
    public PresupuestoDAO getPresupuestoDAO() {
        return new PresupuestoDAO();
    }

    @Override
    public FireBaseDAO getFireBaseDAO() {
        return new FireBaseDAO();
    }
    
}
