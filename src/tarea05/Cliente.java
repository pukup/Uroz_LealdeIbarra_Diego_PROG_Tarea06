/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lol
 */
public class Cliente {

// Atributos para la clase
    private String nombre, direccion, localidad, codigoPostal, dni;
    private int identificador;
    private static int ultimoIdentificador = 0;

//Constructor
    public Cliente(String nombre, String direccion, String localidad, String codigoPostal, String dni) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        if (compruebaCodigoPostal(codigoPostal)) {
            this.codigoPostal = codigoPostal;
        } else {
            throw new ExcepcionAlquilerVehiculos("Código postal incorrecto.");
        }
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
        localidad = clienteCopia.getLocalidad();
        codigoPostal = clienteCopia.getCodigoPostal();
        dni = clienteCopia.getDni();
        identificador = clienteCopia.getIdentificador();
    }

//Métodos get   
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
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
        return String.format("CLIENTE %n Nombre: %s%n Dirección: %s%n Localidad: %s%n Código postal: %s%n Dni: %s%n Identificador: %s%n", nombre, direccion, localidad, codigoPostal, dni, identificador);
    }

//Métodos de validación    
    private boolean compruebaCodigoPostal(String codigoPostal) {
        Pattern regex = Pattern.compile("[0-9]{5}");
        Matcher matcher = regex.matcher(codigoPostal);
        return matcher.matches();
    }

    private boolean compruebaDni(String dni) {
        Pattern regex = Pattern.compile("[0-9]{8}[a-z]{1}");
        Matcher matcher = regex.matcher(dni);
        return matcher.matches();
    }

}