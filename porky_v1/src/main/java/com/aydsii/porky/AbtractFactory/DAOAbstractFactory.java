package com.aydsii.porky.AbtractFactory;
import com.aydsii.porky.DAOs.FireBaseDAO;
import com.aydsii.porky.DAOs.PresupuestoDAO;
import com.aydsii.porky.DAOs.ProductoDAO;

public interface DAOAbstractFactory {
    public ProductoDAO getProductoDAO();
    public PresupuestoDAO getPresupuestoDAO();
    public FireBaseDAO getFireBaseDAO();
}
