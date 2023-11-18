package com.aydsii.porky;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import com.google.common.collect.HashBiMap;

public class Presupuesto {
    private static Presupuesto INSTANCE;
    //(idProducto, cantPorciones)
    public static HashMap<Integer,Integer> items = new HashMap<Integer,Integer>();
    //Comentarios adicionales sobre el pedido
    public static String sideNotes = "";
    //Fecha que se desea la entrega
    public static Date deliveryDate = Calendar.getInstance().getTime();
    
    private Presupuesto() {        
    }
    
    public static Presupuesto getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Presupuesto();
        }
        return INSTANCE;
    }

    public void clearItems() {
        items.clear();
    }

    public void addItem(Integer idProducto, Integer cantPorciones) {
        items.put(idProducto, cantPorciones);
    }

    public void updateItemQuantity(Integer idProducto, Integer newQuantity) {
        items.put(idProducto, newQuantity);
    }

    public void removeItem(Integer idProducto) {
        items.remove(idProducto);
    }

    public Vector<Integer> getIds(){
        Vector<Integer> ids = new Vector<Integer>();
        for (int key : items.keySet()) {
            ids.addElement(key);
        }
        return ids;
    }
    
    public int getItemQuantity(Integer idProducto) {
        return items.get(idProducto);
    }

    public void setSideNotes(String notes) {
        sideNotes = notes;
    }

    public String getSideNotes() {
        return sideNotes;
    }

    public void setDeliveryDate(Date date) {
        deliveryDate = date;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }
}
