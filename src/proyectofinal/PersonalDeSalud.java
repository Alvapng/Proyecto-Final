/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author nogue
 */
public class PersonalDeSalud extends Persona {
     private int matricula;

    public PersonalDeSalud(String nombre, String firma, int edad, int dinero, int matricula) {
        super(nombre, firma, edad, dinero);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
   
    
    public void darAtencion(Paciente p){
        System.out.println("El personal está atendiendo");
    }
}
