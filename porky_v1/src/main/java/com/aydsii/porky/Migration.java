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
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;

public class Migration {
    private static HashMap<String, Object> data = new HashMap<>();
    //private static List<Producto> productos;
    private static HashMap<Integer, Producto> productoHashMap = new HashMap<>();

    public static void getData(Firestore firestore) throws InterruptedException, ExecutionException {
        Integer contador = 0;
        ApiFuture<QuerySnapshot> future = firestore.collection("torta").get();
        List<QueryDocumentSnapshot> document = future.get().getDocuments();
        System.out.println(document.size());
        for(QueryDocumentSnapshot documentSnapshot : document){
            Producto temp = documentSnapshot.toObject(Producto.class);
            temp.setId(documentSnapshot.getId());
            productoHashMap.put(contador,temp);
            contador++;
        }
        for(Producto producto : productoHashMap.values()){
            System.out.println("Id: " + producto.getId());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Desc: " + producto.getDescripcion_producto());
            System.out.println("Cant_ porciones: " + producto.getCant_porciones());
            System.out.println("Precio: " + producto.getPrecio_vta());
            System.out.println("img0" + producto.getImg_producto0());
            System.out.println("img1" + producto.getImg_producto1());
            System.out.println("img2" + producto.getImg_producto2());
            System.out.println("img3" + producto.getImg_producto3());
        }
    }  

    public static void addData(Firestore firestore, String nombre, int precio_vta, int cant_porciones, String descripcion_producto) throws InterruptedException, ExecutionException{
        data.put("nombre", nombre);
        data.put("precio_vta", String.valueOf(precio_vta));
        data.put("cant_porciones", String.valueOf(cant_porciones));
        data.put("descripcion_producto", descripcion_producto);
        data.put("img_producto0", "NULL");
        data.put("img_producto1", "NULL");
        data.put("img_producto2", "NULL");
        data.put("img_producto3", "NULL");
        ApiFuture<DocumentReference> future = firestore.collection("torta").add(data);
        System.out.println(future.get().getId());
    }

    public static void queryData(Firestore firestore) throws InterruptedException, ExecutionException{
        List<Producto> producto = null;
        CollectionReference test = firestore.collection("torta");
        Query query = test.whereEqualTo("nombre", "Choco Torta");
        ApiFuture<QuerySnapshot> queryApiFuture = query.get();
        if(!queryApiFuture.get().isEmpty()){
            producto = queryApiFuture.get().toObjects(Producto.class);
            System.out.println("Cantidad de resultados: " + producto.size());
            System.out.println(producto.get(0).getNombre());
            System.out.println(producto.get(0).getCant_porciones());
            System.out.println(producto.get(0).getDescripcion_producto());
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, FirebaseAuthException {
        Firestore firestore = FireBaseController.getFirestoreConnection();
        //Migration.addData(firestore,"Selva Negra", 3100, 15, "Bizcochuelo de chocolate relleno con dos cortes de crema chantilly con cerezas al marraschino. Decorada con crema chantilly, copos, cerezas, rulos y detalles a los costados de chocolate.");
        Migration.getData(firestore);
        //Migration.queryData(firestore);
        //getData.userAccess(firestore);
    }
}
