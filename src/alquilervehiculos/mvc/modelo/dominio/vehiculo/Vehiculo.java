/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio.vehiculo;

import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lol
 */
public class Vehiculo {

//Atributos clase
    private String matricula, marca, modelo;
    private boolean disponible;
    private final double FACTOR_CILINDRADA, FACTOR_NUMERO_PLAZAS, FACTOR_PMA;

//Constructor        
    public Vehiculo(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {

        setMatricula(matricula);
        setMarca(marca);
        setModelo(modelo);
        FACTOR_CILINDRADA = datosTecnicos.getCilindrada();
        FACTOR_NUMERO_PLAZAS = datosTecnicos.getNumeroPlazas();
        FACTOR_PMA = datosTecnicos.getPma();
        setDisponible(true);

    }

//Constructor copia    
    public Vehiculo(Vehiculo turismoCopia) {

        matricula = turismoCopia.getMatricula();
        marca = turismoCopia.getMarca();
        modelo = turismoCopia.getModelo();
        FACTOR_CILINDRADA = turismoCopia.getFACTOR_CILINDRADA();
        FACTOR_NUMERO_PLAZAS = turismoCopia.getFACTOR_NUMERO_PLAZAS();
        FACTOR_PMA = turismoCopia.getFACTOR_PMA();
        disponible = turismoCopia.getDisponible();

    }

//Métodos set
    private void setMarca(String marca) {
        if (marca != null && !marca.equals("")) {
            this.marca = marca;
        } else {
            throw new ExcepcionAlquilerVehiculos("Formato marca incorrecto.");
        }
    }

    private void setModelo(String modelo) {
        if (modelo != null && !modelo.equals("")) {
            this.modelo = modelo;
        } else {
            throw new ExcepcionAlquilerVehiculos("Formato modelo incorrecto.");
        }
    }

    private void setMatricula(String matricula1) {
        if (compruebaMatricula(matricula1)) {
            this.matricula = matricula1;
        } else {
            throw new ExcepcionAlquilerVehiculos("Matrícula incorrecta.");
        }
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * @return the FACTOR_CILINDRADA
     */
    public double getFACTOR_CILINDRADA() {
        return FACTOR_CILINDRADA;
    }

    /**
     * @return the FACTOR_NUMERO_PLAZAS
     */
    public double getFACTOR_NUMERO_PLAZAS() {
        return FACTOR_NUMERO_PLAZAS;
    }

    /**
     * @return the FACTOR_PMA
     */
    public double getFACTOR_PMA() {
        return FACTOR_PMA;
    }

//Métodos get
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public DatosTecnicosVehiculo getDatosTecnicos() {
        return new DatosTecnicosVehiculo(FACTOR_CILINDRADA, FACTOR_NUMERO_PLAZAS, FACTOR_PMA);
    }

//Método toString    
    public String toString() {
        return String.format("VEHICULO %s%n Marca: %s%n Modelo: %s%n  %d%n Disponible: %b%n", matricula, marca, modelo, getDatosTecnicos().toString(), disponible);
    }

//Método validación    
    private boolean compruebaMatricula(String matricula) {
        Pattern regex = Pattern.compile("[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}");
        Matcher matcher = regex.matcher(matricula);
        return matcher.matches();
    }

}
