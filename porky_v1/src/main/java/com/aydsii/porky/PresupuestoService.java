package com.aydsii.porky;

import com.google.cloud.firestore.Firestore;
import java.util.concurrent.ExecutionException;

public class PresupuestoService {

    private final Firestore firestore; // Assuming you are using Google Cloud Firestore

    public PresupuestoService(Firestore firestore) {
        this.firestore = firestore;
    }

    public void savePresupuesto(Presupuesto presupuesto) throws ExecutionException, InterruptedException {
        // Validate the presupuesto or perform any other business logic

        // Save the presupuesto to the Firestore database
        firestore.collection("presupuestos").add(presupuesto);
    }
}
