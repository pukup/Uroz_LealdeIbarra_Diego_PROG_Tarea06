/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lol
 */
public class Cliente {

// Atributos para la clase
    private String nombre, dni;
    private DireccionPostal direccion;
    private int identificador;
    private static int ultimoIdentificador = 0;

//Constructor
    public Cliente(String nombre, String dni, DireccionPostal direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        if (compruebaDni(dni)) {
            this.dni = dni;
        } else {
            throw new ExcepcionAlquilerVehiculos("DNI incorrecto.");
        }
        ultimoIdentificador++;
        identificador = ultimoIdentificador;
    }

//Constructor copia    
    public Cliente(Cliente clienteCopia) {
        nombre = clienteCopia.getNombre();
        direccion = clienteCopia.getDireccion();
        dni = clienteCopia.getDni();
        identificador = clienteCopia.getIdentificador();
    }

//Métodos get   
    public String getNombre() {
        return nombre;
    }

    public DireccionPostal getDireccion() {
        return new DireccionPostal(direccion);
    }

    public String getDni() {
        return dni;
    }

    public int getIdentificador() {
        return identificador;
    }

    public int getUltimoIdentificador() {
        return ultimoIdentificador;
    }

//Método toString    
    public String toString() {
        return String.format("CLIENTE %n Nombre: %s%n Dirección: %s%n Dni: %s%n Identificador: %s%n", nombre, direccion.toString(), dni, identificador);
    }

//Métodos de validación    
    private boolean compruebaDni(String dni) {
        Pattern regex = Pattern.compile("[0-9]{8}[a-z]{1}");
        Matcher matcher = regex.matcher(dni);
        return matcher.matches();
    }

}