/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;
import java.util.Scanner;
/**
 *
 * @author estudiante
 */
public class Medico extends PersonalDeSalud{
    
    private int precioConsulta;
    private String especialidad;

    public Medico(int precioConsulta, String especialidad, String nombre, String firma, int edad, int dinero, int matricula) {
        super(nombre, firma, edad, dinero, matricula);
        this.precioConsulta = precioConsulta;
        this.especialidad = especialidad;
    }

    public String getEspecialidad(){
        return especialidad;
    }
    
    public int getPrecioConsulta() {
        return precioConsulta;
    }
   
    @Override
    public void darAtencion(Paciente p){
        Scanner sc = new Scanner(System.in);
        String nombre = p.getNombre();
        System.out.println("Ingrese dia, mes y año");
        int dia = sc.nextInt();
        sc.nextLine();
        int mes = sc.nextInt();
        sc.nextLine();
        int anio = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese la especialidad");
        String especialidad = sc.nextLine();
        p.HistorialMedico(nombre, dia, mes, anio, especialidad);
    }
    
    
    public void darReceta(Receta r, Paciente p, int id, int matr){
        try {
            if (p.getDinero() > precioConsulta){
                p.agregarReceta(r);
                p.Pagar(precioConsulta, id, matr);
            } else {
                throw new Exception("Dinero insuficiente");
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Receta crearReceta(String nombrePaciente){
        Scanner scanner = new Scanner(System.in);
        Farmacia f = new Farmacia("","");
        try{
        System.out.println("Ingrese el nombre del medicamento");
        String nombreMedicamento = scanner.nextLine();
        f.verificacionVacio(nombreMedicamento);
        System.out.println("Ingrese la cantidad de medicamento ");
        String cantidad = scanner.nextLine();
        int cantMedicamento = f.verificacionNumero(cantidad);
        System.out.println("Ingrese el tipo");
        String tipo = scanner.nextLine();
        f.verificacionVacio(tipo);
        System.out.println("Ingrese su nombre(del Medico)");
        String nombreMedico = scanner.nextLine();
        f.verificacionVacio(nombreMedico);
        System.out.println("ingrese su firma(del Medico)");
        String firma = scanner.nextLine();
        f.verificacionVacio(firma);
        System.out.println("Ingrese la descripcion de la receta");
        String descripcion = scanner.nextLine();
        f.verificacionVacio(descripcion);
        Receta receta = new Receta(nombreMedicamento, tipo, firma, nombreMedico, descripcion, cantMedicamento, nombrePaciente);
        return receta;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
