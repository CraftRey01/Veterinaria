package com.mycompany.veterinaria;

import java.util.ArrayList;
import java.util.List;

public class Veterinaria {

    private int idVeterinaria;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Cliente> clientes;

    public Veterinaria(int idVeterinaria, String nombre, String direccion, String telefono) {
        this.idVeterinaria = idVeterinaria;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.clientes = new ArrayList<>();
    }

    public int getIdVeterinaria() {
        return idVeterinaria;
    }

    public void setIdVeterinaria(int idVeterinaria) {
        this.idVeterinaria = idVeterinaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Veterinaria{" + "idVeterinaria=" + idVeterinaria + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

    public void mostrarVeterinaria() {
        System.out.println(toString());
    }

    //Parte 2
    // 3) registrar cliente y mostrar clientes
    public void registrarCliente(Cliente cliente) {
        agregarCliente(cliente);
        System.out.println("Cliente registrado: " + cliente.getNombre());
    }

    public void agregarCliente(Cliente nuevoCliente) {
        List<Cliente> nuevaListaClientes = new ArrayList<>(clientes);
        nuevaListaClientes.add(nuevoCliente);
        clientes = nuevaListaClientes;
    }

    public void mostrarClientes() {
        System.out.println("Lista de Clientes de la " + nombre + ":");
        for (Cliente cliente : clientes) {
            System.out.println("- " + cliente.getNombre() + " (ID: " + cliente.getIdCliente() + ", Teléfono: " + cliente.getTelefono() + ")");
        }
    }

    // 4) buscar cliente por id 
    public Cliente buscarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                System.out.println("Cliente encontrado: " + cliente.getNombre() + " ID: " + cliente.getIdCliente());
                return cliente;
            }
        }
        System.out.println("Cliente con ID " + id + " no encontrado.");
        return null;
    }

    // 3) eliminar cliente por id
    public boolean eliminarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                clientes.remove(cliente);
                System.out.println("Cliente eliminado: " + cliente.getNombre());
                return true;
            }
        }
        System.out.println("Cliente con ID " + id + " no encontrado.");
        return false;
    }

    // 5) modificar Telefono de cliente
    public boolean actualizarTelefonoCliente(int id, String nuevoTelefono) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == id) {
                cliente.setTelefono(nuevoTelefono);
                System.out.println("Teléfono actualizado para " + cliente.getNombre() + ": " + nuevoTelefono);
                return true;
            }
        }
        System.out.println("Cliente con ID " + id + " no encontrado.");
        return false;
    }
}
