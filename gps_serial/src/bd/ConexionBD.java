package bd;

import objetos.*;
import java.sql.*;

public class ConexionBD {
    
       private Connection con;
       //driver netbeans
       private static final String DRIVER = "com.mysql.jdbc.Driver";
       private static final String DBMS = "mysql";
       //private static final String HOST = "192.168.100.177"; //direccion ip del servidor de base de datos
       private static final String HOST = "192.168.88.200";
       private static final String PORT = "3306";
       //base de datos
       private static final String DATABASE = "base_gps";  //cortejamiento: utf8_spanish_ci
       private static final String USER = "gps";
       private static final String PASSWORD = "";

    void Conexion(){}
    
    /*METODO CONECTAR*/
   
    public void conectar ()throws Exception{
        try{
            Class.forName(DRIVER);
        }catch(ClassNotFoundException ce){}
            try{
                this.con = DriverManager.getConnection("jdbc:" + DBMS + "://" + HOST + ":" + PORT + "/" + DATABASE, USER, PASSWORD);                
                System.out.println("Conexion exitosa con la base de datos - GPS");
            }catch(SQLException exception){
                System.out.println("Error – No se pudo conectar a la base de datos: "+exception);
            }             
    }
    
    public boolean desconectar(){
        try{
            this.con.close();
            return(true);
        }
        catch(SQLException e)
        {
            System.out.println("Error al Desconectar. "+e);
            return(false);
        }    
    }

    public boolean ingresarUbicacion(ubicacion ubi){
        try{
            PreparedStatement st = null;
            st = con.prepareStatement("INSERT INTO ubicacion (latitud,longitud,elevacion,tiempo,id_dispositivo) VALUES (?,?,?,?,1);");
            st.setFloat(1,ubi.getLatitud());
            st.setFloat(2,ubi.getLongitud());
            st.setFloat(3,ubi.getElevacion());
            st.setTimestamp(4,generertiempo());
            
            st.executeUpdate();
            st.close();
            System.out.println("Se ingreso la ubicacion a la base de datos...");
            return true;
        }catch (SQLException e){
            System.out.println("Error la ingresar la ubicacion a la base de datos... " +e);
            return false;
        }
    }
            
    public boolean ingresarEvento(evento ev) {
        try{
            PreparedStatement st=null;
            st = con.prepareStatement("INSERT INTO evento (tipo,descripcion,latitud,longitud,elevacion,id_derivador) VALUES(?,?,?,?,?,?);");
            st.setString(1,ev.getTipo());
            st.setString(2,ev.getDescripcion());
            st.setFloat(3,ev.getLatitud());
            st.setFloat(4,ev.getLongitud());
            st.setFloat(5,ev.getElevacion());
            st.setInt(6,ev.getId_derivador());
            st.executeUpdate();
            st.close();
            System.out.println("Se ingreso el evento exitosamente...");
            return true;
        }catch (SQLException ee){
            System.out.println("Error al ingresar el evento\n"+ee);
            return false;
        }
    }
    
    /*
    public boolean ingresarOperador(dispositivo ubi) {
        try{
            PreparedStatement st=null;
            st = con.prepareStatement("INSERT into operador (nombre,cedula,telefono,tipo) VALUES(?,?,?,?);");
            st.setString(1,ubi.getNombre());
            st.setString(2,ubi.getCedula());
            st.setString(3,ubi.getTelefono());
            st.setString(4,ubi.getTipo());
            
            st.executeUpdate();
            st.close();
            
            System.out.println("Se ingreso el operador exitosamente...");
            return true;
        }catch (SQLException ee){
            System.out.println("Error al ingresar el operador\n"+ee);
            return false;
        }
        
    }
    
    /*
    public boolean ingresarEmpresa(empresa e){
        try{
            PreparedStatement st=null;
            st = con.prepareStatement("INSERT into empresa (nombre,ruc,direccion,direccion_planta,telefono,correo,id_usuario) VALUES(?,?,?,?,?,?);");
            st.setString(1,e.getNombre());
            st.setString(2,e.getRuc());
            st.setString(3,e.getDireccion());
            st.setString(4,e.getDireccion_planta());
            st.setString(5,e.getTelefono());
            st.setString(6,e.getCorreo());
            st.setInt(7,e.getId_usuario());
            
            st.executeUpdate();
            st.close();
            
            System.out.println("Se ingreso la empresa exitosamente...");
            return true;
        }catch (SQLException ee){
            System.out.println("Error al ingresar la empresa\n"+ee);
            return false;
        }
    }
    
    public boolean ingresarNuevaClave(usuario u){
        try{
            PreparedStatement st=null;
            st = con.prepareStatement("INSERT INTO usuario (clave) VALUES(md5(?));");
            st.setString(1,u.getClave());
            st.executeUpdate();
            st.close();
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean ingresarUsuario(usuario u){
        try{
            PreparedStatement st=null;
            st = con.prepareStatement("INSERT INTO usuario (cuenta,clave,nombres,apellidos,cedula,edad,direccion,telefono,celular,correo,sexo,tipo,cargo,estado,fecha_inicio) VALUES(?,md5(?),?,?,?,?,?,?,?,?,?,?,?,?,?);");
            st.setString(1,u.getCuenta());
            st.setString(2,u.getClave());
            st.setString(3,u.getNombres());
            st.setString(4,u.getApellidos());
            st.setString(5,u.getCedula());
            st.setInt(6,u.getEdad());
            st.setString(7,u.getDireccion());
            st.setString(8,u.getTelefono());
            st.setString(9,u.getCelular());
            st.setString(10,u.getCorreo());
            st.setString(11,u.getSexo());
            st.setString(12,u.getTipo());
            st.setString(13,u.getCargo());
            st.setString(14,u.getEstado());
            st.setDate(15,u.getFecha_inicio()); //AAAA-MM-DD
            
            st.executeUpdate();
            st.close();
            
            System.out.println("Se ingreso el usuario exitosamente...");
            return true;
        }catch (SQLException e){
            System.out.println("Error al ingresar el usuario\n"+e);
            return false;
        }
    }
    
    public boolean esUsuarioValido(usuario u){        
        boolean resultado = false;
        ResultSet rs = null;
        PreparedStatement st = null;
        try{
            st = con.prepareStatement("SELECT * FROM usuario WHERE cuenta = ? AND clave = md5(?) AND estado = ?");
            //st = con.prepareStatement("SELECT * FROM usuario WHERE cuenta = ? AND clave = md5(?);");            
            st.setString(1,u.getCuenta());         
            st.setString(2,u.getClave());
            st.setString(3,"A");
            rs = st.executeQuery();            
            if(rs.next()){
                u.setTipo(rs.getString("estado"));
                resultado = true;
                System.out.println("usuario valido y activo...");
                System.out.println(u.getCuenta()+" - "+u.getTipo());
            }else{
                System.out.println("usuario despedido...");
            }
            rs.close();
            st.close();
        }
        catch(SQLException e){
            System.out.println("Error al consultar usuario. "+ e);
            resultado = false;
        }           
     return resultado; 
    }
    
    public boolean editarProducto(producto o) {
        try{
            PreparedStatement st = null;
            st = con.prepareStatement("UPDATE producto SET nombre=?, nombre_cientifico=?, proveedor=?, peso_ideal=? WHERE id_producto =?");                        
            st.setString(1, o.getNombre());
            st.setString(2, o.getNombre_cientifico());
            st.setString(3, o.getProveedor());
            st.setInt(4, o.getPeso_ideal());
            st.executeUpdate();
            st.close();                        
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public ArrayList<piscina> consultarPiscinas(String busqueda, String piscina) {
        ArrayList<piscina> registro = new ArrayList<piscina>();
        try{
            Statement st = this.con.createStatement();            
            ResultSet rs = null;
            
            if(piscina.equalsIgnoreCase("piscina")){
                rs = st.executeQuery("SELECT * FROM piscina;");
            }else{
                rs = st.executeQuery("SELECT * FROM piscina WHERE "+piscina+" LIKE '%"+busqueda+"%';");
            }
            
            while (rs.next()){
                int id_piscina   = rs.getInt("id_piscina");
                String ubicacion = rs.getString("ubicacion");
                
                piscina emp = new piscina(id_piscina,ubicacion);
                registro.add(emp);
            }
            System.out.println("piscinas consultadas...");
        }catch (SQLException e){
            System.out.println("error en consulta de piscnias"+e);
        }
        return registro;
    }
    */
    
    public static Timestamp generertiempo(){
        Timestamp tiempo = new Timestamp(System.currentTimeMillis());
        System.out.println("tiempo gen bd: "+tiempo);
        return tiempo;
    }
}
