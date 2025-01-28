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

public class BuscarAnimalForm extends JFrame {

    private JTextField campoNombre;
    private JTextArea areaResultados;
    private JButton botonBuscar;
    private JButton botonRegresar;

    public BuscarAnimalForm() {
        setTitle("Buscar Animal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new GridLayout(2, 2));
        panelSuperior.add(new JLabel("Nombre del Animal:"));
        campoNombre = new JTextField();
        panelSuperior.add(campoNombre);
        add(panelSuperior, BorderLayout.NORTH);

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        add(new JScrollPane(areaResultados), BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        botonBuscar = new JButton("Buscar");
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarAnimalPorNombre();
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

    private void buscarAnimalPorNombre() {
        String nombreBuscado = campoNombre.getText().trim();
        areaResultados.setText("");

        if (nombreBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM animal WHERE nombre LIKE ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "%" + nombreBuscado + "%");

                try (ResultSet resultSet = statement.executeQuery()) {
                    boolean encontrado = false;
                    while (resultSet.next()) {
                        encontrado = true;
                        int idAnimal = resultSet.getInt("idAnimal");
                        String nombre = resultSet.getString("nombre");
                        int genero = resultSet.getInt("genero");
                        String especie = resultSet.getString("especie");

                        areaResultados.append("ID: " + idAnimal + "\n");
                        areaResultados.append("Nombre: " + nombre + "\n");
                        areaResultados.append("Género: " + (genero == 0 ? "Macho" : "Hembra") + "\n");
                        areaResultados.append("Especie: " + especie + "\n\n");
                    }

                    if (!encontrado) {
                        areaResultados.setText("No se encontraron animales con el nombre especificado.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar animal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BuscarAnimalForm().setVisible(true));
    }
}
