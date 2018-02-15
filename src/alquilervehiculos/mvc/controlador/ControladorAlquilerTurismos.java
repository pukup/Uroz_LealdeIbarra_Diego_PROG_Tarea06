/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.controlador;

import alquilervehiculos.mvc.modelo.AlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilervehiculos.mvc.vista.IUTextual;

/**
 *
 * @author lol
 */
public class ControladorAlquilerTurismos {

    private AlquilerVehiculos modelo;
    private IUTextual vista;

    public ControladorAlquilerTurismos(AlquilerVehiculos modelo, IUTextual vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setControlador(this);
    }

    public void comenzar() {
        modelo.anadirDatosPrueba();
        vista.comenzar();
    }

    public void anadirCliente(Cliente cliente) {
        modelo.anadirCliente(cliente);
    }

    public void borrarCliente(String dni) {
        modelo.borrarCliente(dni);
    }

    public Cliente buscarCliente(String dni) {
        return modelo.buscarCliente(dni);
    }

    public Cliente[] obtenerClientes() {
        return modelo.obtenerClientes();
    }

    public void anadirTurismo(Vehiculo turismo) {
        modelo.anadirTurismo(turismo);
    }

    public void borrarTurismo(String matricula) {
        modelo.borrarTurismo(matricula);
    }

    public Vehiculo buscarTurismo(String matricula) {
        return modelo.buscarTurismo(matricula);
    }

    public Vehiculo[] obtenerTurismos() {
        return modelo.obtenerTurismos();
    }

    public void abrirAlquiler(Cliente cliente, Vehiculo turismo) {
        modelo.abrirAlquiler(cliente, turismo);
    }

    public void cerrarAlquiler(Vehiculo turismo) {
        modelo.cerrarAlquiler(turismo);
    }

    public Alquiler[] obtenerAlquileres() {
        return modelo.obtenerAlquileres();
    }

}
