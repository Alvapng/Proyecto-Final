/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author estudiante
 */
public class Receta { 
    private String nombreMedicamento;
    private String tipo;
    private String firma;
    private String especialista; 
    private String descripcion; 
    private int cantidad;
    private String nombrePaciente;

    public Receta(String nombreMedicamento, String tipo, String firma, String especialista, String descripcion, int cantidad, String nombrePaciente) {
        this.nombreMedicamento = nombreMedicamento;
        this.tipo = tipo;
        this.firma = firma;
        this.especialista = especialista;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getEspecialista() {
        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
    
  
}
