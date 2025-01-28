package com.mycompany.veterinaria;

public class Gato extends Animal {

    private String color;
    private double peso;

    public Gato(String nombre, int idAnimal, int genero, String especie, String color, double peso) {
        super(idAnimal, nombre, genero, especie);
        this.color = color;
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
