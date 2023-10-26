package com.aydsii.porky;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;

public class ProductoDAO {
    public static HashMap<Integer, Producto> listarProductos(Firestore firestore) throws InterruptedException, ExecutionException{
        HashMap<Integer, Producto> productoHashMap = new HashMap<>();
        Integer contador = 0;
        ApiFuture<QuerySnapshot> future = firestore.collection("torta").get();
        List<QueryDocumentSnapshot> document = future.get().getDocuments();
        for(QueryDocumentSnapshot documentSnapshot : document){
            Producto temp = documentSnapshot.toObject(Producto.class);
            temp.setId(documentSnapshot.getId());
            productoHashMap.put(contador,temp);
            contador++;
        }
        return productoHashMap;
    }

    public static HashMap<Integer, Producto> ampliarProducto(Firestore firestore, String id) throws InterruptedException, ExecutionException{
        System.out.println(id);
        HashMap<Integer, Producto> productoHashMap = new HashMap<>();
        Integer contador = 0;
        Query future = firestore.collection("torta").whereEqualTo("id", id);
        ApiFuture<QuerySnapshot> apiFuture = future.get();
        List<QueryDocumentSnapshot> lDocumentSnapshots = apiFuture.get().getDocuments();
        System.out.println(lDocumentSnapshots.size());
        for(QueryDocumentSnapshot documentSnapshot : lDocumentSnapshots){
            Producto temp = documentSnapshot.toObject(Producto.class);
            temp.setId(documentSnapshot.getId());
            productoHashMap.put(contador,temp);
            contador++;
        }
        return productoHashMap;
    }

    public static HashMap<Integer, Producto> buscarProductoNombre(Firestore firestore, String nombre) throws InterruptedException, ExecutionException{
        HashMap<Integer, Producto> productoHashMap = new HashMap<>();
        Integer contador = 0;
        System.out.println("Desde el DAO: " + nombre);
        Query future = firestore.collection("torta").whereArrayContains("tags", nombre);
        ApiFuture<QuerySnapshot> apiFuture = future.get();
        List<QueryDocumentSnapshot> lDocumentSnapshots = apiFuture.get().getDocuments();
        for(QueryDocumentSnapshot documentSnapshot : lDocumentSnapshots){
            Producto temp = documentSnapshot.toObject(Producto.class);
            temp.setId(documentSnapshot.getId());
            System.out.println(temp.getNombre());
            productoHashMap.put(contador,temp);
            contador++;
        }
        return productoHashMap;
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
