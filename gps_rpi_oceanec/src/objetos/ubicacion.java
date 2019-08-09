/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.sql.Date;

public class ubicacion {
    
    private int id;
    private float latitud;
    private float longitud;
    private float elevacion;
    private String tiempo;
    private int id_dispositivo;

    //normal
    public ubicacion(int id, float latitud, float longitud, float elevacion, String tiempo, int id_dispositivo) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
        this.elevacion = elevacion;
        this.tiempo = tiempo;
        this.id_dispositivo = id_dispositivo;
    }

    //vacio
    public ubicacion() {
    }
    
    //ingreso
    public ubicacion(float latitud, float longitud, float elevacion, String tiempo, int id_dispositivo) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.elevacion = elevacion;
        this.tiempo = tiempo;
        this.id_dispositivo = id_dispositivo;
    }
    
    //ingreso con tiempo en base

    public ubicacion(float latitud, float longitud, float elevacion, int id_dispositivo) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.elevacion = elevacion;
        this.id_dispositivo = id_dispositivo;
    }

    //set
    public void setId(int id) {
        this.id = id;
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

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public void setId_dispositivo(int id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }
    
    //get

    public int getId() {
        return id;
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

    public String getTiempo() {
        return tiempo;
    }

    public int getId_dispositivo() {
        return id_dispositivo;
    }
    
}
