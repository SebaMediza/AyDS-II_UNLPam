package com.aydsii.porky;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;

@Data
public class Presupuesto {
    private HashMap<Integer, Integer> items; // HashMap<idProducto, cantPorciones>
    private String sideNotes;
    private Date deliveryDate;
}
