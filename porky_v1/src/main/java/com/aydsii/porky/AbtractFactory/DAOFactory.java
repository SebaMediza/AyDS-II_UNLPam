package com.aydsii.porky.AbtractFactory;

import com.aydsii.porky.FirebaseDAO.FireBaseDAO;
import com.aydsii.porky.FirebaseDAO.PresupuestoDAO;
import com.aydsii.porky.FirebaseDAO.ProductoDAO;

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
