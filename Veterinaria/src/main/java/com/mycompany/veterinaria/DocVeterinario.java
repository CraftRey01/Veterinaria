package com.mycompany.veterinaria;

import java.util.Scanner;

public class DocVeterinario {

    private String nombre;
    private String telefono;
    private String especialidad;

    public DocVeterinario(String nombre, String telefono, String especialidad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Parte 4
    // 8) Lee por teclado nueva información y muestra la nueva información del veterinario 
    public void leer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del veterinario: ");
        nombre = scanner.nextLine();
        System.out.print("Ingrese el teléfono del veterinario: ");
        telefono = scanner.nextLine();
        System.out.print("Ingrese la especialidad del veterinario: ");
        especialidad = scanner.nextLine();
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Teléfono: " + telefono);
    }
}
