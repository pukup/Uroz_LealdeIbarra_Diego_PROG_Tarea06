/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lol
 */
public class Turismo {

//Atributos clase
    private String matricula, marca, modelo;
    private int cilindrada;
    private boolean disponible;

//Constructor        
    public Turismo(String matricula, String marca, String modelo, int cilindrada) {

        setMarca(marca);
        setModelo(modelo);
        setCilindrada(cilindrada);
        setMatricula(matricula);
        setDisponible(true);

    }

//Constructor copia    
    public Turismo(Turismo turismoCopia) {

        marca = turismoCopia.getMarca();
        modelo = turismoCopia.getModelo();
        cilindrada = turismoCopia.getCilindrada();
        matricula = turismoCopia.getMatricula();
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

    private void setCilindrada(int cilindrada1) {
        if (cilindrada1 > 0) {
            this.cilindrada = cilindrada1;
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

//Métodos get
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public String getMatricula() {
        return matricula;
    }

    public boolean getDisponible() {
        return disponible;
    }

//Método toString    
    public String toString() {
        return String.format("TURISMO %s%n Marca: %s%n Modelo: %s%n Cilindrada: %d%n Disponible: %b%n", matricula, marca, modelo, cilindrada, disponible);
    }

//Método validación    
    private boolean compruebaMatricula(String matricula) {
        Pattern regex = Pattern.compile("[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}");
        Matcher matcher = regex.matcher(matricula);
        return matcher.matches();
    }

}
