    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author estudiante
 */
public class Medicamento {
    private String nombre;
    private int cantidad;
    private String tipo;
    private int precio;

    public Medicamento(String nombre, int cantidad, String tipo, int precio) {
        this.precio = precio;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
