package veterinariagui;

import com.mycompany.veterinaria.Perro;
import com.mycompany.veterinaria.Tratamiento;
import com.mycompany.veterinaria.Examen;
import com.mycompany.veterinaria.Animal;
import com.mycompany.veterinaria.DocVeterinario;
import com.mycompany.veterinaria.Veterinaria;
import com.mycompany.veterinaria.Consulta;
import com.mycompany.veterinaria.Cliente;
import com.mycompany.veterinaria.Gato;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionForm extends JFrame {

    private DefaultListModel<String> listModel;

    public SelectionForm() {
        setTitle("Veterinaria");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        /////////////////////////////////////////////////////////////////
        //                      INICIALIZACION DE DATOS
        /////////////////////////////////////////////////////////////////
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

        /////////////////////////////////////////////////////////////////
        //                      AGREGAR Y LISTAR
        /////////////////////////////////////////////////////////////////
        JButton ClienteButton = new JButton("Agregar Cliente");
        ClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClienteForm(null).setVisible(true);
                dispose();
            }
        });
        add(ClienteButton);

        JButton listClientesButton = new JButton("Listar Clientes");
        listClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClienteListForm().setVisible(true);
                dispose();
            }
        });
        add(listClientesButton);

        JButton animalButton = new JButton("Agregar Animal");
        animalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AnimalForm(null).setVisible(true);
                dispose();
            }
        });
        add(animalButton);

        JButton listAnimalesButton = new JButton("Listar Animales");
        listAnimalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AnimalListForm().setVisible(true);
                dispose();
            }
        });
        add(listAnimalesButton);

        JButton ConsultaButton = new JButton("Agregar Consulta");
        ConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultaForm(null).setVisible(true);
                dispose();
            }
        });
        add(ConsultaButton);

        JButton tratamientoButton = new JButton("Agregar Tratamiento");
        tratamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TratamientoForm(null).setVisible(true);
                dispose();
            }
        });
        add(tratamientoButton);

        /////////////////////////////////////////////////////////////////
        //                      EJERCICIOS
        /////////////////////////////////////////////////////////////////
        // 1) Encontrar a el animal con el nombre más largo
        JButton nomMasLargoAnimalButton = new JButton("1) Animal Con Nombre mas largo");
        nomMasLargoAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AnimalNomMasLargoForm().setVisible(true);
                dispose();
            }
        });
        add(nomMasLargoAnimalButton);

        // 2) Buscar a el animal con el nombre 'x'
        JButton buscarAnimalButton = new JButton("2) Buscar Animal por nombre");
        buscarAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BuscarAnimalForm().setVisible(true);
                dispose();
            }
        });
        add(buscarAnimalButton);

        // 3) eliminar cliente por id 
        JButton EliminarClienteButton = new JButton("3) Eliminar Cliente con ID X");
        EliminarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EliminarClienteForm().setVisible(true);
                dispose();
            }
        });
        add(EliminarClienteButton);

        // 4) Buscar un cliente por id
        JButton buscarClienteButton = new JButton("4) Buscar Cliente por ID");
        buscarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idClienteStr = JOptionPane.showInputDialog("Ingrese el ID del cliente:");
                if (idClienteStr != null) {
                    int idCliente = Integer.parseInt(idClienteStr);
                    Cliente cliente = veterinaria.buscarClientePorId(idCliente);
                    if (cliente != null) {
                        JOptionPane.showMessageDialog(null, "Cliente encontrado:\n"
                                + "Nombre: " + cliente.getNombre() + "\n"
                                + "Teléfono: " + cliente.getTelefono());
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                    }
                }
            }
        });
        add(buscarClienteButton);

        // 5) modoficar Telefono del Cliente
        JButton modificarTelefonoButton = new JButton("5) Modificar Teléfono del Cliente X");
        modificarTelefonoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente:"));
                String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo teléfono:");
                veterinaria.actualizarTelefonoCliente(idCliente, nuevoTelefono);
                Cliente cliente = veterinaria.buscarClientePorId(idCliente);
                if (cliente != null) {
                    JOptionPane.showMessageDialog(null, "Telefono Actualizado:\n"
                            + "Nombre: " + cliente.getNombre() + "\n"
                            + "Teléfono: " + cliente.getTelefono());
                }
            }
        });
        add(modificarTelefonoButton);

        // 6) realizar un nuevo tratamiento
        JButton nuevoTratamientoButton = new JButton("6) Realizar Nuevo Tratamiento");
        nuevoTratamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField inicioField = new JTextField();
                JTextField finField = new JTextField();
                JTextField servicioField = new JTextField();
                JTextField medicamentoField = new JTextField();

                Object[] message = {
                    "Inicio del Tratamiento:", inicioField,
                    "Fin del Tratamiento:", finField,
                    "Servicio:", servicioField,
                    "Medicamento:", medicamentoField
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Registrar Nuevo Tratamiento", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String inicio = inicioField.getText();
                    String fin = finField.getText();
                    String servicio = servicioField.getText();
                    String medicamento = medicamentoField.getText();

                    Tratamiento tratamiento = new Tratamiento(0, inicio, fin, servicio, medicamento);
                    JOptionPane.showMessageDialog(null, "Tratamiento registrado:\n"
                            + "Inicio: " + tratamiento.getInicioTratamiento() + "\n"
                            + "Fin: " + tratamiento.getFinTratamiento() + "\n"
                            + "Servicio: " + tratamiento.getServicio() + "\n"
                            + "Medicamento: " + tratamiento.getMedicamento());
                }
            }
        });
        add(nuevoTratamientoButton);

        // 7) Verificar si el tratamiento requiere un examen
        JButton verificarExamenButton = new JButton("7) Verificar si Tratamiento Requiere Examen");
        verificarExamenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tratamiento tratamiento = new Tratamiento(2, "2025-03-01", "2025-03-10", "Consulta Especializada", "Analgésicos");
                boolean requiereExamen = tratamiento.requiereExamen();
                JOptionPane.showMessageDialog(null, "¿Requiere examen? " + (requiereExamen ? "Sí" : "No"));
            }
        });
        add(verificarExamenButton);

        // 8) Lee por teclado nueva información y muestra la nueva información del veterinario 
        JButton actualizarVeterinarioButton = new JButton("8) Actualizar Información del Veterinario");
        actualizarVeterinarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField nombreField = new JTextField();
                JTextField telefonoField = new JTextField();
                JTextField especialidadField = new JTextField();

                Object[] message = {
                    "Nombre del Veterinario:", nombreField,
                    "Teléfono:", telefonoField,
                    "Especialidad:", especialidadField
                };
                int option = JOptionPane.showConfirmDialog(null, message, "Actualizar Información del Veterinario", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String nombre = nombreField.getText();
                    String telefono = telefonoField.getText();
                    String especialidad = especialidadField.getText();

                    DocVeterinario veterinario = new DocVeterinario(nombre, telefono, especialidad);
                    JOptionPane.showMessageDialog(null, "Veterinario actualizado:\n"
                            + "Nombre: " + veterinario.getNombre() + "\n"
                            + "Teléfono: " + veterinario.getTelefono() + "\n"
                            + "Especialidad: " + veterinario.getEspecialidad());
                }
            }
        });
        add(actualizarVeterinarioButton);

        // 9) Da un nuevo precio con x % descuento.
        JButton aplicarDescuentoButton = new JButton("9) Aplicar Descuento a Consulta");
        aplicarDescuentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idConsultaStr = JOptionPane.showInputDialog("Ingrese el ID de la consulta:");
                if (idConsultaStr != null) {
                    int idConsulta = Integer.parseInt(idConsultaStr);
                    String porcentajeStr = JOptionPane.showInputDialog("Ingrese el porcentaje de descuento:");
                    double descuento = Double.parseDouble(porcentajeStr);
                    int sw = 0;
                    for (Cliente cliente : veterinaria.getClientes()) {
                        for (Animal animal : cliente.getAnimales()) {
                            for (Consulta consulta : animal.getConsultas()) {
                                if (consulta.getIdConsulta() == idConsulta) {
                                    sw = 1;
                                    break;
                                }
                            }
                        }
                    }

                    if (sw != 0) {
                        double precioConDescuento = consulta.calcularDescuento(descuento);
                        JOptionPane.showMessageDialog(null, "Precio original: " + consulta.getPrecio() + "\n"
                                + "Precio con descuento: " + precioConDescuento);
                    } else {
                        JOptionPane.showMessageDialog(null, "Consulta con ID " + idConsulta + " no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        add(aplicarDescuentoButton);

//        // 10) Registrar mas de un animal en un cliente
//        JButton registrarAnimalesButton = new JButton("Registrar Más de un Animal a Cliente");
//        registrarAnimalesButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Perro perro2 = new Perro("Max", 101, 1, "Canino", "Labrador", "Grande");
//                Gato gato2 = new Gato("Luna", 102, 2, "Felino", "Blanco", 4.5);
//
//                List<Animal> nuevosAnimales = new ArrayList<>();
//                nuevosAnimales.add(gato);
//                nuevosAnimales.add(gato2);
//                nuevosAnimales.add(perro2);
//                veterinaria.getClientes().get(0).agregarAnimales(nuevosAnimales);
//                JOptionPane.showMessageDialog(null, "Animales registrados para el cliente " + veterinaria.getClientes().get(0).getNombre());
//            }
//        });
//        add(registrarAnimalesButton);
        // 11) verificar si un animal esta registrado 
        JButton verificarAnimalButton = new JButton("10) Verificar si Animal Está Registrado");
        verificarAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreAnimal = JOptionPane.showInputDialog("Ingrese el nombre del animal:");
                boolean existe = veterinaria.getClientes().get(0).verificarAnimal(nombreAnimal);
                JOptionPane.showMessageDialog(null, "¿Está registrado el animal? " + (existe ? "Sí" : "No"));
            }
        });
        add(verificarAnimalButton);

//        // 12) mostrar resumen del cliente
//        JButton mostrarResumenButton = new JButton("Mostrar Resumen del Cliente");
//        mostrarResumenButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String idClienteStr = JOptionPane.showInputDialog("Ingrese el ID del cliente para ver el resumen:");
//                if (idClienteStr != null) {
//                    int idCliente = Integer.parseInt(idClienteStr);
//                    veterinaria.getClientes().get(idCliente).mostrarResumenCompleto();
//                    listModel.addElement(cliente.getIdCliente() + " | " + cliente.getNombre() + " | " + cliente.getTelefono());
//                } else {
//                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
//                }
//            }
//        });
//        add(mostrarResumenButton);
    }
}
