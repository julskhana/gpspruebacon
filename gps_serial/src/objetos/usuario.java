/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

public class usuario {
    
    private int id;
    private String cuenta;  //dmerino
    private String clave;
    private String nombre;  //Daniel Merino
    private String rol;     //administrador,usuario

    public usuario(int id, String cuenta, String clave, String nombre, String rol) {
        this.id = id;
        this.cuenta = cuenta;
        this.clave = clave;
        this.nombre = nombre;
        this.rol = rol;
    }

    public usuario() {
    }

    public usuario(String cuenta, String clave, String nombre, String rol) {
        this.cuenta = cuenta;
        this.clave = clave;
        this.nombre = nombre;
        this.rol = rol;
    }
    
    //set

    public void setId(int id) {
        this.id = id;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    //get

    public int getId() {
        return id;
    }

    public String getCuenta() {
        return cuenta;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }
    
}
