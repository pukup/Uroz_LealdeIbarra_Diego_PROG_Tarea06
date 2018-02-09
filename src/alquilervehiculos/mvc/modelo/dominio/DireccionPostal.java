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
public class DireccionPostal {

    private String calle, localidad, codigoPostal;

    public DireccionPostal(String calle, String localidad, String codigoPostal) {

        this.calle = calle;
        this.localidad = localidad;
        if (compruebaCodigoPostal(codigoPostal)) {
            this.codigoPostal = codigoPostal;
        } else {
            throw new ExcepcionAlquilerVehiculos("Código Postal no válido");
        }
    }

    public DireccionPostal(DireccionPostal direccionCopia) {
        calle = direccionCopia.getCalle();
        localidad = direccionCopia.getLocalidad();
        codigoPostal = direccionCopia.getCodigoPostal();
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String toString(){
        return String.format("Calle: %s%n Localidad: %s%n Código postal: %s%n", calle, localidad, codigoPostal);
    }
    private boolean compruebaCodigoPostal(String codigoPostal) {
        Pattern regex = Pattern.compile("[0-9]{5}");
        Matcher matcher = regex.matcher(codigoPostal);
        return matcher.matches();
    }

}
