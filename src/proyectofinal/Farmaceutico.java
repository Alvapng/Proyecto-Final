/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import java.sql.*;

/**
 *
 * @author estudiante
 */
public class Farmaceutico extends PersonalDeSalud{

    public Farmaceutico(String nombre, String firma, int edad, int dinero, int matricula) {
        super(nombre, firma, edad, dinero, matricula);
    }

    
    public void darMedicamento(){
        System.out.println( nombre + " ha proporcionado el medicamento");
    }
    
    public void autentificarReceta(Receta r){
        String firma = r.getFirma();
        Connection conn = null;
        try{
        conn = DriverManager.getConnection("jdbc:sqlite:proyectoFinal.sqlite");
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Medico WHERE firma = ?");
        ps.setString(1, firma);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
        String comparacion = rs.getString("firma");
        if(comparacion.equals(firma)){
            System.out.println("Receta valida");
            ps.close();
            rs.close();
            conn.close();
        } else {
            ps.close();
            rs.close();
            conn.close();
            throw new Exception("Receta invalida, la firma no coincide con ningun medico");
        }
        }
        } catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
}
