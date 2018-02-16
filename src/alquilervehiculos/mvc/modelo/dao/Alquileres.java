/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dao;

import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 *
 * @author lol
 */
public class Alquileres {

    private final int MAX_ALQUILERES = 20;
    private Alquiler[] alquileres;

    public Alquileres() {
        alquileres = new Alquiler[MAX_ALQUILERES];
    }

    public Alquiler[] getAlquileres() {
        return alquileres.clone();
    }

    public void abrir(Cliente cliente, Vehiculo turismo) {
        int indice = buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(turismo);
        if (indiceNoSuperaTamano(indice)) {
            alquileres[indice] = new Alquiler(cliente, turismo);
        } else {
            throw new ExcepcionAlquilerVehiculos("No hay espacio disponible.");
        }
    }

    private int buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(Vehiculo turismo) {
        int indice = 0;
        boolean trabajoEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !trabajoEncontrado) {
            if (alquileres[indice] == null) {
                trabajoEncontrado = true;
            } else if (alquileres[indice].getVehiculo().getMatricula().equals(turismo.getMatricula()) && !alquileres[indice].getVehiculo().getDisponible()) {
                throw new ExcepcionAlquilerVehiculos("Vehículo no disponible.");
            } else {
                indice++;
            }
        }
        return indice;
    }

    private boolean indiceNoSuperaTamano(int indice) {
        return indice < alquileres.length;
    }

    public void cerrar(Vehiculo turismo) {
        int indice = buscarAlquilerAbierto(turismo);
        if (indiceNoSuperaTamano(indice)) {
            alquileres[indice].close();
        } else {
            throw new ExcepcionAlquilerVehiculos("Alquiler no encontrado.");
        }
    }

    public int buscarAlquilerAbierto(Vehiculo turismo) {
        int indice = 0;
        boolean alquilerEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !alquilerEncontrado) {
            if (alquileres[indice] != null && alquileres[indice].getVehiculo().getMatricula().equals(turismo.getMatricula()) && !alquileres[indice].getVehiculo().getDisponible()) {
                alquilerEncontrado = true;
            } else {
                indice++;
            }
        }
        return indice;
    }

}
