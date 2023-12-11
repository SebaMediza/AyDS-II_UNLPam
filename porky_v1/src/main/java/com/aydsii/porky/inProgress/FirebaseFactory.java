package com.aydsii.porky.inProgress;

import com.aydsii.porky.SQLDAO.*;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

@SuppressWarnings("deprecation")
public class FirebaseFactory implements AbstractFactory{
    private static Firestore connection;

    public FirebaseFactory(){
        try {
            getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getConnection() throws IOException{
        if (connection == null){
            String currentDir = System.getProperty("user.dir");
            System.out.println("Current dir using System:" + currentDir);
            FileInputStream serviceAccount = new FileInputStream("src/main/resources/DB/porky-cakes-firebase-adminsdk-s8box-c20de526e1.json");
            FirebaseOptions firebaseOptions = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
            FirebaseApp.initializeApp(firebaseOptions);
            connection = FirestoreClient.getFirestore();
        }
        return connection;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <K extends Serializable, T> GenericDAO<K, T> getDAO(Class<T> Model) {
        switch (Model.getSimpleName()) {
            case "ProductoDAO":
                return (GenericDAO<K, T>) new ProductoDAO(connection);
            //TODO: Agregar todas las demás clases
            default:
                return null;
        }
    }
}
