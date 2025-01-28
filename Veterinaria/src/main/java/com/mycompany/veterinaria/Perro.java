package com.mycompany.veterinaria;

public class Perro extends Animal {

    private String raza;
    private String tamaño;

    public Perro(String nombre, int idAnimal, int genero, String especie, String raza, String tamaño) {
        super(idAnimal, nombre, genero, especie);
        this.raza = raza;
        this.tamaño = tamaño;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
}
