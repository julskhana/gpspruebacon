/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps_serial;

import java.io.*;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
//import java.util.*;

public class Gps_serial {

    //private static InputStream inStream;
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO code application logic here        
        
        Process p = Runtime.getRuntime().exec(new String[] {"/bin/bash", "-c", "python /home/pi/readserial.py" });
        p.waitFor();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String tramagps;
            if ((tramagps = br.readLine()) != null){
                System.out.println("Trama GPS obtenida:"+tramagps);
                System.out.println("DATOS OBTENIDOS");
                if (tramagps.contains("GPRMC")){
                    String[] datos = tramagps.split(",");
                    String horafecha = generertiempo();
                    String latitud = datos[3];
                    String longitud = datos[5];
                    String altura = datos[8];
                    System.out.println("Tiempo:\t"+horafecha);
                    System.out.println("Latitud:\t"+latitud);
                    System.out.println("Longitud:\t"+longitud);
                    System.out.println("Altura:\t\t"+altura);
                }
            }
        } 
    }
    
    //funciones
    //datos para recoger desde modulo gps: latitud, longitud, altitud
    static String generertiempo(){
        Timestamp tiempo = new Timestamp(System.currentTimeMillis());
        return tiempo.toString();
    }
}
