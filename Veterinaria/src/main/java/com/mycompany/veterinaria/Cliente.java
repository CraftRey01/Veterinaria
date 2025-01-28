package com.mycompany.veterinaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    private int idCliente;
    private String nombre;
    private String telefono;
    private List<Animal> animales;

    public Cliente(int idCliente, String nombre, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.animales = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void registrarAnimal(Animal animal) {
        animales.add(animal);
        System.out.println("Animal registrado: " + animal.getNombre());
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    // Parte 1    
    // 2) Buscar a el animal con el nombre 'x' y preguntar si requiere alguna modificación
    public Animal buscarAnimalPorNombre(String nombre) {
        for (int i = 0; i < animales.size(); i++) {
            Animal animal = animales.get(i);
            if (animal.getNombre().equalsIgnoreCase(nombre)) {
                return animal;
            }
        }
        return null;
    }

    public void buscarYModificarAnimal(String nombreBuscado) {
        Animal x = buscarAnimalPorNombre(nombreBuscado);
        if (x != null) {
            System.out.println("\nAnimal encontrado:");
            x.mostrarInformacion();
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nDesea modificar algun atributo: (s/n): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                x.modificarAtributo();
            }
        } else {
            System.out.println("\nNo se encontro un animal con el nombre: " + nombreBuscado);
        }
    }

    // Parte 5
    // 10) para agregar solo un aniamal
    public void agregarAnimal(Animal animal) {
        System.out.println("Animal agregado al cliente " + nombre);
        this.registrarAnimal(animal);
    }

    // 10) para agregar mas de un animal
    public void agregarAnimales(List<Animal> nuevosAnimales) {
        System.out.println("Animales agregados al cliente " + nombre);
        for (Animal animal : nuevosAnimales) {
            this.registrarAnimal(animal);
        }
    }

    // 11) Verificar si un animal esta registrado
    public boolean verificarAnimal(String nombre) {
        for (Animal animal : animales) {
            if (animal.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    // 12) mostrar resumen del cliente
    public void mostrarResumenCompleto() {
        if (animales.isEmpty()) {
            System.out.println("El cliente " + nombre + " no tiene animales registrados.");
        } else {
            System.out.println("Resumen completo para el cliente: " + nombre);
            for (Animal animal : animales) {
                System.out.println("- Animal: " + animal.getNombre());
                System.out.println("  Tipo: " + animal.getEspecie());
                System.out.println("  Consultas:");
                for (Consulta consulta : animal.getConsultas()) {
                    System.out.println("    - " + consulta.getDatoConsulta() + " Costo:" + consulta.getPrecio() + "bs");
                }
                if (animal.getTratamiento() != null) {
                    System.out.println("  Tratamiento:");
                    System.out.println("    - Servicio: " + animal.getTratamiento().getServicio());
                    //         System.out.println("    - Desde: " + animal.getTratamiento().getFechaInicio());
                    //        System.out.println("    - Hasta: " + animal.getTratamiento().getFechaFin());
                } else {
                    System.out.println("  No hay tratamiento registrado.");
                }
            }
        }
    }
}
