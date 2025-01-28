package veterinariagui;

import com.mycompany.veterinaria.Consulta;
import com.mycompany.veterinaria.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaForm extends JFrame {

    private JTextField campoIdConsulta;
    private JTextField campoDatoConsulta;
    private JTextField campoPrecio;
    private JTextField campoRelatoConsulta;
    private JButton botonGuardar;
    private JButton botonRegresar;
    private Consulta consulta;

    public ConsultaForm(Consulta consulta) {
        this.consulta = consulta;
        setTitle("Registro Consulta");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("ID Consulta:"));
        campoIdConsulta = new JTextField(consulta != null ? String.valueOf(consulta.getIdConsulta()) : "");
        add(campoIdConsulta);

        add(new JLabel("Dato Consulta:"));
        campoDatoConsulta = new JTextField(consulta != null ? consulta.getDatoConsulta() : "");
        add(campoDatoConsulta);

        add(new JLabel("Precio:"));
        campoPrecio = new JTextField(consulta != null ? String.valueOf(consulta.getPrecio()) : "");
        add(campoPrecio);

        add(new JLabel("Relato Consulta:"));
        campoRelatoConsulta = new JTextField(consulta != null ? consulta.getRelatoConsulta() : "");
        add(campoRelatoConsulta);

        add(new JLabel("ID Animal:"));
        campoIdConsulta = new JTextField(consulta != null ? String.valueOf(consulta.getIdConsulta()) : "");
        add(campoIdConsulta);

        botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveConsulta();
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

    private void saveConsulta() {
        int idConsulta = Integer.parseInt(campoIdConsulta.getText());
        String datoConsulta = campoDatoConsulta.getText();
        double precio = Double.parseDouble(campoPrecio.getText());
        String relatoConsulta = campoRelatoConsulta.getText();

        if (consulta == null) {
            consulta = new Consulta(idConsulta, datoConsulta, precio, relatoConsulta);
        } else {
            consulta.setIdConsulta(idConsulta);
            consulta.setDatoConsulta(datoConsulta);
            consulta.setPrecio(precio);
            consulta.setRelatoConsulta(relatoConsulta);
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO consulta (idConsulta, dato_consulta, precio, relato_consulta, id_animal ) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, consulta.getIdConsulta());
                statement.setString(2, consulta.getDatoConsulta());
                statement.setDouble(3, consulta.getPrecio());
                statement.setString(4, consulta.getRelatoConsulta());
                statement.setInt(5, consulta.getIdConsulta());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar consulta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Consulta guardada correctamente!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConsultaForm(null).setVisible(true);
            }
        });
    }
}
