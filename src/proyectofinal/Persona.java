/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author estudiante
 */
public class Persona {
    private int id;
    protected String nombre;
    protected String firma;
    protected int edad;
    protected int dinero;

    public Persona(String nombre, String firma, int edad, int dinero) {
        this.nombre = nombre;
        this.firma = firma;
        this.edad = edad;
        this.dinero = dinero;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFirma() {
        return firma;
    }

    public int getId() {
        return id;
    }

    public int getEdad() {
        return edad;
    }
    
    public void SetDinero(){
        this.dinero = dinero;
    }
    
    public int getDinero(){
        return dinero;
    }
    
    
}
