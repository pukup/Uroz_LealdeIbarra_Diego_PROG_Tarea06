/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea05;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lol
 */
public class Alquiler {

//Atributos    
    private Date fecha;
    private int dias;
    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private final int MS_DIA = 1000 * 60 * 60 * 24;
    private final double PRECIO_DIA = 30;
    private Turismo turismo;
    private Cliente cliente;

//Constructor    
    public Alquiler(Cliente cliente, Turismo turismo) {
        if (turismo.getDisponible()) {
            this.cliente = cliente;
            this.turismo = turismo;
            fecha = new Date();
            dias = 0;
            turismo.setDisponible(false);
        } else {
            throw new ExcepcionAlquilerVehiculos("Vehículo no disponible.");
        }
    }
    
//Constructor copia
    public Alquiler(Alquiler alquilerCopia) {
        turismo = alquilerCopia.getTurismo();
        cliente = alquilerCopia.getCliente();
        dias = alquilerCopia.getDias();
        fecha = alquilerCopia.getDate();
    }

//Métodos get    
    public Date getDate() {
        return fecha;
    }

    public int getDias() {
        return difDias();
    }

    public Turismo getTurismo() {
        return new Turismo(turismo);
    }

    public double getPrecioDia() {
        return PRECIO_DIA;
    }

    public Cliente getCliente() {
        return new Cliente(cliente);
    }

    public double getPrecio() {
        return PRECIO_DIA * difDias() + turismo.getCilindrada() / 100;
    }

    public double getPrecio(Turismo turismo, int dias) {
        return PRECIO_DIA * dias + turismo.getCilindrada() / 100;
    }

//Método toString    
    public String toString() {
        return String.format("ALQUILER %n Fecha inicio: %s%n Días: %d%n Turismo: %s%n Cliente: %s%n Precio: %f€%n", fecha.toString(), getDias(), turismo.getMatricula(), cliente.getDni(), getPrecio());
    }

//Método cerrar alquiler   
    public void close() {
        if (dias == 0) {
            dias = difDias();
        } else {
            throw new ExcepcionAlquilerVehiculos("El alquiler está cerrado");
        }
    }

//Método diferencia de días    
    public int difDias() {
        long tiempoAlquiler = new Date().getTime() - getDate().getTime();
        long diasAlquiler = tiempoAlquiler / MS_DIA;
        if (diasAlquiler < 1) {
            return 1;
        } else {
            return (int) diasAlquiler;
        }

    }

}
