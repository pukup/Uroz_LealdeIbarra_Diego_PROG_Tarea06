/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.vista;

import alquilervehiculos.mvc.controlador.ControladorAlquilerTurismos;
import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.Turismo;
import alquilervehiculos.mvc.vista.utilidades.Consola;

/**
 *
 * @author lol
 */
public class IUTextual {

    ControladorAlquilerTurismos controlador;

    public IUTextual() {
        Opcion.setVista(this);
    }

    public void setControlador(ControladorAlquilerTurismos controlador) {
        this.controlador = controlador;
    }

    public void comenzar() {
        int ordinalOpcion;
        do {
            Consola.mostrarMenu();
            ordinalOpcion = Consola.elegirOpcion();
            Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
            opcion.ejecutar();
        } while (ordinalOpcion != Opcion.SALIR.ordinal());

    }

    public void salir() {
        System.out.println("Nos vemos en la tele.");
    }

    public void anadirCliente() {
        Consola.mostrarCabecera("Añadir cliente.");
        Cliente cliente = Consola.leerCliente();
        try {
            controlador.anadirCliente(cliente);
            System.out.println("Cliente añadido.");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.println(e.getMessage());
        }
    }

    public void borrarCliente() {
        Consola.mostrarCabecera("Borrar cliente.");
        String dni = Consola.leerDni();
        try {
            controlador.borrarCliente(dni);
            System.out.println("Cliente eliminado.");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarCliente() {
        Consola.mostrarCabecera("Buscar cliente.");
        String dni = Consola.leerDni();
        Cliente cliente = controlador.buscarCliente(dni);
        String mensaje = (cliente != null) ? cliente.toString() : "Cliente no encontrado.";
        System.out.printf("%n%n%s", mensaje);
    }

    public void listarClientes() {
        Consola.mostrarCabecera("Listado de clientes.");
        for (Cliente cliente : controlador.obtenerClientes()) {
            if (cliente != null) {
                System.out.println(cliente);
            }
        }
        System.out.println("");
    }

    public void anadirTurismo() {
        Consola.mostrarCabecera("Añadir turismo.");
        Turismo turismo = Consola.leerTurismo();
        try {
            controlador.anadirTurismo(turismo);
            System.out.println("Vehículo añadido.");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.println(e.getMessage());
        }
    }

    public void borrarTurismo() {
        Consola.mostrarCabecera("Borrar turismo.");
        String matricula = Consola.leerMatricula();
        try {
            controlador.borrarTurismo(matricula);
            System.out.println("Turismo eliminado.");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarTurismo() {
        Consola.mostrarCabecera("Buscar turismo.");
        String matricula = Consola.leerMatricula();
        Turismo turismo = controlador.buscarTurismo(matricula);
        String mensaje = (turismo != null) ? turismo.toString() : "Turismo no encontrado.";
        System.out.printf("%n%n%s", mensaje);
    }

    public void listarTurismos() {
        Consola.mostrarCabecera("Listado de turismos.");
        for (Turismo turismo : controlador.obtenerTurismos()) {
            if (turismo != null) {
                System.out.println(turismo);
            }
        }
        System.out.println("");
    }

    public void abrirAlquiler() {
        Consola.mostrarCabecera("Abrir alquiler.");
        String matricula = Consola.leerMatricula();
        String dni = Consola.leerDni();
        try {
            Turismo turismo = controlador.buscarTurismo(matricula);
            Cliente cliente = controlador.buscarCliente(dni);
            Alquiler alquiler = new Alquiler(cliente, turismo);
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.println(e.getMessage());
        }

    }

    public void cerrarAlquiler() {
        Consola.mostrarCabecera("Cerrar alquiler.");
        String matricula = Consola.leerMatricula();
        try {
            Turismo turismo = controlador.buscarTurismo(matricula);
            controlador.cerrarAlquiler(turismo);
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarAlquileres() {
        Consola.mostrarCabecera("Listado de alquileres.");
        for (Alquiler alquiler : controlador.obtenerAlquileres()) {
            if (alquiler != null) {
                System.out.println(alquiler);
            }
        }
        System.out.println("");
    }
}
