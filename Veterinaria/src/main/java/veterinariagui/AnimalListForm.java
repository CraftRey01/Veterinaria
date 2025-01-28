package veterinariagui;

import com.mycompany.veterinaria.Animal;
import com.mycompany.veterinaria.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalListForm extends JFrame {

    private JList<String> animalList;
    private DefaultListModel<String> listModel;
    private JButton botonRegresar;

    public AnimalListForm() {
        setTitle("Listado de Animales");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        animalList = new JList<>(listModel);
        add(new JScrollPane(animalList), BorderLayout.CENTER);

        botonRegresar = new JButton("Volver");
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectionForm().setVisible(true);
                dispose();
            }
        });
        add(botonRegresar, BorderLayout.SOUTH);

        loadAnimals();
    }

    private void loadAnimals() {
        List<Animal> animals = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT idAnimal, nombre, genero, especie, id_cliente FROM animal";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int idAnimal = resultSet.getInt("idAnimal");
                    String nombre = resultSet.getString("nombre");
                    int genero = resultSet.getInt("genero");
                    String especie = resultSet.getString("especie");
                    int idCliente = resultSet.getInt("id_cliente");

                    Animal animal = new Animal(idAnimal, nombre, genero, especie);
                    animals.add(animal);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener animales: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Animal animal : animals) {
            listModel.addElement(animal.getIdAnimal() + " | " + animal.getNombre() + " | " + (animal.getGenero() == 1 ? "Macho" : "Hembra") + " | " + animal.getEspecie());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AnimalListForm().setVisible(true);
            }
        });
    }
}
