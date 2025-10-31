/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author estudiante
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         int opcion;
         String opc;
         int opcion2;
         boolean verificacion;
        Scanner scanner = new Scanner(System.in);
        Farmacia farmacia = new Farmacia("Farmacia cruz verde", "Luján de cuyo 1920");
        GestorMedicoPaciente gestor = new GestorMedicoPaciente();
       try{ 
        do{
            System.out.println("----------------------------");
            System.out.println("1-Administrador de Farmacia");
            System.out.println("2-Administrador de Médicos");
            System.out.println("3-Administrador de pacientes");
            System.out.println("4-Cerrar programa");
            System.out.println("----------------------------");
            opc = scanner.nextLine();
            opcion = farmacia.verificacionNumero(opc);
            
            switch(opcion){
                case 1:
                    
                    System.out.println("\nAdministrador de Farmacia");
                    do{
                        System.out.println("----------------------------------------------------");
                        System.out.println("1-Cargar Medicamento");
                        System.out.println("2-Listar Medicamentos");
                        System.out.println("3-Buscar Medicamento(Actualizar stock)");
                        System.out.println("4-Cargar Farmaceutico");
                        System.out.println("5-Listar Farmaceuticos");
                        System.out.println("6-Buscar Farmaceutico(Despedirlo)");
                        System.out.println("7-Eliminar Medicamento del stock");
                        System.out.println("8-Salir al menú principal");
                        System.out.println("----------------------------------------------------");
                        opc = scanner.nextLine();
                        opcion2 = farmacia.verificacionNumero(opc);
                        
                        switch(opcion2){
                            case 1:
                                try{
                                    System.out.println("Ingrese el nombre del medicamento");
                                    String nombre2 = scanner.nextLine();
                                    farmacia.verificacionVacio(nombre2);
                                    System.out.println("Ingrese la cantidad del medicamento");
                                    String cant = scanner.nextLine();
                                    int cantidad = farmacia.verificacionNumero(cant);
                                    System.out.println("Ingrese el tipo de medicamento");
                                    String tipo = scanner.nextLine();
                                    farmacia.verificacionVacio(tipo);
                                    System.out.println("Ingrese el precio del medicamento");
                                    String prc = scanner.nextLine();
                                    int precio = farmacia.verificacionNumero(prc);
                                    Medicamento medicamento = new Medicamento(nombre2, cantidad, tipo, precio);
                                    farmacia.cargarMedicamento(medicamento);
                                } catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                                
                            case 2:
                                farmacia.listarMedicamentos();
                                break;
                                
                            case 3:
                                try{
                                System.out.println("Ingrese el nombre del medicamento");
                                String nombreBuscar = scanner.nextLine();
                                farmacia.verificacionVacio(nombreBuscar);
                                System.out.println("Ingrese el nuevo stock");
                                String cant = scanner.nextLine();
                                int cantidad = farmacia.verificacionNumero(cant);
                                farmacia.actualizarStock(nombreBuscar, cantidad);
                                } catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                                
                            case 4:
                                try{
                                System.out.println("Ingrese el nombre del farmaceutico");
                                String nombre = scanner.nextLine();
                                farmacia.verificacionVacio(nombre);
                                System.out.println("Ingrese la firma del farmaceutico");
                                String firma = scanner.nextLine();
                                farmacia.verificacionVacio(firma);
                                System.out.println("Ingrese la edad del farmaceutico");
                                String ed = scanner.nextLine();
                                int edad = farmacia.verificacionNumero(ed);
                                System.out.println("Ingrese la matricula del farmaceutico");
                                String matr = scanner.nextLine();
                                int matricula = farmacia.verificacionNumero(matr);
                                int dinero = 0;
                                Farmaceutico farmaceutico = new Farmaceutico(nombre, firma, edad, dinero, matricula);
                                farmacia.cargarFarmaceutico(farmaceutico);
                                } catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                              
                            case 5:
                                farmacia.listarFarmaceutico();
                                break;
                            case 6:
                                System.out.println("Ingrese la matricula del Farmaceutico");
                                String matr = scanner.nextLine();
                                int matriculaBuscar = farmacia.verificacionNumero(matr);
                                farmacia.despedirFarmaceutico(matriculaBuscar);
                                break;
                            case 7:
                                try{
                                System.out.println("Que medicamento desea eliminar?");
                                String nombre = scanner.nextLine();
                                farmacia.verificacionVacio(nombre);
                                farmacia.eliminarMedicamento(nombre);
                                }catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 8:
                                System.out.println("Saliendo al menú principal");
                                break;
                            default:
                                System.out.println("Dato no valido");
                        }
                    }while(opcion2 != 8);
                    break;
                    
                    
                case 2:
                    
                    System.out.println("Administrador de Médicos");
                    do{
                        System.out.println("--------------------------------");
                        System.out.println("1-Cargar Médico");
                        System.out.println("2-Listar Medicos");
                        System.out.println("3-Buscar Médico");
                        System.out.println("4-Salir al menú principal");
                        System.out.println("--------------------------------");
                        opc = scanner.nextLine();
                        opcion2 = farmacia.verificacionNumero(opc);
                        
                        switch(opcion2){
                            case 1:
                                try{
                                System.out.println("Ingrese el nombre del médico");
                                String nombreMedico = scanner.nextLine();
                                farmacia.verificacionVacio(nombreMedico);
                                System.out.println("Ingrese la firma del médico");
                                String firmaMedico = scanner.nextLine();
                                farmacia.verificacionVacio(firmaMedico);
                                System.out.println("Ingrese la edad del médico");
                                String ed = scanner.nextLine();
                                int edad = farmacia.verificacionNumero(ed);
                                System.out.println("Ingrese el precio de consulta del médico");
                                String cons = scanner.nextLine();
                                int consulta = farmacia.verificacionNumero(cons);
                                System.out.println("Ingrese la especialidad del médico");
                                String especialidad = scanner.nextLine();
                                farmacia.verificacionVacio(especialidad);
                                System.out.println("Ingrese la matricula del médico");
                                String matr = scanner.nextLine();
                                int matricula = farmacia.verificacionNumero(matr);
                                int dinero = 0;
                                Medico medico = new Medico(consulta, especialidad, nombreMedico, firmaMedico, edad, dinero, matricula);
                                gestor.cargarMedico(medico);
                                } catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 2:
                                gestor.listarMedicos();
                                break;
                            case 3:
                                try{
                                    System.out.println("Que tipo de medico busca?");
                                    String busqueda = "";
                                    busqueda = scanner.nextLine();
                                    farmacia.verificacionVacio(busqueda);
                                        gestor.listarMedicos(busqueda);
                                } catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 4:
                                System.out.println("Saliendo al menú principal");
                                break;
                            default:
                                System.out.println("Dato no valido");
                        }
                    }while(opcion2 != 4);
                    break;
                    
                case 3:
                    
                    System.out.println("Administrador de pacientess");
                    do{
                        System.out.println("--------------------------------");
                        System.out.println("1-Cargar Paciente");
                        System.out.println("2-Buscar Paciente");
                        System.out.println("3-Buscar paciente(obtener consulta/comprar medicamento");
                        System.out.println("4-Salir al menú principal");
                        System.out.println("--------------------------------");
                        opc = scanner.nextLine();
                        opcion2 = farmacia.verificacionNumero(opc);
                        
                        switch(opcion2){
                            case 1:
                                try{
                                    System.out.println("Ingrese el nombre del Paciente");
                                    String nombrePaciente = scanner.nextLine();
                                    farmacia.verificacionVacio(nombrePaciente);
                                    System.out.println("Ingrese la firma del Paciente");
                                    String firmaPaciente = scanner.nextLine();
                                    farmacia.verificacionVacio(firmaPaciente);
                                    System.out.println("Ingrese la edad del Paciente");
                                    String ed = scanner.nextLine();
                                    int edad = farmacia.verificacionNumero(ed);
                                    int dinero = 0;
                                    Paciente paciente = new Paciente(nombrePaciente, firmaPaciente, edad, dinero);
                                    gestor.cargarPaciente(paciente);
                                } catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 2:
                                gestor.listarPacientes();
                                break;
                            case 3:
                                try{
                                System.out.println("Ingrese el ID del paciente a buscar");
                                String buscar = scanner.nextLine();
                                int idBuscar = farmacia.verificacionNumero(buscar);
                                Paciente p = gestor.buscarPaciente(idBuscar);
                                if (p == null){
                                    throw new Exception("Ingrese un id valido");
                                }
                                
                                do{
                                System.out.println("¿Qué desea hacer?");
                                System.out.println("1-Consulta Médica");
                                System.out.println("2-Comprar medicamento");
                                System.out.println("3-Nada");
                                opc = scanner.nextLine();
                                opcion = farmacia.verificacionNumero(opc);
                                        
                                switch(opcion){
                                    case 1:
                                         try{
                                         System.out.println("Estos son los médicos disponibles para su consulta");
                                         gestor.listarMedicos();
                                         System.out.println("Que tipo de especialista necesita?");
                                         String cons = scanner.nextLine();
                                         farmacia.verificacionVacio(cons);
                                         System.out.println("Elija uno ingresando su matrícula");
                                         String buscarMatr = scanner.nextLine();
                                         int buscarMatricula = farmacia.verificacionNumero(buscarMatr);
                                         Medico medico = gestor.buscarMedico(buscarMatricula);
                                         String esp = medico.getEspecialidad();
                                         if (esp.equalsIgnoreCase(cons)){
                                            String nombrePaciente = p.getNombre();
                                            Receta receta = medico.crearReceta(nombrePaciente);
                                            gestor.cargarReceta(receta);
                                            if(receta == null){
                                                throw new Exception("No se ha creado correctamente la receta");
                                            }
                                            medico.darAtencion(p);
                                            medico.darReceta(receta, p, idBuscar, medico.getMatricula());
                                         } else {
                                            throw new Exception("No es el medico correcto, ingrese un medico valido(matricula)");
                                         }
                                         } catch(Exception e) {
                                               System.out.println(e.getMessage());
                                         }
                                         
                                        break;
                                    case 2:
                                        try{
                                            System.out.println("Desea cargar recetas");
                                            String rta = scanner.nextLine();
                                            farmacia.verificacionVacio(rta);
                                            if(rta.equalsIgnoreCase("si")){
                                               int matricula = farmacia.generarMatricula();
                                               Farmaceutico f = farmacia.buscarFarmaceutico(matricula);
                                               System.out.println("Esta siendo atendido por " + f.getNombre() + "\n");
                                                p.mostrarRecetas();
                                                System.out.println("Cual receta desea cargar(id)");
                                                String id = scanner.nextLine();
                                                int id2 = farmacia.verificacionNumero(id);
                                                Receta r = p.buscarReceta(id2);
                                                String nombreMed = r.getNombreMedicamento();
                                                Medicamento med = farmacia.buscarMedicamento(nombreMed);
                                                int precio = med.getPrecio();
                                                f.autentificarReceta(r);
                                                if (precio <= p.getDinero() && r.getCantidad() < med.getCantidad()){
                                                    p.Pagar(nombreMed, precio, idBuscar, matricula);
                                                    f.darMedicamento();
                                                    int nuevoStock= med.getCantidad() - r.getCantidad();
                                                    gestor.cargarReceta(r);
                                                    p.eliminarReceta(r);
                                                    farmacia.actualizarStock(nombreMed, nuevoStock);
                                                } else {
                                                    throw new Exception("No se pudo realizar la transaccion");
                                                }
                                            }
                                        }catch(Exception e){
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Saliendo al menú de gestores de pacientes...");
                                        break;
                                    default:
                                        System.out.println("Dato invalido");
                                }
                                }while(opcion != 3);
                                } catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 4:
                                System.out.println("Saliendo al menú principal");
                                break;
                            default:
                                System.out.println("Dato no valido");
                        }
                    }while(opcion2 != 4);
                    break;
                    
                case 4:
                    System.out.println("Cerrando programa");
                    break;
                default:
                    System.out.println("Dato no valido");
            }
        }while(opcion != 4);
       
        
        
    }catch(Exception e){
            System.out.println(e);
}  

  }
}
        
    
