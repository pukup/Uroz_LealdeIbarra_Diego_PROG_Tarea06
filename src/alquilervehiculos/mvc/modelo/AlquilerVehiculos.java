/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo;

import alquilervehiculos.mvc.modelo.dao.Alquileres;
import alquilervehiculos.mvc.modelo.dao.Clientes;
import alquilervehiculos.mvc.modelo.dao.Turismos;
import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilervehiculos.mvc.modelo.dominio.Turismo;

/**
 *
 * @author lol
 */
public class AlquilerVehiculos {

    private Turismos turismos;
    private Clientes clientes;
    private Alquileres alquileres;

//Constructor    
    public AlquilerVehiculos() {
        turismos = new Turismos();
        clientes = new Clientes();
        alquileres = new Alquileres();
    }

    public void anadirCliente(Cliente cliente) {
        clientes.anadir(cliente);
    }

    public void borrarCliente(String dni) {
        clientes.borrar(dni);
    }

    public Cliente buscarCliente(String dni) {
        return clientes.buscar(dni);
    }

    public Cliente[] obtenerClientes() {
        return clientes.getClientes();
    }

    public void anadirTurismo(Turismo turismo) {
        turismos.anadir(turismo);
    }

    public void borrarTurismo(String matricula) {
        turismos.borrar(matricula);
    }

    public Turismo buscarTurismo(String matricula) {
        return turismos.buscar(matricula);
    }

    public Turismo[] obtenerTurismos() {
        return turismos.getTurismos();
    }

    public void abrirAlquiler(Cliente cliente, Turismo turismo) {
        alquileres.abrir(cliente, turismo);
    }

    public void cerrarAlquiler(Turismo turismo) {
        alquileres.cerrar(turismo);
    }

    public Alquiler[] obtenerAlquileres() {
        return alquileres.getAlquileres();
    }

    public void anadirDatosPrueba() {
        Cliente cliente0 = new Cliente("a", "00000000A", new DireccionPostal("a", "a", "00000"));
        Cliente cliente1 = new Cliente("z", "99999999Z", new DireccionPostal("z", "z", "00000"));

        Turismo turismo0 = new Turismo("0000BBB", "B", "B", 1);
        Turismo turismo1 = new Turismo("9999ZZZ", "Z", "Z", 500);

        anadirCliente(cliente0);
        anadirCliente(cliente1);

        anadirTurismo(turismo0);
        anadirTurismo(turismo1);

        abrirAlquiler(cliente0, turismo0);
        abrirAlquiler(cliente1, turismo1);
    }
}
