package com.aydsii.porky.AbtractFactory;
import com.aydsii.porky.DAO.FireBaseDAO;
import com.aydsii.porky.DAO.PresupuestoDAO;
import com.aydsii.porky.DAO.ProductoDAO;

public interface DAOAbstractFactory {
    public ProductoDAO getProductoDAO();
    public PresupuestoDAO getPresupuestoDAO();
    public FireBaseDAO getFireBaseDAO();
}
