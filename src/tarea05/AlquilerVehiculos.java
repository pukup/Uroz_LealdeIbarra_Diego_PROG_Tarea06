/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lol
 */
public class AlquilerVehiculos {

//Atributos    
    private final int MAX_TURISMOS = 10;
    private final int MAX_CLIENTES = 50;
    private final int MAX_ALQUILERES = 10;
    private Turismo[] turismos;
    private Cliente[] clientes;
    private Alquiler[] alquileres;

//Constructor    
    public AlquilerVehiculos() {
        turismos = new Turismo[MAX_TURISMOS];
        clientes = new Cliente[MAX_CLIENTES];
        alquileres = new Alquiler[MAX_ALQUILERES];
    }
//Constructor copia

    public AlquilerVehiculos(AlquilerVehiculos alquilerVehiculosCopia) {
        turismos = alquilerVehiculosCopia.getTurismos();
        clientes = alquilerVehiculosCopia.getClientes();
        alquileres = alquilerVehiculosCopia.getAlquileres();
    }

//Métodos get        
    public Turismo[] getTurismos() {
        Turismo[] turismosCopia = turismos.clone();
        return turismosCopia;
    }

    public Cliente[] getClientes() {
        Cliente[] clientesCopia = clientes.clone();
        return clientesCopia;
    }

    public Alquiler[] getAlquileres() {
        Alquiler[] alquileresCopia = alquileres.clone();
        return alquileresCopia;
    }

//Métodos cliente    
    public Cliente getCliente(String dni) {
        int contador = 0;
        boolean buscador = false;
        while (contador < clientes.length && !buscador) {
            if (clientes[contador] != null && clientes[contador].getDni().equals(dni)) {
                buscador = true;
            } else {
                contador++;
            }
        }
        if (buscador) {
            return clientes[contador];
        } else {
            return null;
        }

    }

    public void addCliente(Cliente cliente) {
        int contador = 0;
        boolean buscador = false;
        while (contador < clientes.length && !buscador) {
            if (clientes[contador] == null) {
                buscador = true;
            } else {
                contador++;
            }
        }
        if (buscador) {
            clientes[contador] = cliente;
        } else {
            throw new ExcepcionAlquilerVehiculos("No hay espacio disponible.");
        }
    }

    public void delCliente(String dni) {
        if (!compruebaDni(dni)) throw new ExcepcionAlquilerVehiculos ("DNI incorrecto.");
        int contador = 0;
        boolean buscador = false;
        while (contador < clientes.length && !buscador) {
            if (clientes[contador] != null && clientes[contador].getDni().equals(dni)) {
                buscador = true;
            } else {
                contador++;
            }
        }
        if (buscador) {
            for (int i = contador; i < clientes.length - 1; i++) {
                clientes[i] = clientes[i + 1];
            }
            clientes[clientes.length - 1] = null;
        } else {
            throw new ExcepcionAlquilerVehiculos("Cliente no encontrado.");
        }
    }

//Métodos turismo    
    public Turismo getTurismo(String matricula) {
        int contador = 0;
        boolean buscador = false;
        while (contador < turismos.length && !buscador) {
            if (turismos[contador] != null && turismos[contador].getMatricula().equals(matricula)) {
                buscador = true;
            } else {
                contador++;
            }
        }
        if (buscador) {
            return turismos[contador];
        } else {
            return null;
        }

    }

    public void addTurismo(Turismo turismo) {
        int contador = 0;
        boolean buscador = false;
        while (contador < turismos.length && !buscador) {
            if (turismos[contador] == null) {
                buscador = true;
            } else {
                contador++;
            }
            turismo.setDisponible(true);
        }
        if (buscador) {
            turismos[contador] = turismo;
        } else {
            throw new ExcepcionAlquilerVehiculos("No hay espacio disponible.");
        }
    }

    public void delTurismo(String matricula) {
        if (!compruebaMatricula(matricula)) throw new ExcepcionAlquilerVehiculos ("Matrícula incorrecta.");
        int contador = 0;
        boolean buscador = false;
        while (contador < turismos.length && !buscador) {
            if (turismos[contador] != null && turismos[contador].getMatricula().equals(matricula)) {
                buscador = true;
            } else {
                contador++;
            }
        }
        if (buscador) {
            for (int i = contador; i < turismos.length - 1; i++) {
                turismos[i] = turismos[i + 1];
            }
            turismos[turismos.length - 1] = null;
        } else {
            throw new ExcepcionAlquilerVehiculos("Vehículo no encontrado");
        }
    }

//Metodos alquiler    
    public void openAlquiler(Cliente cliente, Turismo turismo) {
        int contador = 0;
        boolean buscador = false;
        while (contador < alquileres.length && !buscador) {
            if (alquileres[contador] == null) {
                buscador = true;
            } else {
                contador++;
            }
        }
        if (buscador) {
            alquileres[contador] = new Alquiler(cliente, turismo);
            turismo.setDisponible(false);
        } else {
            throw new ExcepcionAlquilerVehiculos("No hay espacio disponible.");
        }

    }

    public void closeAlquiler(Cliente cliente, Turismo turismo) {
        int contador = 0;
        boolean buscador = false;
        while (contador < alquileres.length && !buscador) {
            if (alquileres[contador] != null && alquileres[contador].getTurismo().getMatricula().equals(turismo.getMatricula())) {
                buscador = true;
            } else {
                contador++;
            }

        }
        if (buscador) {
            alquileres[contador].close();
            turismo.setDisponible(true);
        } else {
            throw new ExcepcionAlquilerVehiculos("Alquiler no encontrado.");
        }

    }
        private boolean compruebaDni(String dni) {
        Pattern regex = Pattern.compile("[0-9]{8}[a-z]{1}");
        Matcher matcher = regex.matcher(dni);
        return matcher.matches();
    }
        private boolean compruebaMatricula(String matricula) {
        Pattern regex = Pattern.compile("[0-9]{4}[a-z]{3}");
        Matcher matcher = regex.matcher(matricula);
        return matcher.matches();
    }
}
