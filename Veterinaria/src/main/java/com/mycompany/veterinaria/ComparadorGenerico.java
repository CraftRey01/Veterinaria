package com.mycompany.veterinaria;

//Parte 1
// 1) Encontrar a el animal con el nombre más largo
public class ComparadorGenerico {

    public static <T extends Animal> T mayorPorLongitud(T... animales) {
        if (animales == null || animales.length == 0) {
            throw new IllegalArgumentException("Debe proporcionarse al menos un animal.");
        }
        T mayor = animales[0];
        for (int i = 1; i < animales.length; i++) {
            if (animales[i].getNombre().length() > mayor.getNombre().length()) {
                mayor = animales[i];
            }
        }
        return mayor;
    }
}
