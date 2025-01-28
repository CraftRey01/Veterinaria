package com.mycompany.veterinaria;

public class Consulta {

    private int idConsulta;
    private String datoConsulta;
    private double precio;
    private String relatoConsulta;

    public Consulta(int idConsulta, String datoConsulta, double precio, String relatoConsulta) {
        this.idConsulta = idConsulta;
        this.datoConsulta = datoConsulta;
        this.precio = precio;
        this.relatoConsulta = relatoConsulta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getDatoConsulta() {
        return datoConsulta;
    }

    public void setDatoConsulta(String datoConsulta) {
        this.datoConsulta = datoConsulta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getRelatoConsulta() {
        return relatoConsulta;
    }

    public void setRelatoConsulta(String relatoConsulta) {
        this.relatoConsulta = relatoConsulta;
    }

    // Parte 4
    //*muestra informacion de la consulta*//
    public void mostrarInformacion() {
        System.out.println("ID Consulta: " + idConsulta);
        System.out.println("Dato de Consulta: " + datoConsulta);
        System.out.println("Precio: " + precio);
        System.out.println("Relato de la Consulta: " + relatoConsulta);
    }

    // 9) da nuevo precio con x % descuento
    public double calcularDescuento(double PorcentajeDescuento) {
        double descuento = (precio * PorcentajeDescuento) / 100;
        return precio - descuento;
    }
}
