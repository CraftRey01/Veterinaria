package veterinariagui;

import com.mycompany.veterinaria.Cliente;
import com.mycompany.veterinaria.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteForm extends JFrame {

    private JTextField campoIdCliente;
    private JTextField campoNombre;
    private JTextField campoTelefono;
    private JButton botonGuardar;
    private JButton botonRegresar;
    private Cliente cliente;

    public ClienteForm(Cliente cliente) {
        this.cliente = cliente;
        setTitle("Registro Cliente");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("ID Cliente:"));
        campoIdCliente = new JTextField(cliente != null ? String.valueOf(cliente.getIdCliente()) : "");
        add(campoIdCliente);

        add(new JLabel("Nombre:"));
        campoNombre = new JTextField(cliente != null ? cliente.getNombre() : "");
        add(campoNombre);

        add(new JLabel("Teléfono:"));
        campoTelefono = new JTextField(cliente != null ? cliente.getTelefono() : "");
        add(campoTelefono);

        botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCliente();
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

    private void saveCliente() {
        int idCliente = Integer.parseInt(campoIdCliente.getText());
        String nombre = campoNombre.getText();
        String telefono = campoTelefono.getText();

        if (cliente == null) {
            cliente = new Cliente(idCliente, nombre, telefono);
        } else {
            cliente.setIdCliente(idCliente);
            cliente.setNombre(nombre);
            cliente.setTelefono(telefono);
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO cliente (idCliente, nombre, telefono) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, cliente.getIdCliente());
                statement.setString(2, cliente.getNombre());
                statement.setString(3, cliente.getTelefono());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Cliente guardado correctamente!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteForm(null).setVisible(true);
            }
        });
    }
}
