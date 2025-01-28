package com.mycompany.veterinaria;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crear una veterinaria
        System.out.println("---------VETERINARIA--------");
        Veterinaria veterinaria = new Veterinaria(1, "Veterinaria Central", "Calle Principal 123", "555-1234");
        veterinaria.mostrarVeterinaria();

        //Crear clientes
        Cliente cliente = new Cliente(1, "Juan Perez", "48541521");
        Cliente cliente2 = new Cliente(2, "Maria Gomez", "98765432");
        Cliente cliente3 = new Cliente(3, "Carlos Lopez", "45612378");
        Cliente cliente4 = new Cliente(4, "Luisa Fernandez", "53790524");
        veterinaria.registrarCliente(cliente);
        veterinaria.registrarCliente(cliente2);
        veterinaria.registrarCliente(cliente3);
        veterinaria.registrarCliente(cliente4);

        System.out.println("\n------------Clientes de la Veterinaria---------------");
        veterinaria.mostrarClientes();

        // Crear animales
        System.out.println("\n-------------Animales de la Veterinaria--------------");
        Perro perro = new Perro("Max", 101, 1, "Canino", "Labrador", "Grande");
        Gato gato = new Gato("Luna", 102, 2, "Felino", "Blanco", 4.5);
        Animal elefante = new Animal(103, "Elefante", 1, "Elefante");
        Animal conejo = new Animal(104, "Nina", 2, "Conejo");
        cliente.registrarAnimal(perro);
        cliente2.registrarAnimal(gato);
        cliente3.registrarAnimal(elefante);
        cliente4.registrarAnimal(conejo);

        // Crear un veterinario
        System.out.println("\n-----------Veterinarios------------");
        DocVeterinario veterinario = new DocVeterinario("Dra. Martinez", "555-9876", "Cirugía");
        DocVeterinario veterinario2 = new DocVeterinario("Dr. Edwin Ramos", "12345678", "Dermatología");
        veterinario.mostrar();

        // Crear una consulta
        System.out.println("\n-------------Consultas de la Veterinaria--------------");
        Consulta consulta = new Consulta(1, "Chequeo general", 50.0, "El animal está saludable.");
        perro.agregarConsulta(consulta);

        Consulta consulta2 = new Consulta(2, "Consulta General", 75.0, "El paciente presenta síntomas de resfriado.");
        gato.agregarConsulta(consulta2);

        Consulta consulta3 = new Consulta(3, "Chequeo anual", 40.0, "Chequeo completo, todo en orden.");
        elefante.agregarConsulta(consulta3);

        Consulta consulta4 = new Consulta(4, "Consulta general", 50.0, "El conejo presenta signos de estrés.");
        conejo.agregarConsulta(consulta4);

        // Crear un tratamiento
        System.out.println("\n----------------------Tratamientos--------------");
        Tratamiento tratamiento = new Tratamiento(1, "2025-01-01", "2025-01-10", "Vacunación", "Vacuna Rabia");
        perro.setTratamiento(tratamiento);
        System.out.println("Tratamiento asignado al perro: " + tratamiento.getServicio());
        tratamiento.mostrar();

        Tratamiento tratamiento2 = new Tratamiento(2, "2025-01-15", "2025-01-20", "tratamiednto", "paracetamol");
        gato.setTratamiento(tratamiento2);
        System.out.println("Tratamiento asignado al gato: " + tratamiento2.getServicio());
        tratamiento2.mostrar();

        Tratamiento tratamiento3 = new Tratamiento(3, "2025-02-01", "2025-02-15", "Consulta General", "Antibioticos");
        elefante.setTratamiento(tratamiento3);
        System.out.println("Tratamiento asignado al elefante: " + tratamiento3.getServicio());
        tratamiento3.mostrar();

        Tratamiento tratamiento4 = new Tratamiento(4, "2025-03-01", "2025-03-10", "Antiestrés", "Sedante natural");
        conejo.setTratamiento(tratamiento4);
        System.out.println("Tratamiento asignado al conejo: " + tratamiento4.getServicio());
        tratamiento4.mostrar();

        System.out.println("Examenes: ");
        Examen e = new Examen(123, "consulta", "bien");
        e.mostrar();
        System.out.println("\n--------------------------------------------");

        // 1) Encontrar a el animal con el nombre más largo
        System.out.println("\n1) ENCONTRAR AL ANIMAL CON EL NOMBRE MAS LARGO.");
        Animal[] animales = {perro, gato, elefante, conejo};
        Animal aNomMasLargo = ComparadorGenerico.mayorPorLongitud(animales);
        System.out.println("El nombre más largo es: " + aNomMasLargo.getNombre());

        // 2) Buscar a el animal con el nombre 'x' y preguntar si requiere alguna modificación
        System.out.println("\n2) Hallar al animal con nombre 'X' y preguntar si requiere alguna modificacion");
        cliente2.buscarYModificarAnimal("Luna");

        // 3) eliminar cliente por id 
        System.out.println("\n3) Eliminar cliente por id ");
        veterinaria.eliminarClientePorId(3);
        veterinaria.mostrarClientes();

        // 4) Buscar un cliente por id
        System.out.println("\n4) Buscar un cliente por id");
        veterinaria.buscarClientePorId(4);

        // 5) Modificar Telefono del Cliente
        System.out.println("\n5) Modoficar telefono del Cliente");
        veterinaria.actualizarTelefonoCliente(2, "123456");
        veterinaria.mostrarClientes();

        // 6) Realizar un nuevo tratamiento
        System.out.println("\n6) Realizar un nuevo tratamiento");
        tratamiento3.iniciarTratamiento("2025-03-01", "2025-03-10", "Consulta Especializada", "Analgesicos");

        // 7) Verificar si el tratamiento requiere un examen
        System.out.println("\n7) Verificar si el tratamiento requiere un examen");
        if (tratamiento3.requiereExamen()) {
            System.out.println("El tratamiento requiere un examen.");
        } else {
            System.out.println("El tratamiento no requiere un examen.");
        }

        // 8) Lee por teclado nueva información y muestra la nueva información del veterinario 
        System.out.println("\n8) Lee por teclado nueva información y muestra la nueva información del veterinario ");
        System.out.println("Información inicial del veterinario:");
        veterinario2.mostrar();
        System.out.println("Ingrese nueva información del veterinario:");
        veterinario2.leer();
        System.out.println("Información actualizada del veterinario:");
        veterinario2.mostrar();

        // 9) Da un nuevo precio con x % descuento
        System.out.println("\n9) Da nuevo precio con x % descuento");
        double nuevoPrecio = consulta.calcularDescuento(20);
        System.out.println("Precio con descuento: " + nuevoPrecio);

        // 10) Registrar mas de un animal en un cliente
        System.out.println("\n10) Registrar mas de un animal en un cliente");
        Perro perro2 = new Perro("Rocky", 103, 1, "Canino", "Pitbull", "Mediano");
        Gato gato2 = new Gato("Mia", 104, 2, "Felino", "Gris", 3.2);

        List<Animal> animalesCliente1 = new ArrayList<>();
        animalesCliente1.add(gato);
        animalesCliente1.add(gato2);
        animalesCliente1.add(perro2);

        cliente.agregarAnimales(animalesCliente1);

        // 11) verificar si un animal esta registrado 
        System.out.println("\n11) Verificar si un animal esta registrado ");
        String nombreAnimalABuscar = "Julio";
        boolean existeAnimal1 = cliente.verificarAnimal(nombreAnimalABuscar);
        System.out.println("El cliente " + cliente.getNombre() + " tiene un animal llamado " + nombreAnimalABuscar + "? \n" + (existeAnimal1 ? "Sí" : "No"));

        // 12) mostrar resumen del cliente
        System.out.println("\n12) Mostrar resumen del cliente");
        cliente.mostrarResumenCompleto();
    }
}
