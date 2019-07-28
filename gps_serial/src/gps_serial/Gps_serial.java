/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps_serial;

import java.io.*;
import java.util.*;
/*
import com.pi4j.io.serial.*;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.util.Console;
*/
import java.io.IOException;
import java.util.Date;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 *
 * @author Julian
 */
public class Gps_serial {

    private static InputStream inStream;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, SerialPortException {
        // TODO code application logic here        
        
        SerialPort serialPort = new SerialPort("/dev/ttyUSB0");
        serialPort.openPort();//Open serial port
        serialPort.setParams(4800, 8, 1, 0);//Set params.
        while(true) {
            byte[] buffer = serialPort.readBytes(10);
                if(buffer!=null) {
                for(byte b:buffer) {
                System.out.print(b);
        }
    } 
}
        
        /*
        System.out.println("Leer desde Serial");
        
        final Console console = new Console();
         console.title("<-- The Pi4J Project -->", "Serial Communication Example");
         console.promptForExit();
          final Serial serial = SerialFactory.createInstance();

        serial.addListener(new SerialDataEventListener() {
            @Override
            public void dataReceived(SerialDataEvent event) {

                // NOTE! - It is extremely important to read the data received from the
                // serial port.  If it does not get read from the receive buffer, the
                // buffer will continue to grow and consume memory.

                // print out the data received to the console
                try {
                    console.println("[HEX DATA]   " + event.getHexByteString());
                    console.println("[ASCII DATA] " + event.getAsciiString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        
        try {
            SerialConfig config = new SerialConfig();
            config.device(SerialPort.getDefaultPort())
                  .baud(Baud._38400)
                  .dataBits(DataBits._8)
                  .parity(Parity.NONE)
                  .stopBits(StopBits._1)
                  .flowControl(FlowControl.NONE);

            if(args.length > 0){
                config = CommandArgumentParser.getSerialConfig(config, args);
            }
             console.box(" Connecting to: " + config.toString(),
                    " We are sending ASCII data on the serial port every 1 second.",
                    " Data received on serial port will be displayed below.");

              serial.open(config);

              while(console.isRunning()) {
                try {
                    // write a formatted string to the serial transmit buffer
                    serial.write("CURRENT TIME: " + new Date().toString());

                    // write a individual bytes to the serial transmit buffer
                    serial.write((byte) 13);
                    serial.write((byte) 10);

                    // write a simple string to the serial transmit buffer
                    serial.write("Second Line");

                    // write a individual characters to the serial transmit buffer
                    serial.write('\r');
                    serial.write('\n');

                    // write a string terminating with CR+LF to the serial transmit buffer
                    serial.writeln("Third Line");
                }
                catch(IllegalStateException ex){
                    ex.printStackTrace();
                }
                // wait 1 second before continuing
                Thread.sleep(1000);
            }

        }
        catch(IOException ex) {
            console.println(" ==>> SERIAL SETUP FAILED : " + ex.getMessage());
            return;
        }*/
    }
}
