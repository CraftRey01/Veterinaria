package com.mycompany.veterinaria;

import java.util.Scanner;

public class Examen {

    private int idExamen;
    String descripcion;
    String resultado;

    public Examen(int idExamen, String descripcion, String resultado) {
        this.idExamen = idExamen;
        this.descripcion = descripcion;
        this.resultado = resultado;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void mostrar() {
        System.out.println("Id examen:" + idExamen);
        System.out.println("descripcion:" + descripcion);
        System.out.println("resultado:" + resultado);
    }

    public void leer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del examen: ");
        idExamen = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la descripcion del examen: ");
        descripcion = scanner.nextLine();

        System.out.print("Ingrese el resultado del examen: ");
        resultado = scanner.nextLine();
    }
}
