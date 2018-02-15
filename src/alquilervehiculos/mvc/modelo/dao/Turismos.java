/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dao;

import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 *
 * @author lol
 */
public class Turismos {

    private Vehiculo[] turismos;
    private final int MAX_TURISMOS = 20;

    public Turismos() {
        turismos = new Vehiculo[MAX_TURISMOS];
    }

    public Vehiculo[] getTurismos() {
        return turismos.clone();
    }

    public Vehiculo buscar(String matricula) {
        int indice = buscarIndiceTurismo(matricula);
        if (indiceNoSuperaTamano(indice)) {
            return new Vehiculo(turismos[indice]);
        } else {
            return null;
        }
    }

    public void anadir(Vehiculo turismo) {
        int indice = buscarPrimerIndiceLibreComprobandoExistencia(turismo);
        if (indiceNoSuperaTamano(indice)) {
            turismos[indice] = turismo;
        } else {
            throw new ExcepcionAlquilerVehiculos("Array de turismos sin espacio.");
        }
    }

    public void borrar(String matricula) {
        int indice = buscarIndiceTurismo(matricula);
        if (indiceNoSuperaTamano(indice)) {
            desplazarUnaPosicionHaciaIzquierda(indice);
        } else {
            throw new ExcepcionAlquilerVehiculos("El turismo no existe.");
        }
    }

    private int buscarIndiceTurismo(String matricula) {
        int indice = 0;
        boolean turismoEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !turismoEncontrado) {
            if (turismos[indice] != null && turismos[indice].getMatricula().equals(matricula)) {
                turismoEncontrado = true;
            } else {
                indice++;
            }
        }
        return indice;
    }

    private boolean indiceNoSuperaTamano(int indice) {
        return indice < turismos.length;
    }

    private int buscarPrimerIndiceLibreComprobandoExistencia(Vehiculo turismo) {
        int indice = 0;
        boolean vehiculoEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado) {
            if (turismos[indice] == null) {
                vehiculoEncontrado = true;
            } else if (turismos[indice].getMatricula().equals(turismo.getMatricula())) {
                throw new ExcepcionAlquilerVehiculos("La matrícula ya existe.");
            } else {
                indice++;
            }
        }
        return indice;
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        for (int i = indice; i < turismos.length - 1 && turismos[i] != null; i++) {
            turismos[i] = turismos[i + 1];
        }
    }

}
