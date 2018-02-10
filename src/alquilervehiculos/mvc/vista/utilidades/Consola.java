/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.vista.utilidades;

import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.Turismo;

/**
 *
 * @author lol
 */
public class Consola {

    public Consola() {

    }

    public static void mostrarMenu() {

    }

    public static void mostrarCabecera() {

    }

    public static int elegirOpcion() {
        int opcion = 0;
        return opcion;
    }

    public static String leerDni() {
        System.out.println("Introduzca DNI.");
        String dni = Entrada.cadena();
        return dni;
    }

    public static String leerMatricula() {
        System.out.println("Introduzca Matrícula.");
        String matricula = Entrada.cadena();
        return matricula;
    }

    public static Cliente leerCliente() {
        Cliente cliente = null;
        System.out.print("Nombre: ");
        String nombre = Entrada.cadena();
        System.out.print("Calle: ");
        String calle = Entrada.cadena();
        System.out.print("Localidad: ");
        String localidad = Entrada.cadena();
        System.out.print("Código postal: ");
        String codigoPostal = Entrada.cadena();
        System.out.print("DNI: ");
        String dni = Entrada.cadena();
        try {
            cliente = new Cliente(nombre, dni, new DireccionPostal(calle, localidad, codigoPostal));
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }

    public static Turismo leerTurismo() {
        Turismo turismo = null;
        System.out.print("Matrícula: ");
        String matricula = Entrada.cadena();
        System.out.print("Marca: ");
        String marca = Entrada.cadena();
        System.out.print("Modelo: ");
        String modelo = Entrada.cadena();
        System.out.println("Color: ");
        String color = Entrada.cadena();
        System.out.print("Cilindrada: ");
        int cilindrada = Entrada.entero();
        try {
            turismo = new Turismo(matricula, marca, modelo, cilindrada);
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf(e.getMessage());
        }
        return turismo;
    }
    
}
