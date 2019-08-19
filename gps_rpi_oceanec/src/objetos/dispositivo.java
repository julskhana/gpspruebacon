/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.io.Serializable;

public class dispositivo implements Serializable{
    
    private int id;
    private String mac;
    private String nombre;
    private String descripcion;
    

    //constructor
    public dispositivo(int id, String mac, String nombre, String descripcion) {
        this.id = id;
        this.mac = mac;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //constructor vacio
    public dispositivo() {
    }
    
    //constructor para generar datos GPS
    public dispositivo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    //ingresar dispositivo

    public dispositivo(String mac, String nombre, String descripcion) {
        this.mac = mac;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    //seleccionar

    public dispositivo(int id, String mac) {
        this.id = id;
        this.mac = mac;
    }
    
    
    //funciones set
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
    
    //funciones get

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMac() {
        return mac;
    }
    
}
