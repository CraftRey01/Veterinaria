package veterinariagui;

import com.mycompany.veterinaria.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimalNomMasLargoForm extends JFrame {

    private JTextArea areaResultados;
    private JButton botonBuscar;
    private JButton botonRegresar;

    public AnimalNomMasLargoForm() {
        setTitle("Animal con el Nombre Más Largo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        add(new JScrollPane(areaResultados), BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        botonBuscar = new JButton("Buscar");
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarAnimalConNombreMasLargo();
            }
        });
        panelInferior.add(botonBuscar);

        botonRegresar = new JButton("Volver");
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectionForm().setVisible(true);
                dispose();
            }
        });
        panelInferior.add(botonRegresar);

        add(panelInferior, BorderLayout.SOUTH);
    }

    private void buscarAnimalConNombreMasLargo() {
        areaResultados.setText("");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM animal WHERE LENGTH(nombre) = (SELECT MAX(LENGTH(nombre)) FROM animal)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int idAnimal = resultSet.getInt("idAnimal");
                        String nombre = resultSet.getString("nombre");
                        int genero = resultSet.getInt("genero");
                        String especie = resultSet.getString("especie");

                        areaResultados.append("ID: " + idAnimal + "\n");
                        areaResultados.append("Nombre: " + nombre + "\n");
                        areaResultados.append("Género: " + (genero == 0 ? "Macho" : "Hembra") + "\n");
                        areaResultados.append("Especie: " + especie + "\n");
                    } else {
                        areaResultados.setText("No se encontraron animales en la base de datos.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar animal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AnimalNomMasLargoForm().setVisible(true));
    }
}
