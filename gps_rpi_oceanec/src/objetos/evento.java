/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author Julian
 */
public class evento {
    
    private int id;
    private String tipo;
    private String descripcion;
    private String tiempo;
    private int id_derivador;

    public evento(int id, String tipo, String descripcion, String tiempo, int id_derivador) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
        this.id_derivador = id_derivador;
    }

    public evento() {
    }

    public evento(String tipo, String descripcion, String tiempo, int id_derivador) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
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
    
    
}
