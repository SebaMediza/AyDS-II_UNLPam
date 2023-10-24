package com.aydsii.porky;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;

public class getData {
    private static HashMap<String, Object> data = new HashMap<>();

    public getData(Firestore firestore) throws InterruptedException, ExecutionException {
        CollectionReference docRef = firestore.collection("test");
        ApiFuture<QuerySnapshot> future = docRef.get();
        QuerySnapshot documentSnapshot = future.get();
        System.out.println(documentSnapshot.getDocuments());
        /*if(((DocumentSnapshot) documentSnapshot).exists()){
            System.out.println(documentSnapshot.get("body"));
        }else{
            System.out.println("Error");
        }*/
    }  

    public static void addData(Firestore firestore) throws InterruptedException, ExecutionException{
        for (int i = 0; i < 100; i++) {
            data.put("body", String.valueOf(i));
            data.put("number", String.valueOf(i));
            ApiFuture<DocumentReference> future = firestore.collection("test").add(data);
            System.out.println(future.get().getId());
        }
    }

    public static void queryData(Firestore firestore) throws InterruptedException, ExecutionException{
        List<test> test2 = null;
        CollectionReference test = firestore.collection("test");
        Query query = test.whereEqualTo("body", "1");
        ApiFuture<QuerySnapshot> queryApiFuture = query.get();
        if(!queryApiFuture.get().isEmpty()){
            test2 = queryApiFuture.get().toObjects(test.class);
            System.out.println("Cantidad de resultados: " + test2.size());
            for(int i=0;i<test2.size();i++){
                System.out.println("Body: " + test2.get(i).getBody());
                System.out.println("Number: " + test2.get(i).getNumber());
            }
            //System.out.println(test2.get(0).getBody());
        }
    }

    public static void userAccess(Firestore firestore) throws FirebaseAuthException{
        UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail("seba@mediza.com");
       //v5DWbed3RMWEfwKZ9Pyv9tqJaRg1
    }
}
