/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps_serial;

import java.io.*;
//import java.util.*;
/*
import com.pi4j.io.serial.*;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.util.Console;
*/
import java.io.IOException;
//import java.util.Date;
//import jssc.SerialPortException;
//import jssc.SerialPort;
//import jssc.SerialPortException;

/**
 *
 * @author Julian
 */
public class Gps_serial {

    private static InputStream inStream;
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO code application logic here        
        
         Process p = Runtime.getRuntime().exec(new String[] {"/bin/bash", "-c", "python /home/pi/gpsapp/gpspruebacon/readserial.py" });    
        p.waitFor();                                                                                                             

        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {                                
          String line;                                                                                                         
          while ((line = br.readLine()) != null)  {                                                                               
              System.out.println("Valor obtenido: "+line);                                                                                      
          }
          String[] datos = line.split(",");
          String hora = datos[0];
          String dato2 = datos[1];
          System.out.println(hora);
          System.out.println(dato2);
      } 
    }
}
