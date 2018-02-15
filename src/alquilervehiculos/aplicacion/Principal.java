/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.aplicacion;

import alquilervehiculos.mvc.controlador.ControladorAlquilerTurismos;
import alquilervehiculos.mvc.modelo.AlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilervehiculos.mvc.vista.IUTextual;

/**
 *
 * @author lol
 */
public class Principal {

    public static void main(String[] args) {

        AlquilerVehiculos modelo = new AlquilerVehiculos();
        IUTextual vista = new IUTextual();
        ControladorAlquilerTurismos controlador = new ControladorAlquilerTurismos(modelo, vista);

        controlador.comenzar();

    }

}
