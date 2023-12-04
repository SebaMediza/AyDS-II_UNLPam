package com.aydsii.porky.AbtractFactory;

import com.aydsii.porky.DAO.FireBaseDAO;
import com.aydsii.porky.DAO.PresupuestoDAO;
import com.aydsii.porky.DAO.ProductoDAO;

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
