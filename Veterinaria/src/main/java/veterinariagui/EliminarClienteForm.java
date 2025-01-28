package veterinariagui;

import com.mycompany.veterinaria.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarClienteForm extends JFrame {

    private JTextField campoIdCliente;
    private JButton botonEliminar;
    private JButton botonRegresar;

    public EliminarClienteForm() {
        setTitle("Eliminar Cliente");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("ID Cliente:"));
        campoIdCliente = new JTextField();
        add(campoIdCliente);

        botonEliminar = new JButton("Eliminar");
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarCliente();
            }
        });
        add(botonEliminar);

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

    private void eliminarCliente() {
        int idCliente = Integer.parseInt(campoIdCliente.getText());

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM cliente WHERE idCliente = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idCliente);
                int filasAfectadas = statement.executeUpdate();

                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente!");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró un cliente con ese ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EliminarClienteForm().setVisible(true));
    }
}
