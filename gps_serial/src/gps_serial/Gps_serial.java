/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps_serial;

import bd.ConexionBD;
import java.io.*;
import java.sql.Timestamp;
import objetos.*;
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
        int i;
        ConexionBD c = new ConexionBD();
        for(i=0;i<100;i++){
            Process p = Runtime.getRuntime().exec(new String[] {"/bin/bash", "-c", "python /home/pi/gpspruebacon/readserial.py" });
            //Process p = Runtime.getRuntime().exec(new String[] {"/bin/bash", "-c", "readserial.py" });
            p.waitFor();
            //p.getInputStream();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String tramagps;
                System.out.println(i+". Obteniendo datos...");
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
                    //conversion de datos
                    System.out.println("Convirtiendo datos...");
                    float latitudf = Float.valueOf(latitud);
                    float longitudf = Float.valueOf(longitud);
                    float alturaf = Float.valueOf(altura);
                    //Timestamp tiempof = Timestamp.valueOf(tiempo);
                    try{
                        c.conectar();
                        System.out.println("Ingresando datos a BD...");
                        ubicacion u = new ubicacion(latitudf, longitudf, alturaf,1);
                        System.out.println("datos obtenidos: "+latitudf+","+longitudf+","+alturaf);
                        //ingresando ubicacion a la basede datos
                        if(c.ingresarUbicacion(u)){
                            System.out.println("Datos ingresados...");
                        }else{
                            System.out.println("Error, datos no ingresados...");
                        }
                        if (latitudf < -0.93f){
                            System.out.println("\nAlerta - El dispisitivo esta fuera de rango.\n");
                            evento ev = new evento("Rango","El dispisitivo esta fuera de rango.", latitudf, longitudf, alturaf, 1);
                            if(c.ingresarEvento(ev)){
                                System.out.println("evento ingresado");
                            }else{
                                System.out.println("Error al ingresar el evento");
                            }
                        }
                    }catch(Exception e){
                        System.out.println("Error: "+e);
                    }
                }
            }
        }
        System.out.println("Fin de transmision GPS...");
    }
    
    //funciones
    //datos para recoger desde modulo gps: latitud, longitud, altitud
    //METODO PARA GENERAR TIEMPO DE EJECUCION

    static String generertiempo(){
        Timestamp tiempo = new Timestamp(System.currentTimeMillis());
        return tiempo.toString();
    }
    
    //funciones para base de datos
}
