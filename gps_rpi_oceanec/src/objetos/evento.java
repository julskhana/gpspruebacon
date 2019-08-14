/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.io.Serializable;

/**
 *
 * @author Julian
 */
public class evento implements Serializable{
    
    private int id;
    private String tipo;
    private String descripcion;
    private String tiempo;
    private int id_derivador;
    private float latitud;
    private float longitud;
    private float elevacion;

    public evento(int id, String tipo, String descripcion, String tiempo, int id_derivador, float latitud, float longitud, float elevacion) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
        this.id_derivador = id_derivador;
        this.latitud = latitud;
        this.longitud = longitud;
        this.elevacion = elevacion;
    }

    public evento() {
    }

    //ingresar

    public evento(String tipo, String descripcion,float latitud, float longitud, float elevacion, int id_derivador) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.elevacion = elevacion;
        this.id_derivador = id_derivador;
    }
    
    
    //set

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public void setId_derivador(int id_derivador) {
        this.id_derivador = id_derivador;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public void setElevacion(float elevacion) {
        this.elevacion = elevacion;
    }
    

    //get
    
    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTiempo() {
        return tiempo;
    }

    public int getId_derivador() {
        return id_derivador;
    }

    public float getLatitud() {
        return latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public float getElevacion() {
        return elevacion;
    }
    
    
}
