/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio.vehiculo;

import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import static alquilervehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo.values;

/**
 *
 * @author lol
 */
public enum TipoVehiculo {

    TURISMO("Turismo") {
        public Turismo getInstancia(Vehiculo vehiculo) {
            return new Turismo(vehiculo);
        }
    },
    DE_CARGA("De carga") {
        public DeCarga getInstancia(Vehiculo vehiculo) {
            return new DeCarga(vehiculo)
        }
    },
    AUTOBUS("Autobus") {
        public Autobus getInstancia(Vehiculo vehiculo) {
            return new Autobus(vehiculo)
        }
    };

    private String tipoVehiculo;

    private TipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public abstract Vehiculo getInstancia(Vehiculo vehiculo);

    public String toString() {
        return tipoVehiculo;
    }

    public static TipoVehiculo getTipoVehiculoSegunOrdinal(int ordinal) {
        if (ordinalValido(ordinal)) {
            return values()[ordinal];
        } else {
            throw new ExcepcionAlquilerVehiculos("Tipo de vehículo inexsistente.");
        }
    }

    private static boolean ordinalValido(int ordinal) {
        return (ordinal >= 0 && ordinal <= values().length - 1);

    }
}
