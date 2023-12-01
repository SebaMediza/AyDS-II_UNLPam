package com.aydsii.porky.DAOs;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SuppressWarnings("deprecation")
public class FireBaseDAO {
    private static Firestore dbFirestore;

    public Firestore connectToDB() throws IOException{
        if (dbFirestore == null){
            FileInputStream serviceAccount = new FileInputStream("porky_v1/src/main/resources/DB/porky-cakes-firebase-adminsdk-s8box-c20de526e1.json");
            FirebaseOptions firebaseOptions = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
            FirebaseApp.initializeApp(firebaseOptions);
            dbFirestore = FirestoreClient.getFirestore();
        }
        return dbFirestore;
    }
}
