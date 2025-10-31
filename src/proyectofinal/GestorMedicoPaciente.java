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
 * @author nogue
 */
public class GestorMedicoPaciente {
    
    public void cargarMedico(Medico medico){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            if (conn != null)
                System.out.println("Conexión exitosa con la base de datos");
            else
                System.out.println("Problemas con la conexion a la base de datos!");
            
            PreparedStatement ps = null;
            ps = conn.prepareStatement("INSERT INTO Medico VALUES( ? , ? , ? , ? , ? , ? , ? )");
            
        
            ps.setString(2, medico.getNombre());
            ps.setString(3, medico.getFirma());
            ps.setInt(4, medico.getEdad());
            ps.setDouble(5, medico.getDinero());
            ps.setDouble(6, medico.getPrecioConsulta());
            ps.setString(7, medico.getEspecialidad());
            ps.execute();
            ps.close();
            conn.close();
        }
        catch (SQLException ex) {
       System.err.println("SQLException: " + ex.getMessage());
    }
     }
    
     public void listarMedicos(){
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

            String sql="SELECT * FROM Medico";

            conjuntoResultados = instruccion.executeQuery(sql);
            metaDatos = conjuntoResultados.getMetaData();
                                  
             int numeroDeColumnas = metaDatos.getColumnCount();

            System.out.println("tabla de Medico:\n");
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
        }
    }
     
      public void listarMedicos(String especialidad) throws Exception{
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            PreparedStatement instruccion = conn.prepareStatement("SELECT * FROM Medico WHERE LOWER(especialidad) LIKE LOWER (?)");
            ResultSet conjuntoResultados = null;
            ResultSetMetaData metaDatos = null;

            instruccion.setString(1, "%" + especialidad + "%");
            
            conjuntoResultados = instruccion.executeQuery();
            metaDatos = conjuntoResultados.getMetaData();
                
            String comparacion = conjuntoResultados.getString("especialidad");
            if (comparacion.equalsIgnoreCase(especialidad)){
                int numeroDeColumnas = metaDatos.getColumnCount();

                System.out.println("tabla de Medico:\n");
                for(int i=1;i<= numeroDeColumnas; i++)  
                System.out.printf("%-8s\t",metaDatos.getColumnName(i));
                System.out.println();
            
                while(conjuntoResultados.next()){   
                for(int i=1;i<=numeroDeColumnas;i++)
                System.out.printf("%-8s\t",conjuntoResultados.getObject(i));
                System.out.println();
            }
            } else {
                throw new Exception("Medico no encontrado");
            }
            conn.close();
            instruccion.close();
            conjuntoResultados.close();
        }
        catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
     
      public void cargarPaciente(Paciente paciente){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            if (conn != null)
                System.out.println("Conexión exitosa con la base de datos");
            else
                System.out.println("Problemas con la conexion a la base de datos!");
            
            PreparedStatement ps = null;
            ps = conn.prepareStatement("INSERT INTO paciente VALUES( ? , ? , ? , ? , ? )");
            
        
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getFirma());
            ps.setInt(4, paciente.getEdad());
            ps.setDouble(5, paciente.getDinero());
            ps.execute();
            ps.close();
            conn.close();
        }
        catch (SQLException ex) {
       System.err.println("SQLException: " + ex.getMessage());
        }
     }
      
      public void listarPacientes(){
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

            String sql="SELECT * FROM paciente";

            conjuntoResultados = instruccion.executeQuery(sql);
            metaDatos = conjuntoResultados.getMetaData();

             int numeroDeColumnas = metaDatos.getColumnCount();

            System.out.println("tabla de paciente:\n");
            for(int i=1;i<= numeroDeColumnas; i++)  
            System.out.printf("%-8s\t",metaDatos.getColumnName(i));
            System.out.println();
            
            while(conjuntoResultados.next()){   
            for(int i=1;i<=numeroDeColumnas;i++)
            System.out.printf("%-8s\t",conjuntoResultados.getObject(i));
            System.out.println();
            }
            conn.close();    
        }
        catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
      
      public Paciente buscarPaciente(int id){
           Connection conn = null;
           PreparedStatement ps = null;
           ResultSet rs = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            if (conn != null)
                System.out.println("Conexión exitosa con la base de datos");
            else
                System.out.println("Problemas con la conexion a la base de datos!");
            
            String sql = "SELECT id, nombre, firma, edad, dinero FROM paciente WHERE id = ?";
            ps =conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                String nombre = rs.getString("nombre");
                String firma = rs.getString("firma");
                int edad = rs.getInt("edad");
                int dinero = rs.getInt("dinero");
                Paciente paciente = new Paciente(nombre, firma, edad, dinero);
                return paciente;
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
      
      public Medico buscarMedico(int matricula){
           Connection conn = null;
           PreparedStatement ps = null;
           ResultSet rs = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            if (conn != null)
                System.out.println("Conexión exitosa con la base de datos");
            else
                System.out.println("Problemas con la conexion a la base de datos!");
            
            String sql = "SELECT matricula, nombre, firma, edad, dinero, precioConsulta , especialidad FROM Medico WHERE matricula = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, matricula);
            rs = ps.executeQuery();
            if(rs.next()){
                String nombre = rs.getString("nombre");
                String firma = rs.getString("firma");
                int edad = rs.getInt("edad");
                int dinero = rs.getInt("dinero");
                int precioConsulta = rs.getInt("precioConsulta");
                String especialidad = rs.getString("especialidad");
                
                Medico medico = new Medico(precioConsulta, especialidad, nombre, firma, edad, dinero, matricula);
                return medico;
            } else {
                throw new Exception("no existe esa matricula");
            }
             
      } catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage());
      } catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try { if (rs != null) rs.close(); } catch (SQLException e) { /* Ignorar */ }
        try { if (ps != null) ps.close(); } catch (SQLException e) { /* Ignorar */ }
        try { if (conn != null) conn.close(); } catch (SQLException e) { /* Ignorar */ }
        }
        return null;
      }
      
      public void cargarReceta(Receta receta){
           Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            if (conn != null)
                System.out.println("Conexión exitosa con la base de datos");
            else
                System.out.println("Problemas con la conexion a la base de datos!");
            
            PreparedStatement ps = null;
            ps = conn.prepareStatement("INSERT INTO receta VALUES( ? , ? , ? , ? , ? , ? , ? , ?)");
            
            ps.setString(1, receta.getNombreMedicamento());
            ps.setInt(2, receta.getCantidad());
            ps.setString(3, receta.getTipo());
            ps.setString(4, receta.getEspecialista());
            ps.setString(5, receta.getFirma());
            ps.setString(6, receta.getDescripcion());
            ps.setString(7, receta.getNombrePaciente());
            ps.execute();
            ps.close();
            conn.close();
            
      }catch (SQLException ex) {
       System.err.println("SQLException: " + ex.getMessage());
     }
    }
      
      public void actualizarDinero(int dinero, int id){
          Connection conn = null;
        PreparedStatement psUpdate = null;
        String sqlUpdate = "UPDATE paciente SET dinero =  ? WHERE id = ? ";
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            if(conn != null){
                System.out.println("Conexión exitosa con la base de datos");
            }else{
                System.out.println("Problemas con la conexión a la base de datos!");
            }
            
            psUpdate = conn.prepareStatement(sqlUpdate);
            psUpdate.setInt(1, dinero);
            psUpdate.setInt(2, id);
            psUpdate.execute();
            
            psUpdate.close();
            conn.close();
        }catch(SQLException ex){
             System.err.println("SQLException: " + ex.getMessage());
        }
      }
}


