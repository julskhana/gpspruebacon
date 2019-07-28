/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps_serial;

import java.io.*;
import java.util.*;
import gnu.io.*;
import javax.naming.Context;
import org.usb4java.Device;
import org.usb4java.DeviceDescriptor;
import org.usb4java.DeviceList;
import org.usb4java.LibUsb;
import org.usb4java.LibUsbException;
/**
 *
 * @author Julian
 */
public class Gps_serial {

    private static InputStream inStream;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try {
            CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier("/dev/ttyS80");
            SerialPort serialPort = (SerialPort) portId.open("GPS application", 5000);
            // Change baud rate if not 115200
            serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, 
                 SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            inStream = serialPort.getInputStream();
            String reading ="";
            while(true) {
                if(inStream.available() > 0) {
                    int b = inStream.read();
                    System.out.print((char)b);
                }
            }
        } catch (Exception ex) {
                ex.printStackTrace();
        }
    }    
}
