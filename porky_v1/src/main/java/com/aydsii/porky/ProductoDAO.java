package com.aydsii.porky;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
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

public class ProductoDAO {
    private static HashMap<Integer, Producto> productoHashMap = new HashMap<>();
    public static HashMap<Integer, Producto> buscarProducto(Firestore firestore) throws InterruptedException, ExecutionException{
        Integer contador = 0;
        ApiFuture<QuerySnapshot> future = firestore.collection("torta").get();
        List<QueryDocumentSnapshot> document = future.get().getDocuments();
        for(QueryDocumentSnapshot documentSnapshot : document){
            System.out.println(documentSnapshot.getId() + "=>" + documentSnapshot.toObject(Producto.class));
            productoHashMap.put(contador,documentSnapshot.toObject(Producto.class));
            contador++;
        }
        for(Producto producto : productoHashMap.values()){
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Desc: " + producto.getDescripcion_producto());
            System.out.println("Cant_ porciones: " + producto.getCant_porciones());
            System.out.println("Precio: " + producto.getPrecio_vta());
            System.out.println("img0" + producto.getImg_producto0());
            System.out.println("img1" + producto.getImg_producto1());
            System.out.println("img2" + producto.getImg_producto2());
            System.out.println("img3" + producto.getImg_producto3());
        }
        return productoHashMap;
    }

    public static List<Producto> masInformacion(int ID_PRODUCTO){
        String querryString = "SELECT * FROM PRODUCTO WHERE ID_PRODUCTO = " + String.valueOf(ID_PRODUCTO);
        List<Producto> querryResult = null;
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            querryResult = connection.createQuery(querryString).executeAndFetch(Producto.class);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return querryResult;
    }

    public static List<Producto> masInformacion(String nombre){
        String querryString = "SELECT * FROM PRODUCTO WHERE UPPER(NOMBRE) LIKE '%" + nombre + "%'";
        List<Producto> querryResult = null;
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            querryResult = connection.createQuery(querryString).executeAndFetch(Producto.class);
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
        return querryResult;
    }

    public static void insertarProducto(String nombre, int precio_vta, int cant_porciones, String descripcion_producto, String img_producto){
        if (img_producto.length() == 0){
            img_producto = "null";
        }
        String querryString = "INSERT INTO producto (NOMBRE, PRECIO_VTA, CANT_PORCIONES, DESCRIPCION_PRODUCTO, img_producto) VALUES(" + "'" + nombre + "'" + ", " + String.valueOf(precio_vta) + ", " + String.valueOf(cant_porciones) + ", " + "'" + descripcion_producto + "'" + ", " + img_producto + ")";
        System.out.println(querryString);
        try (Connection connection = sql2oDAO.getSql2oDAO().open()){
            connection.createQuery(querryString).executeUpdate();
        } catch (Sql2oException sql2oException) {
            System.out.println(sql2oException);
        }
    }
}
