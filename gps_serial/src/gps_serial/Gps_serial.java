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
        
        /*
        Pruebas1 ip: 192.168.100.187
        */
        System.out.println("Programa GPS - Lector de trama GPRMC");
        System.out.println("Ejecutando Script en python...");
        Process p = Runtime.getRuntime().exec(new String[] {"/bin/bash", "-c", "python /home/pi/gpspruebacon/readserial.py" });
        p.waitFor();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String tramagps;
            System.out.println("Obeteniendo datos...");
            if ((tramagps = br.readLine()) != null){
                System.out.println("Trama GPS obtenida:"+tramagps);
                System.out.println("DATOS OBTENIDOS");
                String[] datos = tramagps.split(",");
                //String horafecha = generertiempo();
                String latitud = datos[0];
                String longitud = datos[1];
                String tiempo = datos[2];
                String altura = datos[3];
                System.out.println("Latitud:\t"+latitud);
                System.out.println("Longitud:\t"+longitud);
                System.out.println("Tiempo:\t\t"+tiempo);
                System.out.println("Altura:\t\t"+altura+" m");
                /*
                try{
                    ubicacion u = new ubicacion(Float.valueOf(latitud),Float.valueOf(longitud),Float.valueOf(altura),horafecha,1);
                    ConexionBD c = new ConexionBD();
                    c.conectar();
                    c.ingresarUbicacion(u);
                }catch(Exception e){
                    System.out.println("Error: "+e);
                }*/
            }
        } 
    }
    
    //funciones
    //datos para recoger desde modulo gps: latitud, longitud, altitud
    //METODO PARA GENERAR TIEMPO DE EJECUCION

    static String generertiempo(){
        Timestamp tiempo = new Timestamp(System.currentTimeMillis());
        return tiempo.toString();
    }
}
