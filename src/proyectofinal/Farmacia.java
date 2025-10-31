/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author estudiante
 */
public class Farmacia {
    private String nombre;
    private String direccion;

    public Farmacia(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
 
    public void cargarFarmaceutico(Farmaceutico farmaceutico){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            if (conn != null)
                System.out.println("Conexión exitosa con la base de datos");
            else
                System.out.println("Problemas con la conexion a la base de datos!");
            
            PreparedStatement ps = null;
            ps = conn.prepareStatement("INSERT INTO farmaceutico VALUES( ? , ? , ? , ? , ? )");
            
        
            ps.setString(2, farmaceutico.getNombre());
            ps.setString(3,farmaceutico.getFirma());
            ps.setInt(4,farmaceutico.getEdad());
            ps.setInt(5, farmaceutico.getDinero());
            ps.execute();
            ps.close();
            conn.close();
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } catch(Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
     }
    
    public void cargarMedicamento(Medicamento medicamento){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            if (conn != null)
                System.out.println("Conexión exitosa con la base de datos");
            else
                System.out.println("Problemas con la conexion a la base de datos!");
            
            PreparedStatement ps = null;
            ps = conn.prepareStatement("INSERT INTO medicamento VALUES( ? , ? , ? , ? )");
            
        
            ps.setString(1, medicamento.getNombre());
            ps.setInt(2, medicamento.getCantidad());
            ps.setString(3, medicamento.getTipo());
            ps.setInt(4, medicamento.getPrecio());
            ps.execute();
            ps.close();
            conn.close();
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } catch(Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    
    }
    
    public void listarMedicamentos(){
        Connection conn = null;
        try{
              conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
               if (conn != null)
                   System.out.println("Conexión exitosa con la base de datos");
               else
                   System.out.println("Problemas con la conexion a la base de datos!");
          
            Statement instruccion = conn.createStatement();
            ResultSet conjuntoResultados = null;
            ResultSetMetaData metaDatos = null;

            String sql="SELECT * FROM medicamento";

            conjuntoResultados = instruccion.executeQuery(sql);
            metaDatos = conjuntoResultados.getMetaData();

             int numeroDeColumnas = metaDatos.getColumnCount();

            System.out.println("tabla de medicamento:\n");
            for(int i=1;i<= numeroDeColumnas; i++)  
            System.out.printf("%-8s\t",metaDatos.getColumnName(i));
            System.out.println();
            
            while(conjuntoResultados.next()){   
            for(int i=1;i<=numeroDeColumnas;i++)
            System.out.printf("%-8s\t",conjuntoResultados.getObject(i));
            System.out.println();
            }
            conn.close();    
            instruccion.close();
            conjuntoResultados.close();
        }
        catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage());
        } catch(Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }
    
    public void actualizarStock(String nombre, int nuevoStock){
        Connection conn = null;
        PreparedStatement psUpdate = null;
        String sqlUpdate = "UPDATE medicamento SET cantidad = ? WHERE LOWER(nombre) LIKE LOWER (?)";
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            if(conn != null){
                System.out.println("Conexión exitosa con la base de datos");
            }else{
                System.out.println("Problemas con la conexión a la base de datos!");
            }
            
            psUpdate = conn.prepareStatement(sqlUpdate);
            psUpdate.setInt(1, nuevoStock);
            psUpdate.setString(2, nombre);
            psUpdate.execute();
            
            psUpdate.close();
            conn.close();
        }catch(SQLException ex){
             System.err.println("SQLException: " + ex.getMessage());
        }
    }
    
    public void listarFarmaceutico(){
        Connection conn = null;
        try{
              conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
               if (conn != null)
                   System.out.println("Conexión exitosa con la base de datos");
               else
                   System.out.println("Problemas con la conexion a la base de datos!");
          
            Statement instruccion = conn.createStatement();
            ResultSet conjuntoResultados = null;
            ResultSetMetaData metaDatos = null;

            String sql="SELECT * FROM farmaceutico";

            conjuntoResultados = instruccion.executeQuery(sql);
            metaDatos = conjuntoResultados.getMetaData();

             int numeroDeColumnas = metaDatos.getColumnCount();

            System.out.println("tabla de farmaceutico:\n");
            for(int i=1;i<= numeroDeColumnas; i++)  
            System.out.printf("%-8s\t",metaDatos.getColumnName(i));
            System.out.println();
            
            while(conjuntoResultados.next()){   
            for(int i=1;i<=numeroDeColumnas;i++)
            System.out.printf("%-8s\t",conjuntoResultados.getObject(i));
            System.out.println();
            }
            conn.close();    
            instruccion.close();
            conjuntoResultados.close();
        }
        catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage());
        } catch(Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }
    
    public void despedirFarmaceutico(int matricula){
    Connection conn = null;
        PreparedStatement ps = null;
        String sqlDelete = "DELETE FROM farmaceutico WHERE matricula = ?";
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            if(conn != null){
                System.out.println("Conexión exitosa con la base de datos");
            }else{
                System.out.println("Problemas con la conexión a la base de datos!");
            }
            ps = conn.prepareStatement(sqlDelete);
           ps.setInt(1, matricula);
           ps.executeUpdate();
           ps.close();
           conn.close();
        }catch(SQLException ex){
             System.err.println("SQLException: " + ex.getMessage());
        } catch(Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
}
    public void eliminarMedicamento(String nombre){
        Connection conn = null;
        PreparedStatement ps = null;
        String sqlDelete = "DELETE FROM medicamento WHERE nombre = ?";
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            if(conn != null){
                System.out.println("Conexión exitosa con la base de datos");
            }else{
                System.out.println("Problemas con la conexión a la base de datos!");
            }
            ps = conn.prepareStatement(sqlDelete);
           ps.setString(1, nombre);
           ps.executeUpdate();
           
           ps.close();
           conn.close();
        }catch(SQLException ex){
             System.err.println("SQLException: " + ex.getMessage());
        } catch(Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }
    
    public Medicamento buscarMedicamento(String nombre){
        Connection conn = null;
           PreparedStatement ps = null;
           ResultSet rs = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            if (conn != null)
                System.out.println("Conexión exitosa con la base de datos");
            else
                System.out.println("Problemas con la conexion a la base de datos!");
            
            String sql = "SELECT * FROM medicamento WHERE LOWER(nombre) LIKE LOWER (?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if(rs.next()){
                String nombreMed = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                int cantidad = rs.getInt("cantidad");
                int precio = rs.getInt("precio");
                
                Medicamento med = new Medicamento(nombreMed, cantidad, tipo, precio);
                return med;
            }
             conn.close();
      } catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage());
        }finally{
            try { if (rs != null) rs.close(); } catch (SQLException e) { /* Ignorar */ }
        try { if (ps != null) ps.close(); } catch (SQLException e) { /* Ignorar */ }
        try { if (conn != null) conn.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return null;
    }
    
    public Farmaceutico buscarFarmaceutico(int matricula){
       Connection conn = null;
           PreparedStatement ps = null;
           ResultSet rs = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            
            String sql = "SELECT * FROM farmaceutico WHERE matricula = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, matricula);
            rs = ps.executeQuery();
            if(rs.next()){
                String nombre = rs.getString("nombre");
                String firma = rs.getString("firma");
                int edad = rs.getInt("edad");
                int dinero = rs.getInt("dinero");
                
                Farmaceutico farma = new Farmaceutico(nombre, firma, edad, dinero, matricula);
                return farma;
            } else {
                throw new Exception("No existe esa matricula");
            }
      } catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try { if (rs != null) rs.close(); } catch (SQLException e) { /* Ignorar */ }
        try { if (ps != null) ps.close(); } catch (SQLException e) { /* Ignorar */ }
        try { if (conn != null) conn.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return null;
    }
    
    public void verificacionVacio(String texto)throws Exception{
        boolean verificacion;
        verificacion = texto != null && !texto.isEmpty();
        if(verificacion = false){
            throw new Exception("El campo no puede estar vacio");
        }
    }
    
    public int verificacionNumero(String entrada){
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                if (entrada.isEmpty()) {
                    throw new Exception("El valor no puede estar vacío");
                }

                numero = Integer.parseInt(entrada);

                if (numero < 0) {
                    throw new Exception("El número debe ser mayor que 0");
                }

                valido = true; 

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        return numero;
    }

    public int generarMatricula(){
    int matricula = -1;
    String sql = "SELECT matricula FROM farmaceutico ORDER BY RANDOM() LIMIT 1";
    Connection conn = null;
    try {
        conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            matricula = rs.getInt("matricula");
            stmt.close();
            rs.close();
            conn.close();
            return matricula;
        }
        stmt.close();
        rs.close();
        conn.close();
    }catch(SQLException ex){
        System.err.println("SQLException: " + ex.getMessage());
    }
        return -1;
    }

}

