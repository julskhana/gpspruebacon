/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps_rpi_oceanec;

import bd.ConexionBD;
import formularios.frmLogin;
import formularios.frmPrincipal;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.Random;
import objetos.ubicacion;

public class Gps_rpi_oceanec {
    
    //mac dir: e0:db:55:cd:33:79

    /**
     * @param args the command line arguments
     */
    //private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    
    //$GPRMC,142224.000,A,0208.1668,S,07955.2164,W,0.00,157.16,280719,,,D*6A
    
    private static final int IDDISP = 1;

    public static void main(String[] args) {
        System.out.println("Aplicacion GPS RPi");
        System.out.println("\nIniciando programa...");
        
        
        //frmLogin aut = new frmLogin();
        //aut.setVisible(true);
        
        frmPrincipal pr = new frmPrincipal();
        pr.setVisible(true);
        
        /*
        float latitud = funciones.gps.generarlatitud();
        float longitud = funciones.gps.generarlongitud();
        float elevacion = funciones.gps.generarelevacion();
        String tiempo = funciones.gps.generertiempo();
        
        ConexionBD c = new ConexionBD();
        try {
            System.out.println("Conectando...");
            c.conectar();
            System.out.println("Generando Ubicacion - Manta");
            System.out.println("Dispositivo actual: Raspberry01 - GPS");
            if (latitud < -0.93f){
                System.out.println("\nAlerta - El dispisitivo esta fuera de rango.\n");
            }
            System.out.println("LATITUD:\t"+latitud);
            System.out.println("LONGITUD:\t"+longitud);
            System.out.println("ELEVACION:\t"+elevacion);
            System.out.println("TIEMPO:\t\t"+tiempo);
            ubicacion u = new ubicacion(latitud, longitud, elevacion, tiempo, IDDISP);
            c.ingresarUbicacion(u);
        } catch (Exception e) {
            System.out.println("Error del programa.\n"+e);
        }
        c.desconectar();    
        */
    }
    
    /*
    Obtener datos desde string
    String data = "$GPGGA,1714.0,3723.465874,N,12202.26954,W,2,6,1.2,18.893,M,-25.669,M,2.0,0031*4F";
    String[] parts = data.split(",");
    String p2 = parts[2]; // 3723.465874
    String p3 = parts[3]; // N
    String p4 = parts[4]; // 12202.26954
    String p5 = parts[5]; // W
    
    */
}
