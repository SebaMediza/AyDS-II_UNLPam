package com.aydsii.porky;

import lombok.Data;
@Data
public class Producto {
    private int id_producto;
    private String nombre;
    private int precio_vta;
    private int cant_porciones;
    private String descripcion_producto;
    private String img_producto;
    private String img_aux1;
    private String img_aux2;
    private String img_aux3;
}