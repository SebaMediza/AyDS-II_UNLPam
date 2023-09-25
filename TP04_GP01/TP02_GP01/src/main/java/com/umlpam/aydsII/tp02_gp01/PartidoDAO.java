package com.umlpam.aydsII.tp02_gp01;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class PartidoDAO {
      private List<Ejercicios> partidos;
    
    /**
     * 
     */
    public void init(){
        partidos = new ArrayList<Ejercicios>();
        Ejercicios par1 = new Ejercicios();
        Ejercicios par2 = new Ejercicios();
        Ejercicios par3 = new Ejercicios();
        Ejercicios par4 = new Ejercicios();
        Ejercicios par5 = new Ejercicios(); 

        par1.Partido("boca", "river", "Boca 2 - River 0", "Semifinal Libertadores", true);
        partidos.add(par1);
        
        par2.Partido("boca", "racing", "Boca 3 - River 1", "Cuarta Fecha Copa Liga", true);
        partidos.add(par2);
        
        par3.Partido("independiente", "river", "independiente 1 - River 1", "Primera fecha Copa Liga", true);
        partidos.add(par3);
        
        par4.Partido("independiente", "racing", "Independiente 4 - Racing 2", "Semifinal Libertadores", true);
        partidos.add(par4);
        
        par5.Partido("boca", "independiente", "Boca 2 - Independiente 0", "Primera ronda Libertadores", true);
        partidos.add(par5);       
    }

    public List<Ejercicios> getPartidos(String equipo){
        init();
        List<Ejercicios> partidosEquipos = new ArrayList<>();
        
        partidos.forEach(partido ->{
            if(equipo.equals(partido.getEquipo1()) || equipo.equals(partido.getEquipo2())){
               partidosEquipos.add(partido);
           }
        });
        
        
        return partidosEquipos;
    }
}