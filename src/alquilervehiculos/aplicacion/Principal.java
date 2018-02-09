/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.aplicacion;

import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.AlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.Turismo;
import alquilervehiculos.mvc.vista.utilidades.Entrada;

/**
 *
 * @author lol
 */
public class Principal {

    public static void main(String[] args) {

//Prueba clase Cliente        
        Cliente cliente0 = new Cliente("a", "b", "c", "00000", "00000000a");
        Cliente cliente1 = new Cliente("d", "e", "f", "99999", "99999999z");

//Prueba clase Turismo
        Turismo turismo0 = new Turismo("0000aaa", "", "", 1);
        Turismo turismo1 = new Turismo("9999zzz", "", "", 500);

//Prueba clase AlquilerVehiculos        
        AlquilerVehiculos alquiler0 = new AlquilerVehiculos();

        alquiler0.addCliente(cliente0);
        alquiler0.addCliente(cliente1);

        alquiler0.addTurismo(turismo0);
        alquiler0.addTurismo(turismo1);

        alquiler0.openAlquiler(cliente0, turismo0);
        alquiler0.openAlquiler(cliente1, turismo1);

        for (Cliente clienteArray : alquiler0.getClientes()) {
            if (clienteArray != null) {
                System.out.println(clienteArray.toString());
            }
        }
        for (Turismo turismoArray : alquiler0.getTurismos()) {
            if (turismoArray != null) {
                System.out.println(turismoArray.toString());
            }
        }
        for (Alquiler alquilerArray : alquiler0.getAlquileres()) {
            if (alquilerArray != null) {
                System.out.println(alquilerArray.toString());
            }
        }

//Menu selcción        
        int selector;
        do {
            System.out.println("--Elija una opción--");
            System.out.println("1.- Añadir cliente");
            System.out.println("2.- Borrar cliente");
            System.out.println("4.- Listar clientes");
            System.out.println("5.- Añadir turismo");
            System.out.println("6.- Borrar turismo");
            System.out.println("7.- Listar turismo");
            System.out.println("9.- Abrir alquiler");
            System.out.println("10.- Cerrar alquiler");
            System.out.println("11.- Listar alquileres");
            System.out.println("0.- Salir");

            do{
                            selector = Entrada.entero();
            } while (selector < 0 || selector > 11);

            switch (selector) {
                case 1:
                    Cliente nuevoCliente = null;
                    do {
                        System.out.print("Nombre: ");
                        String nombre = Entrada.cadena();
                        System.out.print("Dirección: ");
                        String direccion = Entrada.cadena();
                        System.out.println("Localidad: ");
                        String localidad = Entrada.cadena();
                        System.out.print("Código postal: ");
                        String codigoPostal = Entrada.cadena();
                        System.out.print("DNI: ");
                        String dni = Entrada.cadena();
                        try {
                            nuevoCliente = new Cliente(nombre, direccion, localidad, codigoPostal, dni);
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.println(e.getMessage());
                            System.out.println("Los datos introducidos son incorrectos. \n");
                        }
                    } while (nuevoCliente == null);

                    try {
                        alquiler0.addCliente(nuevoCliente);
                    } catch (ExcepcionAlquilerVehiculos e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("");
                    break;

                case 2:
                    System.out.print("DNI: ");
                    String delDni = Entrada.cadena();
                    try {
                        alquiler0.delCliente(delDni);
                        System.out.println("Cliente eliminado \n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("DNI: ");
                    String searchDni = Entrada.cadena();
                    Cliente clienteBuscado = alquiler0.getCliente(searchDni);
                    String mensaje = (clienteBuscado != null) ? clienteBuscado.toString() : "Cliente no encontrado. \n";
                    System.out.println(mensaje);
                    break;

                case 4:
                    for (Cliente clienteArray : alquiler0.getClientes()) {
                        if (clienteArray != null) {
                            System.out.println(clienteArray);
                        }
                    }
                    break;

                case 5:
                    Turismo nuevoVehiculo = null;
                    System.out.print("Matrícula: ");
                    String matricula = Entrada.cadena();
                    System.out.print("Marca: ");
                    String marca = Entrada.cadena();
                    System.out.print("Modelo: ");
                    String modelo = Entrada.cadena();
                    System.out.print("Cilindrada: ");
                    int cilindrada = Entrada.entero();
                    try {
                        nuevoVehiculo = new Turismo(matricula, marca, modelo, cilindrada);
                        alquiler0.addTurismo(nuevoVehiculo);
                    } catch (ExcepcionAlquilerVehiculos e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.print("Matrícula: ");
                    String delMatricula = Entrada.cadena();
                    try {
                        alquiler0.delTurismo(delMatricula);
                        System.out.println("Turismo eliminado \n");
                    } catch (ExcepcionAlquilerVehiculos e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    System.out.print("Matrícula: ");
                    String searchMatricula = Entrada.cadena();
                    Turismo vehiculoBuscado = alquiler0.getTurismo(searchMatricula);
                    mensaje = (vehiculoBuscado != null) ? vehiculoBuscado.toString() : "Vehículo no encontrado. \n";
                    System.out.println(mensaje);
                    break;

                case 8:
                    for (Turismo turismoArray : alquiler0.getTurismos()) {
                        if (turismoArray != null) {
                            System.out.println(turismoArray);
                        }
                    }

                    break;

                case 9:
                    System.out.print("Matrícula: ");
                    searchMatricula = Entrada.cadena();
                    vehiculoBuscado = alquiler0.getTurismo(searchMatricula);
                    System.out.print("DNI: ");
                    searchDni = Entrada.cadena();
                    clienteBuscado = alquiler0.getCliente(searchDni);
                    if (vehiculoBuscado == null || clienteBuscado == null) {
                        System.out.println("Matrícula o DNI no encontrados. \n");
                    } else {
                        try {
                            alquiler0.openAlquiler(clienteBuscado, vehiculoBuscado);
                            System.out.println("Trabajo abierto. \n");
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 10:
                    System.out.print("Matrícula: ");
                    searchMatricula = Entrada.cadena();
                    vehiculoBuscado = alquiler0.getTurismo(searchMatricula);
                    System.out.print("DNI: ");
                    searchDni = Entrada.cadena();
                    clienteBuscado = alquiler0.getCliente(searchDni);
                    if (vehiculoBuscado == null || clienteBuscado == null) {
                        System.out.println("Vehículo o cliente no encontrados. \n");
                    } else {
                        try {
                            alquiler0.closeAlquiler(clienteBuscado, vehiculoBuscado);
                            System.out.println("Trabajo cerrado. \n");
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 12:
                    for (Alquiler alquilerArray : alquiler0.getAlquileres()) {
                        if (alquilerArray != null) {
                            System.out.println(alquilerArray);
                        }
                    }
                    break;
                    
                default:
                    break;
            }
            
        } while (selector != 0);

    }

}
