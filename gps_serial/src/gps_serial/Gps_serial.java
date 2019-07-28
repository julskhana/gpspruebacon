/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps_serial;

import java.io.*;
import java.sql.Timestamp;
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
            String line;
            if ((line = br.readLine()) != null){
                System.out.println("Valor obtenido: "+line);
                /*
                if (line.contains("GPRMC")){
                    String[] datos = line.split(",");
                    String hora = datos[1];
                    String dia = datos[2];
                    String mes = datos[3];
                    String anio = datos[4];
                    System.out.println("tiempo:"+hora);
                    System.out.println("fecha:"+dia+"/"+mes+"/"+anio);
                }*/
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
