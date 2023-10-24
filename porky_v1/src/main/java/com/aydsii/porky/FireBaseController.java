package com.aydsii.porky;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SuppressWarnings("deprecation")
public class FireBaseController {
    private static Firestore dbFirestore;
    
    private FireBaseController() throws IOException{
        FileInputStream serviceAccount = new FileInputStream("porky_v1\\src\\main\\resources\\public\\porky-cakes-firebase-adminsdk-s8box-c20de526e1.json");
        FirebaseOptions firebaseOptions = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
        FirebaseApp.initializeApp(firebaseOptions);
        dbFirestore = FirestoreClient.getFirestore();
    }

    public static Firestore getFirestoreConnection(){
        if(dbFirestore == null){
            try {
                new FireBaseController();
                System.out.println("Conexión Establecida");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dbFirestore;
    }
}
