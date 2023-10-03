package com.aydsii.porky;
import lombok.Data;

@Data
public class Ingrediente {
    private int id_producto;
    private int id_materia_prima;
    private int cantidad;
    private String unidad_medida;
}
