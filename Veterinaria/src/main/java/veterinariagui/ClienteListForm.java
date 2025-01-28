package veterinariagui;

import com.mycompany.veterinaria.Cliente;
import com.mycompany.veterinaria.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteListForm extends JFrame {

    private JList<String> ClienteList;
    private DefaultListModel<String> listModel;
    private JButton botonRegresar;

    public ClienteListForm() {
        setTitle("Listado de Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        ClienteList = new JList<>(listModel);
        add(new JScrollPane(ClienteList), BorderLayout.CENTER);

        botonRegresar = new JButton("Volver");
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectionForm().setVisible(true);
                dispose();
            }
        });
        add(botonRegresar, BorderLayout.SOUTH);

        loadClientes();

    }

    private void loadClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT idCliente, nombre, telefono FROM cliente";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int idCliente = resultSet.getInt("idCliente");
                    String nombre = resultSet.getString("nombre");
                    String telefono = resultSet.getString("telefono");
                    Cliente cliente = new Cliente(idCliente, nombre, telefono);
                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Cliente cliente : clientes) {
            listModel.addElement(cliente.getIdCliente() + " | " + cliente.getNombre() + " | " + cliente.getTelefono());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteListForm().setVisible(true);
            }
        });
    }
}
