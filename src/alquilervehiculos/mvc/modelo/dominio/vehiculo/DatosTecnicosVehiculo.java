/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio.vehiculo;

import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 *
 * @author lol
 */
public class DatosTecnicosVehiculo {

    private double cilindrada, numeroPlazas, pma;

    public DatosTecnicosVehiculo(double cilindrada, double numeroPlazas, double pma) {

        setCilindrada(cilindrada);
        setNumeroPlazas(numeroPlazas);
        setPma(pma);
    }

    public DatosTecnicosVehiculo(DatosTecnicosVehiculo datosTecnicos) {

        cilindrada=datosTecnicos.getCilindrada();
        numeroPlazas=datosTecnicos.getNumeroPlazas();
        pma=datosTecnicos.getPma();
    }
    
    private void setCilindrada(double cilindrada) {
        if (cilindrada > 0) {
            this.cilindrada = cilindrada;
        } else {
            throw new ExcepcionAlquilerVehiculos("Cilindrada no válida");
        }
    }

    private void setNumeroPlazas(double numeroPlazas) {
        if (numeroPlazas > 0) {
            this.numeroPlazas = numeroPlazas;
        } else {
            throw new ExcepcionAlquilerVehiculos("Plazas no válidas");
        }
    }

    private void setPma(double pma) {
        if (pma > 0) {
            this.pma = pma;
        } else {
            throw new ExcepcionAlquilerVehiculos("PMA no válido");
        }
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public double getNumeroPlazas() {
        return numeroPlazas;
    }

    public double getPma() {
        return pma;
    }
    
    public String toString(){
        return String.format("Cilindrada: %s%n Número de plazas: %s%n PMA: %s%n", cilindrada, numeroPlazas, pma);
    }
}