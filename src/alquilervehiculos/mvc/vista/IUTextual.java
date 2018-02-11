/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.vista;

import alquilervehiculos.mvc.controlador.ControladorAlquilerTurismos;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.vista.utilidades.Consola;

/**
 *
 * @author lol
 */
public class IUTextual {
    
    ControladorAlquilerTurismos controlador;
    
    public IUTextual(){
        Opcion.setVista(this);
    }
    
    public void setControlador(ControladorAlquilerTurismos controlador){
        this.controlador = controlador;
    }
    
    public void comenzar(){
        int ordinalOpcion;
        do {
            Consola.mostrarMenu();
            ordinalOpcion = Consola.elegirOpcion();
            Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
            opcion.ejecutar();
        } while (ordinalOpcion != Opcion.SALIR.ordinal());
        
    }
    
    public void salir(){
        System.out.println("Nos vemos en la tele.");
    }
    
    public void anadirCliente(){
        Consola.mostrarCabecera("Añadir cliente.");
        
    }
    
    public void borrarCliente(){
        
    }
    
    public void buscarCliente(){
        
    }
    
    public void listarClientes(){
        
    }
    
    public void anadirTurismo(){
        
    }
    
    public void borrarTurismo(){
        
    }
    
    public void buscarTurismo(){
        
    }
    
    public void listarTurismos(){
        
    }
    
    public void abrirAlquiler(){
        
    }
    
    public void cerrarAlquiler(){
        
    }
    
    public void listarAlquileres(){
        
    }
}
