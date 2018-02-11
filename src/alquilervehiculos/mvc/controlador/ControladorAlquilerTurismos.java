/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.controlador;

import alquilervehiculos.mvc.modelo.AlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.Turismo;
import alquilervehiculos.mvc.vista.IUTextual;

/**
 *
 * @author lol
 */
public class ControladorAlquilerTurismos {

    private AlquilerVehiculos modelo;
    private IUTextual vista;

    public void ControladorAlquilerTurismos(AlquilerVehiculos modelo, IUTextual vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setControlador(this);
    }

    public void comenzar() {
        modelo.anadirDatosPrueba();
    }

    public void anadirCliente(Cliente cliente) {
        modelo.anadirCliente(cliente);
    }

    public void borrarCliente(String dni) {
        modelo.borrarCliente(dni);
    }

    public void buscarCliente(String dni) {
        modelo.buscarCliente(dni);
    }

    public Cliente[] obtenerClientes() {
        return modelo.obtenerClientes();
    }

    public void anadirTurismo(Turismo turismo) {
        modelo.anadirTurismo(turismo);
    }

    public void borrarTurismo(String matricula) {
        modelo.borrarTurismo(matricula);
    }

    public void buscarTurismo(String matricula) {
        modelo.buscarTurismo(matricula);
    }

    public Turismo[] obtenerTurismos() {
        return modelo.obtenerTurismos();
    }

    public void abrirAlquiler(Cliente cliente, Turismo turismo) {
        modelo.abrirAlquiler(cliente, turismo);
    }

    public void cerrarAlquiler(Turismo turismo) {
        modelo.cerrarAlquiler(turismo);
    }

    public Alquiler[] obtenerAlquileres() {
        return modelo.obtenerAlquileres();
    }

}
