/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author estudiante
 */
public class Paciente extends Persona{
    private ArrayList<Receta> recetas;

    public Paciente(String nombre, String firma, int edad, int dinero) {
        super( nombre, firma, edad, dinero);
        this.recetas = new ArrayList<>();
    }

    public ArrayList<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(ArrayList<Receta> recetas) {
        this.recetas = recetas;
    }
  
    public void Pagar(int n, int id, int matricula){
        dinero = dinero - n;
        Connection conn = null;
        ResultSet rs = null;
        int dinero2 = 0;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            if (conn != null){
                System.out.println("Conexión exitosa con la base de datos");
            }else{
                System.out.println("Problemas con la conexion a la base de datos!");
            }
            PreparedStatement ps = null;
            ps = conn.prepareStatement("UPDATE paciente SET dinero = ? WHERE id = ?");
            
            ps.setInt(1, dinero);
            ps.setInt(2, id); 
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Pagó por la consulta medica");
            } else {
                throw new Exception("No se encontró ningún paciente con ese ID");
            }
            
            ps = conn.prepareStatement("SELECT dinero FROM Medico WHERE matricula = ?");
            ps.setInt(1, matricula);
            rs = ps.executeQuery();
            if(rs.next()){
                dinero2 = rs.getInt("dinero");
                dinero2 = dinero2 + n;
            
            ps = conn.prepareStatement("UPDATE Medico SET dinero = ? WHERE matricula = ?");
            
            ps.setInt(1, dinero2);
            ps.setInt(2, matricula); 
            filasAfectadas = ps.executeUpdate();
            }
            
            
            ps.close();
            conn.close();
            rs.close();
        }catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } catch(Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
        
    }
    
    public void Pagar(String medicamento, int n, int id, int matricula){
        Connection conn = null;
        ResultSet rs = null;
        int dinero2;
        dinero = dinero - n;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            if (conn != null)
                System.out.println("Conexión exitosa con la base de datos");
            else
                System.out.println("Problemas con la conexion a la base de datos!");
            
            PreparedStatement ps = null;
            ps = conn.prepareStatement("UPDATE paciente SET dinero = ? WHERE id = ?");
           
            ps.setInt(1, dinero);
            ps.setInt(2, id); 
            int filasAfectadas = ps.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Pagó por " + medicamento);
        } else {
            throw new Exception("No se encontró ningún paciente con ese ID");
        }
        
           ps = conn.prepareStatement("SELECT dinero FROM farmaceutico WHERE matricula = ?");
            ps.setInt(1, matricula);
            rs = ps.executeQuery();
            if(rs.next()){
                dinero2 = rs.getInt("dinero");
                dinero2 = dinero2 + n;
                ps = conn.prepareStatement("UPDATE farmaceutico SET dinero = ? WHERE matricula = ?");
            
                ps.setInt(1, dinero2);
                ps.setInt(2, matricula); 
                filasAfectadas = ps.executeUpdate();
            }
            
            ps.close();
            conn.close();
            rs.close();
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } catch(Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }
    
    public void HistorialMedico(String nombre, int dia, int mes, int anio, String especialidad){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
            if (conn != null)
                System.out.println("Conexión exitosa con la base de datos");
            else
                System.out.println("Problemas con la conexion a la base de datos!");
            
            PreparedStatement ps = null;
            ps = conn.prepareStatement("INSERT INTO historialMedico VALUES( ? , ? , ? , ? , ? )");
            
            ps.setString(1, nombre);
            ps.setInt(2, dia);
            ps.setInt(3, mes);
            ps.setInt(4, anio);
            ps.setString(5, especialidad);
            
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
    
    public void agregarReceta(Receta r){
        recetas.add(r);
         System.out.println("Nombre Medicamento: " + r.getNombreMedicamento() + "| Firma especialista: " + r.getFirma());
        
    }

    public void mostrarRecetas(){
        int posicion = 0;
        Iterator<Receta> it = recetas.iterator();
        while (it.hasNext()){
            Receta r = it.next();
            posicion = posicion + 1;
            System.out.println("\n Receta: " + posicion + " | Medicamento: " + r.getNombreMedicamento()+ " | Descripcion: " + r.getDescripcion() + " | Medico: " + r.getEspecialista() + " | Paciente: " + r.getNombrePaciente());
        }
    }
    
    public Receta buscarReceta(int posicion){
        int posicionReal;
        posicionReal = posicion - 1;
        try {
            Receta receta = recetas.get(posicionReal);
            return receta;
        } catch(IndexOutOfBoundsException e){
            System.out.println("No existe una receta con ese indice");
        }
        return null;
    }
    
    public void eliminarReceta(Receta r){
        recetas.remove(r);
    }
}
