package com.aydsii.porky.Models;

import lombok.Data;

@Data
public class Ingrediente {
    private int id_materia_prima;
    private int id_producto;
    private int cantidad;
    private String unidad_medida;
}
