package com.aydsii.porky.DAOs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import com.aydsii.porky.model.Producto;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.Query;

@SuppressWarnings("null")
public class ProductoDAO {
    public HashMap<Integer, Producto> listarProductos(Firestore firestore)
            throws InterruptedException, ExecutionException {
        HashMap<Integer, Producto> productoHashMap = new HashMap<>();
        Integer contador = 0;
        ApiFuture<QuerySnapshot> future = firestore.collection("torta").get();
        List<QueryDocumentSnapshot> document = future.get().getDocuments();
        for (QueryDocumentSnapshot documentSnapshot : document) {
            Producto temp = documentSnapshot.toObject(Producto.class);
            temp.setId(documentSnapshot.getId());
            productoHashMap.put(contador, temp);
            contador++;
        }
        return productoHashMap;
    }

    public HashMap<Integer, Producto> ampliarProducto(Firestore firestore, String id)
            throws InterruptedException, ExecutionException {
        HashMap<Integer, Producto> productoHashMap = new HashMap<>();
        Integer contador = 0;
        Query future = firestore.collection("torta").whereEqualTo("id", id);
        ApiFuture<QuerySnapshot> apiFuture = future.get();
        List<QueryDocumentSnapshot> lDocumentSnapshots = apiFuture.get().getDocuments();
        for (QueryDocumentSnapshot documentSnapshot : lDocumentSnapshots) {
            Producto temp = documentSnapshot.toObject(Producto.class);
            temp.setId(documentSnapshot.getId());
            productoHashMap.put(contador, temp);
            contador++;
        }
        return productoHashMap;
    }

    public HashMap<Integer, Producto> buscarProductoNombre(Firestore firestore, String carritoList)
            throws InterruptedException, ExecutionException {
        HashMap<Integer, Producto> productoHashMap = new HashMap<>();
        Integer contador = 0;
        Query future = firestore.collection("torta").whereArrayContains("tags", carritoList);
        ApiFuture<QuerySnapshot> apiFuture = future.get();
        List<QueryDocumentSnapshot> lDocumentSnapshots = apiFuture.get().getDocuments();
        for (QueryDocumentSnapshot documentSnapshot : lDocumentSnapshots) {
            Producto temp = documentSnapshot.toObject(Producto.class);
            temp.setId(documentSnapshot.getId());
            productoHashMap.put(contador, temp);
            contador++;
        }
        return productoHashMap;
    }

    public static Vector<Producto> buscarProductoId(Firestore firestore, Vector<String> nombre)
            throws InterruptedException, ExecutionException {
        Vector<Producto> productoHashMap = new Vector<>();
        for (String name : nombre) {
            ApiFuture<QuerySnapshot> future = firestore.collection("torta").whereEqualTo("id", name).get();
            List<QueryDocumentSnapshot> lDocumentSnapshots = future.get().getDocuments();
            for (DocumentSnapshot documentSnapshot : lDocumentSnapshots) {
                productoHashMap.add(documentSnapshot.toObject(Producto.class));
            }
        }
        return productoHashMap;
    }

    public void insertarProducto(Firestore firestore, String nombre, String precio_vta, String cant_porciones,
            String descripcion_producto, String img_producto0, String img_producto1, String img_producto2,
            String img_producto3) throws InterruptedException, ExecutionException {
        System.out.println("en el producto DAO");
        try {
            List<String> tags = new ArrayList<>();
            HashMap<String, Object> nuevoProducto = new HashMap<>();
            nuevoProducto.put("nombre", nombre);
            nuevoProducto.put("precio_vta", precio_vta);
            nuevoProducto.put("cant_porciones", cant_porciones);
            nuevoProducto.put("descripcion_producto", descripcion_producto);
            if (img_producto0 != null) {
                nuevoProducto.put("img_producto0", img_producto0);
                System.out.println(nuevoProducto.get("img_producto0"));
            } else {
                nuevoProducto.put("img_producto0", "NULL");
            }
            if (img_producto1 != null) {
                nuevoProducto.put("img_producto1", img_producto1);
                System.out.println(nuevoProducto.get("img_producto1"));
            } else {
                nuevoProducto.put("img_producto1", "NULL");
            }
            if (img_producto2 != null) {
                nuevoProducto.put("img_producto2", img_producto2);
                System.out.println(nuevoProducto.get("img_producto2"));
            } else {
                nuevoProducto.put("img_producto2", "NULL");
            }
            if (img_producto3 != null) {
                nuevoProducto.put("img_producto3", img_producto3);
                System.out.println(nuevoProducto.get("img_producto3"));
            } else {
                nuevoProducto.put("img_producto3", "NULL");
            }

            String nombreMinusculas = nombre.toLowerCase();
            tags.add(nombreMinusculas);
            String[] palabras = nombreMinusculas.split(" ");
            for (String palabra : palabras) {
                palabra.toLowerCase();
                tags.add(palabra);
            }

            nuevoProducto.put("tags", tags);

            ApiFuture<DocumentReference> future = firestore.collection("torta").add(nuevoProducto);
            agregarId(firestore, future.get().getId(), nombre);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void agregarId(Firestore firestore, String id, String nombre)
            throws InterruptedException, ExecutionException {
        try {
            ApiFuture<WriteResult> future = firestore.collection("torta").document(id).update("id", id);
            future.get().getUpdateTime();
        } catch (FirestoreException firestoreException) {
            System.out.println(firestoreException);
        }
    }
}
