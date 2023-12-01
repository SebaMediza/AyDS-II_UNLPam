package com.aydsii.porky.DAOs;

import com.aydsii.porky.model.Presupuesto;
import com.google.cloud.firestore.Firestore;
import java.util.concurrent.ExecutionException;

public class PresupuestoDAO {
    public void savePresupuesto(Firestore firestore, Presupuesto presupuesto) throws ExecutionException, InterruptedException {
        firestore.collection("presupuestos").add(presupuesto);
    }
}
