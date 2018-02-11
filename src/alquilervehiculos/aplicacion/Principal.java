/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.aplicacion;

import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.AlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.DireccionPostal;
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
        Cliente cliente0 = new Cliente("a", "00000000A", new DireccionPostal("a", "a", "00000"));
        Cliente cliente1 = new Cliente("z", "99999999Z", new DireccionPostal("z", "z", "00000"));

//Prueba clase Turismo
        Turismo turismo0 = new Turismo("0000BBB", "B", "B", 1);
        Turismo turismo1 = new Turismo("9999ZZZ", "Z", "Z", 500);

//Prueba clase AlquilerVehiculos        
        AlquilerVehiculos alquiler0 = new AlquilerVehiculos();

        alquiler0.anadirCliente(cliente0);
        alquiler0.anadirCliente(cliente1);

        alquiler0.anadirTurismo(turismo0);
        alquiler0.anadirTurismo(turismo1);
        

        alquiler0.abrirAlquiler(cliente0, turismo0);
        alquiler0.abrirAlquiler(cliente1, turismo1);

//Menu selcción        
        int selector;
        do {
            System.out.println("--Elija una opción--");
            System.out.println("1.- Añadir cliente");
            System.out.println("2.- Borrar cliente");
            System.out.println("3.- Buscar cliente");
            System.out.println("4.- Listar clientes");
            System.out.println("5.- Añadir turismo");
            System.out.println("6.- Borrar turismo");
            System.out.println("7.- Buscar turismo");
            System.out.println("8.- Listar turismos");
            System.out.println("9.- Abrir alquiler");
            System.out.println("10.- Cerrar alquiler");
            System.out.println("11.- Listar alquileres");
            System.out.println("0.- Salir");

            do {
                selector = Entrada.entero();
            } while (selector < 0 || selector > 11);

            switch (selector) {
                case 1:
                    Cliente nuevoCliente = null;
                    do {
                        System.out.print("Nombre: ");
                        String nombre = Entrada.cadena();
                        System.out.print("Calle: ");
                        String calle = Entrada.cadena();
                        System.out.print("Localidad: ");
                        String localidad = Entrada.cadena();
                        System.out.print("Código postal: ");
                        String codigoPostal = Entrada.cadena();
                        System.out.print("DNI: ");
                        String dni = Entrada.cadena();
                        try {
                            nuevoCliente = new Cliente(nombre, dni, new DireccionPostal(calle, localidad, codigoPostal));
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.println(e.getMessage());
                            System.out.println("Los datos introducidos son incorrectos. \n");
                        }
                    } while (nuevoCliente == null);

                    try {
                        alquiler0.anadirCliente(nuevoCliente);
                    } catch (ExcepcionAlquilerVehiculos e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("");
                    break;

                case 2:
                    System.out.print("DNI: ");
                    String delDni = Entrada.cadena();
                    try {
                        alquiler0.borrarCliente(delDni);
                        System.out.println("Cliente eliminado \n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("DNI: ");
                    String searchDni = Entrada.cadena();
                    Cliente clienteBuscado = alquiler0.buscarCliente(searchDni);
                    String mensaje = (clienteBuscado != null) ? clienteBuscado.toString() : "Cliente no encontrado. \n";
                    System.out.println(mensaje);
                    break;

                case 4:
                    System.out.println("-CLIENTES-");
                    int indice = 0;
                    while (alquiler0.obtenerClientes()[indice] != null) {
                        System.out.println(alquiler0.obtenerClientes()[indice]);
                        indice++;
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
                        alquiler0.anadirTurismo(nuevoVehiculo);
                    } catch (ExcepcionAlquilerVehiculos e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.print("Matrícula: ");
                    String delMatricula = Entrada.cadena();
                    try {
                        alquiler0.borrarTurismo(delMatricula);
                        System.out.println("Turismo eliminado \n");
                    } catch (ExcepcionAlquilerVehiculos e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    System.out.print("Matrícula: ");
                    String searchMatricula = Entrada.cadena();
                    try {
                        alquiler0.buscarTurismo(searchMatricula);
                        System.out.println(alquiler0.buscarTurismo(searchMatricula));
                    } catch (ExcepcionAlquilerVehiculos e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8:
                    System.out.println("-TURISMOS-");
                    indice = 0;
                    while (alquiler0.obtenerTurismos()[indice] != null) {
                        System.out.println(alquiler0.obtenerTurismos()[indice]);
                        indice++;
                    }
                    break;

                case 9:
                    System.out.print("Matrícula: ");
                    searchMatricula = Entrada.cadena();
                    Turismo vehiculoBuscado = alquiler0.buscarTurismo(searchMatricula);
                    System.out.print("DNI: ");
                    searchDni = Entrada.cadena();
                    clienteBuscado = alquiler0.buscarCliente(searchDni);
                    if (vehiculoBuscado == null || clienteBuscado == null || !vehiculoBuscado.getDisponible()) {
                        System.out.println("Vehículo o cliente no disponibles. \n");
                    } else {
                        try {
                            alquiler0.abrirAlquiler(clienteBuscado, vehiculoBuscado);
                            System.out.println("Trabajo abierto. \n");
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 10:
                    System.out.print("Matrícula: ");
                    searchMatricula = Entrada.cadena();
                    vehiculoBuscado = alquiler0.buscarTurismo(searchMatricula);
                    if (vehiculoBuscado == null || !vehiculoBuscado.getDisponible()) {
                        System.out.println("Vehículo no disponible. \n");
                    } else {
                        try {
                            alquiler0.cerrarAlquiler(vehiculoBuscado);
                            System.out.println("Alquiler cerrado. \n");
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 11:
                    System.out.println("-ALQUILERES-");
                    indice = 0;
                    while (alquiler0.obtenerAlquileres()[indice] != null) {
                        System.out.println(alquiler0.obtenerAlquileres()[indice].toString());
                        indice++;
                    }
                    break;

                default:
                    break;
            }

        } while (selector != 0);

    }

}
