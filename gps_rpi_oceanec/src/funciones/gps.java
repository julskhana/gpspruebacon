/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.sql.Timestamp;
import java.util.Random;

/**
 *
 * @author Julian
 */
public class gps {
    
    //private 
    
    //google maps: lat, long
    // ubicacion manta, la poza:    -0.947042, -80.717579
    // ub2 punta:                   -0.929710, -80.719440
    //ub3, playa murcielago:        -0.939758, -80.732723
    
    //funciones de simulacion
    public static float generarlatitud(){
        Random r = new Random();
        float manta_lat = -0.92f;
        float lat = manta_lat + r.nextFloat() * (-0.94f - manta_lat);
        return lat;
    }
    
    public static float generarlongitud(){
        Random r = new Random();
        float manta_lon = -80.7f;
        float lat = manta_lon + r.nextFloat() * (-80.75f - manta_lon);
        return lat;
    }
    
    public static float generarelevacion(){
        //manta 6mts sobre nivel del mar
        Random r = new Random();
        float mar = -1;
        float lat = mar + r.nextFloat() * (1.0f - mar);
        return lat;
    }
    
    public static String generertiempo(){
        Timestamp tiempo = new Timestamp(System.currentTimeMillis());
        return tiempo.toString();
    }
    
}
