package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numeros {

    
    public List<Integer> listnumeros(int a, int b, int c, int d, int e, int f, boolean idButton){
        
    
        List<Integer> lista = new ArrayList<Integer>(); 
        lista.add(a);
        lista.add(b);
        lista.add(c);
        lista.add(d);
        lista.add(e);
        lista.add(f);

        if(idButton){
            Collections.sort(lista);
        }else
            Collections.shuffle(lista);

        return lista;
    }
}
