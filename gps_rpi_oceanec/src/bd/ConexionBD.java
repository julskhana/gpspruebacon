package bd;

import objetos.*;
import java.sql.*;
import java.util.ArrayList;

public class ConexionBD {
    
       private Connection con;
       //driver netbeans
       private static final String DRIVER = "com.mysql.jdbc.Driver";
       //datos del servidor SQL
       private static final String DBMS = "mysql";
       private static final String HOST = "127.0.0.1"; 
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
                System.out.println("Conexión exitosa con la base de datos - GPS");
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

    //metodo para ingresar objetos de la clase ubicacion
    public boolean ingresarUbicacion(ubicacion ubi){
        try{
            PreparedStatement st = null;
            st = con.prepareStatement("INSERT INTO ubicacion (latitud,longitud,elevacion,id_dispositivo) VALUES (?,?,?,1);");
            st.setFloat(1,ubi.getLatitud());
            st.setFloat(2,ubi.getLongitud());
            st.setFloat(3,ubi.getElevacion());
            //st.setString(4,ubi.getTiempo());
            st.executeUpdate();
            st.close();
            System.out.println("Se ingreso la ubicacion a la base de datos...");
            return true;
        }catch (SQLException e){
            System.out.println("Error la ingresar la ubicacion a la base de datos... "+e);
            return false;
        }
    }
      
    //metodo para validad clave del usuario
    public boolean esUsuarioValido(usuario u){        
        boolean resultado = false;
        ResultSet rs = null;
        PreparedStatement st = null;
        try{
            st = con.prepareStatement("SELECT * FROM usuario WHERE cuenta = ? AND clave = md5(?);");
            st.setString(1,u.getCuenta());         
            st.setString(2,u.getClave());
            rs = st.executeQuery();            
            if(rs.next()){
                resultado = true;
            }else{
                System.out.println("Usuario no valido - Base de Datos");
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
    
    //metodo para obtener datos de usuario ingresado
    public usuario obtenerDatosUsuario(String cuenta){
        usuario u = new usuario();
        ResultSet rs = null;                       
        PreparedStatement st = null;
        try{
            st = con.prepareStatement("SELECT * FROM usuario WHERE cuenta = ?;");            
            st.setString(1,cuenta);         
            rs = st.executeQuery();            
            if(rs.next()){
                u.setId(rs.getInt("id"));
                u.setCuenta(cuenta);
                u.setNombre(rs.getString("nombre"));
                u.setCedula(rs.getString("cedula"));
                u.setTelefono(rs.getString("telefono"));
                u.setRol(rs.getString("rol"));
                System.out.println("Datos de usuario obtenidos...");
            }
            rs.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Error al consultar datos de usuario..." +e);
        }           
        return u; 
    }
    
    //metodo para obtener datos de dispositivos/derivadores
    public dispositivo obtenerDatosDerivador(int dispositivo){
        dispositivo disp = new dispositivo();
        ResultSet rs = null;                       
        PreparedStatement st = null;
        try{
            st = con.prepareStatement("SELECT * FROM dispositivo WHERE id = ?;");            
            st.setInt(1,dispositivo);         
            rs = st.executeQuery();            
            if(rs.next()){
                disp.setId(dispositivo);
                disp.setMac(rs.getString("mac"));
                disp.setMac(rs.getString("nombre"));
                disp.setMac(rs.getString("descripcion"));
                System.out.println("Datos de derivador obtenidos...");
            }
            rs.close();
            st.close();
        }catch(SQLException e){
            System.out.println(e);
        }           
        return disp; 
    }

    //metodo para generar lista de derivadores consultados
    public ArrayList<dispositivo> consultarDispositivos(String busqueda, String tipo){
        ArrayList<dispositivo> registro = new ArrayList<dispositivo>();
        try{
            Statement st = this.con.createStatement();            
            ResultSet rs = null;
            System.out.println(busqueda);
            System.out.println(tipo);
            if(tipo.equalsIgnoreCase("dispositivo")){
                rs = st.executeQuery("SELECT * FROM dispositivo;");
            }else{
                rs = st.executeQuery("SELECT * FROM dispositivo WHERE "+tipo+" LIKE '%"+busqueda+"%';");
            }
            
            while (rs.next()){
                int id = rs.getInt("id");
                String mac = rs.getString("mac");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                
                dispositivo deriv = new dispositivo(id, mac, nombre, descripcion);
                registro.add(deriv);
            }
            System.out.println("Dispositivos consultados...");
        }catch (SQLException e){
            System.out.println("Error en la consulta de dispositivos"+e);
        }
        return registro;
    } 
    
    //metodo para generar lista de ubicaciones desde tabla en base de datos
    public ArrayList<ubicacion> consultarUbicacion(String busqueda, String tipo){
        ArrayList<ubicacion> registro = new ArrayList<ubicacion>();
        try{
            Statement st = this.con.createStatement();            
            ResultSet rs = null;
            System.out.println(busqueda);
            System.out.println(tipo);
            if(tipo.equalsIgnoreCase("ubicacion")){
                rs = st.executeQuery("SELECT * FROM ubicacion;");
            }else{
                rs = st.executeQuery("SELECT * FROM ubicacion WHERE "+tipo+" LIKE '%"+busqueda+"%';");
            }
            
            while (rs.next()){
                int id = rs.getInt("id");
                float latitud = rs.getFloat("latitud");
                float longitud = rs.getFloat("longitud");
                float elevacion = rs.getFloat("elevacion");
                Timestamp tiempo = rs.getTimestamp("tiempo");
                int id_derivador = rs.getInt("id_dispositivo");
                //genera objeto de la clase ubicacion
                ubicacion ubi = new ubicacion(id, latitud, longitud, elevacion, tiempo, id_derivador);
                //guarda objetos en array list
                registro.add(ubi);
            }
            System.out.println("Ubicaciones consultados...");
        }catch (SQLException e){
            System.out.println("Error en la consulta de ubicaciones - sql : "+e);
        }
        return registro;
    }
    
    //metodo para generar lista de eventos
    public ArrayList<evento> consultarEventos(String busqueda, String tipo){
        ArrayList<evento> registro = new ArrayList<evento>();
        try{
            Statement st = this.con.createStatement();            
            ResultSet rs = null;
            System.out.println(busqueda);
            System.out.println(tipo);
            if(tipo.equalsIgnoreCase("evento")){
                rs = st.executeQuery("SELECT * FROM evento;");
            }else{
                rs = st.executeQuery("SELECT * FROM evento WHERE "+tipo+" LIKE '%"+busqueda+"%';");
            }
            
            while (rs.next()){
                int id = rs.getInt("id");
                String tipo_eve = rs.getString("tipo");
                String descripcion = rs.getString("descripcion");
                Timestamp tiempo = rs.getTimestamp("tiempo");
                int id_derivador = rs.getInt("id_derivador");
                float latitud = rs.getFloat("latitud");
                float longitud = rs.getFloat("longitud");
                float elevacion = rs.getFloat("elevacion");
                
                evento eve = new evento(id, tipo_eve, descripcion, String.valueOf(tiempo), id_derivador, latitud, longitud, elevacion);
                
                registro.add(eve);
            }
            System.out.println("Eventos consultados...");
        }catch (SQLException e){
            System.out.println("Error en la consulta de evenntos - sql : "+e);
        }
        return registro;
    }
    
    //metodo para ingresar derivadores a la base de datos
    public boolean ingresarDerivador(dispositivo der) {
        try{
            PreparedStatement st=null;
            st = con.prepareStatement("INSERT into dispositivo (mac,nombre,descripcion) VALUES(?,?,?);");
            st.setString(1,der.getMac());
            st.setString(2,der.getNombre());
            st.setString(3,der.getDescripcion());
            st.executeUpdate();
            st.close();
            System.out.println("Se ingreso el dispositivo exitosamente...");
            return true;
        }catch (SQLException ee){
            System.out.println("Error al ingresar el dispositivo\n"+ee);
            return false;
        }
    }
    
    //INSERT INTO evento (tipo,descripcion,tiempo,id_derivador) VALUES();
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
    
    //metodo par aingresar usuarios en base de datos
    public boolean ingresarUsuario(usuario u) {
        try{
            PreparedStatement st=null;
            st = con.prepareStatement("INSERT INTO usuario (cuenta,clave,nombre,cedula,telefono,rol) VALUES(?,md5(?),?,?,?,?)");
            st.setString(1,u.getCuenta());
            st.setString(2,u.getClave());
            st.setString(3,u.getNombre());
            st.setString(4,u.getCedula());
            st.setString(5,u.getTelefono());
            st.setString(6,u.getRol());
            st.executeUpdate();
            st.close();
            System.out.println("Se ingreso el usuario exitosamente...");
            return true;
        }catch (SQLException e){
            System.out.println("Error al ingresar el usuario:"+e);
            return false;
        }
    }
    
    //metodo para obtener ultima ubicacion de un derivador
    public ubicacion consultarUltimaUbiacion(){
        ubicacion ubi = new ubicacion();
        try{
            Statement st = this.con.createStatement();            
            ResultSet rs = null;
            
            rs = st.executeQuery("SELECT * FROM ubicacion ORDER BY id DESC LIMIT 1;");
            rs.next();
            
            ubi.setId(rs.getInt("id"));
            ubi.setLatitud(rs.getFloat("latitud"));
            ubi.setLongitud(rs.getFloat("longitud"));
            ubi.setElevacion(rs.getFloat("elevacion"));
            ubi.setTiempo(rs.getTimestamp("tiempo"));
            ubi.setId_dispositivo(rs.getInt("id_dispositivo"));
            
            rs.close();
            
            System.out.println("Ubicacion consultada...");
        }catch (SQLException e){
            System.out.println("Error en la consulta de ubicacion - sql : "+e);
        }
        return ubi;
    }
    
    public ArrayList<usuario> consultarUsuarios(String busqueda, String tipo){
        ArrayList<usuario> registro = new ArrayList<usuario>();
        try{
            Statement st = this.con.createStatement();            
            ResultSet rs = null;
            System.out.println(busqueda);
            System.out.println(tipo);
            if(tipo.equalsIgnoreCase("usuario")){
                rs = st.executeQuery("SELECT * FROM usuario;");
            }else{
                rs = st.executeQuery("SELECT * FROM usuario WHERE "+tipo+" LIKE '%"+busqueda+"%';");
            }
            while (rs.next()){
                int id = rs.getInt("id");
                String cuenta = rs.getString("cuenta");
                //String clave = rs.getString("clave");
                String nombre = rs.getString("nombre");
                String cedula = rs.getString("cedula");
                String telefono = rs.getString("telefono");
                String rol = rs.getString("rol");
                //genera objeto de la clase usuario
                usuario user = new usuario(id, cuenta, nombre, cedula, telefono, rol);
                //guarda objetos en array list
                registro.add(user);
            }
            System.out.println("Usuarios consultados...");
        }catch (SQLException e){
            System.out.println("Error en la consulta de usuarios - sql : "+e);
        }
        return registro;
    }
    
    public boolean eliminarDerivador(int id) {
        try{
            PreparedStatement st = null;
            st = con.prepareStatement("DELETE FROM dispositivo WHERE id = ?");                        
            st.setInt(1,id);         
            int n = st.executeUpdate();
            if(n==0){
                return false;
            }
            st.close();                        
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        } 
    }
    
    public boolean eliminarUsuario(int id) {
        try{
            PreparedStatement st = null;
            st = con.prepareStatement("DELETE FROM usuario WHERE id = ?");                        
            st.setInt(1,id);         
            int n = st.executeUpdate();
            if(n==0){
                return false;
            }
            st.close();                        
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
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
    
    public boolean esEmpresaValida(String emp){        
        boolean resultado = false;
        ResultSet rs = null;
        PreparedStatement st = null;
        try{
            st = con.prepareStatement("SELECT nombre FROM empresa WHERE nombre = ?;");                
            st.setString(1,emp);
            rs = st.executeQuery();            
            if(rs.next()){
                resultado = true;
                System.out.println("Empresa valida:"+emp);
            }else{
                System.out.println("Empresa invalida...");
            }
            rs.close();
            st.close();
        }
        catch(SQLException e){
            System.out.println("Error al consultar empresa. "+ e);
            resultado = false;
        }           
     return resultado; 
    }
    
    //consultas
    //funcion para obtener obejtos usuarios desde cuenta
        
    //consulta de seleccion de empresa despues de autenticacion
    public ArrayList<empresa> cargarEmpresas(int id_usuario){        
        ArrayList<empresa> registroE = new ArrayList<empresa>();
        try{
            Statement st = this.con.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery("SELECT * FROM empresa where id_usuario = "+id_usuario+";");
            while (rs.next()){
                int id = rs.getInt("id_empresa");
                String nombre = rs.getString("nombre");
                empresa emp = new empresa(id, nombre,id_usuario);
                registroE.add(emp);
            }
            System.out.println("empresas consultadas.");
        }catch (Exception e){
            System.out.println("error en consulta de empresas."+e);
        }
        return registroE;
    }

    //obtener datos empresa
    public empresa obtenerDatosEmpresa(String nombre){
        empresa emp = new empresa();
        ResultSet rs = null;                       
        PreparedStatement st = null;
        try{
            st = con.prepareStatement("SELECT * FROM empresa WHERE nombre = ?;");            
            st.setString(1,nombre);         
            rs = st.executeQuery();            
            if(rs.next()){
                emp.setId_empresa(rs.getInt("id_empresa"));
                emp.setNombre(nombre);
                emp.setRuc(rs.getString("ruc"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setDireccion_planta(rs.getString("direccion_planta"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setCorreo(rs.getString("correo"));
                System.out.println("Datos de empresa obtenidos...");
            }
            rs.close();
            st.close();
        }catch(SQLException e){
            System.out.println(e);
        }           
        return emp; 
    }
    
    public ArrayList<empresa> consultarEmpresas(String busqueda, String tipo){
        ArrayList<empresa> registro = new ArrayList<empresa>();
        try{
            Statement st = this.con.createStatement();            
            ResultSet rs = null;
            
            if(tipo.equalsIgnoreCase("empresa")){
                rs = st.executeQuery("SELECT * FROM empresa;");
            }else{
                rs = st.executeQuery("SELECT * FROM empresa WHERE "+tipo+" LIKE '%"+busqueda+"%';");
            }
            
            while (rs.next()){
                int id = rs.getInt("id_empresa");
                String nom = rs.getString("nombre");
                String ruc = rs.getString("ruc");
                String dir = rs.getString("direccion");
                String dir_p = rs.getString("direccion_planta");
                String tel = rs.getString("telefono");
                String cor = rs.getString("correo");
                int id_u = rs.getInt("id_usuario");
                
                empresa emp = new empresa(id, nom, ruc, dir, dir_p, tel, cor, id_u);
                registro.add(emp);
            }
            System.out.println("empresas consultadas...");
        }catch (SQLException e){
            System.out.println("error en consulta de empresas."+e);
        }
        return registro;
    } 
    
    public ArrayList<usuario> consultarUsuarios(String busqueda, String tipo){
	ArrayList<usuario> registroU = new ArrayList<usuario>();
	try{
		Statement st = this.con.createStatement();		
		ResultSet rs = null;
		
		if(tipo.equalsIgnoreCase("usuario")){
			rs = st.executeQuery("SELECT * FROM usuario;");
		}else{
			rs = st.executeQuery("SELECT * FROM usuario WHERE "+tipo+" LIKE '%"+busqueda+"%';");
		}
		
		while (rs.next()){
                    int id           = rs.getInt("id_usuario");
                    String cuenta = rs.getString("cuenta");
                    String nombres   = rs.getString("nombres");
                    String apellidos = rs.getString("apellidos");
                    String cedula = rs.getString("cedula");
                    int edad      = rs.getInt("edad");
                    String direccion = rs.getString("direccion");
                    String telefono = rs.getString("telefono");
                    String celular = rs.getString("celular");
                    String correo = rs.getString("correo");
                    String sexo      = rs.getString("sexo");
                    String tipoU      = rs.getString("tipo");
                    String cargo     = rs.getString("cargo");
                    String estado = rs.getString("estado");
                    Date fecha_inicio = rs.getDate("fecha_inicio");
                    
                    usuario usr = new usuario(id, cuenta, cargo, nombres, apellidos, cedula, edad, direccion, telefono, celular, correo, sexo, tipoU, cargo, fecha_inicio, estado);
                    registroU.add(usr);
		}
		System.out.println("usuarios consultados.");
	}catch (SQLException e){
		System.out.println("error en consulta de usuarios."+e);
	}
	return registroU;
}

    public ArrayList<operador> consultarOperadores(String busqueda, String lista) {
        ArrayList<operador> registro = new ArrayList<operador>();
        try{
            Statement st = this.con.createStatement();            
            ResultSet rs = null;
            
            if(lista.equalsIgnoreCase("operador")){
                rs = st.executeQuery("SELECT * FROM operador;");
            }else{
                rs = st.executeQuery("SELECT * FROM operador WHERE "+lista+" LIKE '%"+busqueda+"%';");
            }
            
            while (rs.next()){
                int id_operador  = rs.getInt("id_operador");
                String nombre    = rs.getString("nombre");
                String cedula    = rs.getString("cedula");
                String telefono  = rs.getString("telefono");
                String tipo      = rs.getString("tipo");
                
                operador emp = new operador(id_operador,nombre,cedula,telefono,tipo);
                registro.add(emp);
            }
            System.out.println("operadores consultados...");
        }catch (SQLException e){
            System.out.println("error en consulta de operadores"+e);
        }
        return registro;
    }

    public boolean eliminarOperador(int id) {
        try{
            PreparedStatement st = null;
            st = con.prepareStatement("DELETE FROM operador WHERE id_operador = ?");                        
            st.setInt(1,id);         
            int n = st.executeUpdate();
            if(n==0){
                return false;
            }
            st.close();                        
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        } 
    }

    public boolean editarOperador(operador o) {
        try{
            PreparedStatement st = null;
            st = con.prepareStatement("UPDATE operador SET nombre=?, cedula=?, telefono=?, tipo=? WHERE id_operador =?");                        
            st.setString(1, o.getNombre());
            st.setString(2, o.getCedula());
            st.setString(3, o.getTelefono());
            st.setString(4, o.getTipo());
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

    public boolean ingresarProducto(producto p) {
        try{
            PreparedStatement st=null;
            st = con.prepareStatement("INSERT INTO usuario (cuenta,clave,nombres,apellidos,cedula,edad,direccion,telefono,celular,correo,sexo,tipo,cargo,estado,fecha_inicio) VALUES(?,md5(?),?,?,?,?,?,?,?,?,?,?,?,?,?);");
            st.setString(1,p.getNombre());
            st.setString(2,p.getNombre_cientifico());
            st.setString(3,p.getProveedor());
            st.setInt(4,p.getPeso_ideal());
            
            st.executeUpdate();
            st.close();
            
            System.out.println("Se ingreso el producto exitosamente...");
            return true;
        }catch (SQLException e){
            System.out.println("Error al ingresar el producto\n"+e);
            return false;
        }
    }

    public boolean eliminarProducto(int id) {
        try{
            PreparedStatement st = null;
            st = con.prepareStatement("DELETE FROM producto WHERE id_producto = ?");                        
            st.setInt(1,id);         
            int n = st.executeUpdate();
            if(n==0){
                return false;
            }
            st.close();                        
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        } 
    }

    public ArrayList<producto> consultarProductos(String busqueda, String producto) {
        ArrayList<producto> registro = new ArrayList<producto>();
        try{
            Statement st = this.con.createStatement();            
            ResultSet rs = null;
            
            if(producto.equalsIgnoreCase("producto")){
                rs = st.executeQuery("SELECT * FROM producto;");
            }else{
                rs = st.executeQuery("SELECT * FROM producto WHERE "+producto+" LIKE '%"+busqueda+"%';");
            }
            
            while (rs.next()){
                int id_producto             = rs.getInt("id_producto");
                String nombre               = rs.getString("nombre");
                String nombre_cientifico    = rs.getString("nombre_cientifico");
                String proveedor            = rs.getString("proveedor");
                int peso_ideal              = rs.getInt("peso_ideal");
                
                producto emp = new producto(id_producto,nombre,nombre_cientifico,proveedor,peso_ideal);
                registro.add(emp);
            }
            System.out.println("productos consultados...");
        }catch (SQLException e){
            System.out.println("error en consulta de productos"+e);
        }
        return registro;
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
}
