package com.mycompany.veterinaria;

import java.util.Scanner;

public class Tratamiento {

    private int idTratamiento;
    private String inicioTratamiento;
    private String finTratamiento;
    private String servicio;
    private String medicamento;

    public Tratamiento(int idTratamiento, String inicioTratamiento, String finTratamiento, String servicio, String medicamento) {
        this.idTratamiento = idTratamiento;
        this.inicioTratamiento = inicioTratamiento;
        this.finTratamiento = finTratamiento;
        this.servicio = servicio;
        this.medicamento = medicamento;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getInicioTratamiento() {
        return inicioTratamiento;
    }

    public void setInicioTratamiento(String inicioTratamiento) {
        this.inicioTratamiento = inicioTratamiento;
    }

    public String getFinTratamiento() {
        return finTratamiento;
    }

    public void setFinTratamiento(String finTratamiento) {
        this.finTratamiento = finTratamiento;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public void leer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el inicio del tratamiento: ");
        this.inicioTratamiento = scanner.nextLine();

        System.out.print("Ingrese el fin del tratamiento: ");
        this.finTratamiento = scanner.nextLine();

        System.out.print("Ingrese el servicio: ");
        this.servicio = scanner.nextLine();

        System.out.print("Ingrese el medicamento: ");
        this.medicamento = scanner.nextLine();
    }

    public void mostrar() {
        System.out.println("Inicio del tratamiento: " + inicioTratamiento);
        System.out.println("Fin del tratamiento: " + finTratamiento);
        System.out.println("Servicio: " + servicio);
        System.out.println("Medicamento: " + medicamento);
    }

    // Parte 3
    // 6) realizar un nuevo tratamiento
    public void iniciarTratamiento(String inicio, String fin, String servicio, String medicamento) {
        setInicioTratamiento(inicio);
        setFinTratamiento(fin);
        setServicio(servicio);
        setMedicamento(medicamento);

        System.out.println("Nuevo tratamiento configurado:");
        System.out.println("Inicio: " + getInicioTratamiento());
        System.out.println("Fin: " + getFinTratamiento());
        System.out.println("Servicio: " + getServicio());
        System.out.println("Medicamento: " + getMedicamento());
    }

    // 7) Verificar si el tratamiento requiere un examen
    public boolean requiereExamen() {
        return getServicio().equalsIgnoreCase("Consulta Especializada");
    }
}
