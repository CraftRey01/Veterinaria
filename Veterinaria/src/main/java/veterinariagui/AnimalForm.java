package veterinariagui;

import com.mycompany.veterinaria.Animal;
import com.mycompany.veterinaria.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnimalForm extends JFrame {

    private JTextField campoIdAnimal;
    private JTextField campoNombre;
    private JTextField campoGenero;
    private JTextField campoEspecie;
    private JButton botonGuardar;
    private JButton botonRegresar;
    private Animal animal;

    public AnimalForm(Animal animal) {
        this.animal = animal;
        setTitle("Registro Animal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("ID Animal:"));
        campoIdAnimal = new JTextField(animal != null ? String.valueOf(animal.getIdAnimal()) : "");
        add(campoIdAnimal);

        add(new JLabel("Nombre:"));
        campoNombre = new JTextField(animal != null ? animal.getNombre() : "");
        add(campoNombre);

        add(new JLabel("Genero (1=Macho, 2=Hembra):"));
        campoGenero = new JTextField(animal != null ? String.valueOf(animal.getGenero()) : "");
        add(campoGenero);

        add(new JLabel("Especie:"));
        campoEspecie = new JTextField(animal != null ? animal.getEspecie() : "");
        add(campoEspecie);

        botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAnimal();
            }
        });
        add(botonGuardar);

        botonRegresar = new JButton("Volver");
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectionForm().setVisible(true);
                dispose();
            }
        });
        add(botonRegresar);
    }

    private void saveAnimal() {
        int idAnimal = Integer.parseInt(campoIdAnimal.getText());
        String nombre = campoNombre.getText();
        int genero = Integer.parseInt(campoGenero.getText());
        String especie = campoEspecie.getText();

        if (animal == null) {
            animal = new Animal(idAnimal, nombre, genero, especie);
        } else {
            animal.setIdAnimal(idAnimal);
            animal.setNombre(nombre);
            animal.setGenero(genero);
            animal.setEspecie(especie);
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO animal (idAnimal, nombre, genero, especie) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, animal.getIdAnimal());
                statement.setString(2, animal.getNombre());
                statement.setInt(3, animal.getGenero());
                statement.setString(4, animal.getEspecie());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar animal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Animal guardado correctamente!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AnimalForm(null).setVisible(true);
            }
        });
    }
}
