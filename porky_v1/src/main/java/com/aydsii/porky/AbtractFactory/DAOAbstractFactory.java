package com.aydsii.porky.AbtractFactory;
import com.aydsii.porky.FirebaseDAO.FireBaseDAO;
import com.aydsii.porky.FirebaseDAO.PresupuestoDAO;
import com.aydsii.porky.FirebaseDAO.ProductoDAO;

public interface DAOAbstractFactory {
    public ProductoDAO getProductoDAO();
    public PresupuestoDAO getPresupuestoDAO();
    public FireBaseDAO getFireBaseDAO();
}
