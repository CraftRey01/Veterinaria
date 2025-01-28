package com.mycompany.veterinaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Animal {

    private int idAnimal;
    private String nombre;
    private int genero;
    private String especie;
    private Tratamiento tratamiento;
    private List<Consulta> consultas;

    public Animal(int idAnimal, String nombre, int genero, String especie) {
        this.idAnimal = idAnimal;
        this.nombre = nombre;
        this.genero = genero;
        this.especie = especie;
        this.consultas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public void agregarConsulta(Consulta consulta) {
        consultas.add(consulta);
        System.out.println("Consulta agregada para el animal " + nombre);
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void mostrarInformacion() {
        System.out.println("Informacion del animal:");
        System.out.println("1. ID Animal: " + idAnimal);
        System.out.println("2. Nombre: " + nombre);
        System.out.println("3. Genero: " + genero);
        System.out.println("4. Especie: " + especie);
    }

    // Parte 1
    // 2) Buscar a el animal con el nombre 'x' y preguntar si requiere alguna modificación
    public void modificarAtributo() {
        Scanner scanner = new Scanner(System.in);
        mostrarInformacion();
        System.out.println("\nInserte atributo a modicar (Ingrese el numero correspondiente)");
        System.out.println("1. ID Animal");
        System.out.println("2. Nombre");
        System.out.println("3. Genero");
        System.out.println("4. Especie");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Nuevo ID Animal: ");
                setIdAnimal(scanner.nextInt());
                break;
            case 2:
                System.out.print("Nuevo nombre: ");
                setNombre(scanner.nextLine());
                break;
            case 3:
                System.out.print("Nuevo Genero (0 = Hembra, 1 = Macho): ");
                setGenero(scanner.nextInt());
                break;
            case 4:
                System.out.print("Nueva Especie: ");
                setEspecie(scanner.nextLine());
                break;
            default:
                System.out.println("Opcion no valida.");
        }
        System.out.println("\n¡Atributo modificado con exito!");
        mostrarInformacion();
    }

    public static Animal buscarPorNombre(List<Animal> animales, String nombreBuscado) {
        for (Animal animal : animales) {
            if (animal.getNombre().equalsIgnoreCase(nombreBuscado)) {
                return animal;
            }
        }
        return null;
    }
}
