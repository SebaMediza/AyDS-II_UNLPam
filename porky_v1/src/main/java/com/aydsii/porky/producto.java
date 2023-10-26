package com.aydsii.porky;

import lombok.Data;
@Data
public class Producto {
    private String id;
    private String nombre;
    private String precio_vta;
    private String cant_porciones;
    private String descripcion_producto;
    private String img_producto0;
    private String img_producto1;
    private String img_producto2;
    private String img_producto3;
    private String[] tags;
}