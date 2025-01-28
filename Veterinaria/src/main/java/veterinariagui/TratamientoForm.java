package veterinariagui;

import com.mycompany.veterinaria.Tratamiento;
import com.mycompany.veterinaria.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TratamientoForm extends JFrame {

    private JTextField campoIdTratamiento;
    private JTextField campoInicioTratamiento;
    private JTextField campoFinTratamiento;
    private JTextField campoServicio;
    private JTextField campoMedicamento;
    private JButton botonGuardar;
    private JButton botonRegresar;
    private Tratamiento tratamiento;

    public TratamientoForm(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
        setTitle("Registro Tratamiento");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        add(new JLabel("ID Tratamiento:"));
        campoIdTratamiento = new JTextField(tratamiento != null ? String.valueOf(tratamiento.getIdTratamiento()) : "");
        add(campoIdTratamiento);

        add(new JLabel("Inicio Tratamiento:"));
        campoInicioTratamiento = new JTextField(tratamiento != null ? tratamiento.getInicioTratamiento() : "");
        add(campoInicioTratamiento);

        add(new JLabel("Fin Tratamiento:"));
        campoFinTratamiento = new JTextField(tratamiento != null ? tratamiento.getFinTratamiento() : "");
        add(campoFinTratamiento);

        add(new JLabel("Servicio:"));
        campoServicio = new JTextField(tratamiento != null ? tratamiento.getServicio() : "");
        add(campoServicio);

        add(new JLabel("Medicamento:"));
        campoMedicamento = new JTextField(tratamiento != null ? tratamiento.getMedicamento() : "");
        add(campoMedicamento);
        
        add(new JLabel("ID Animal:"));
        campoIdTratamiento = new JTextField(tratamiento != null ? String.valueOf(tratamiento.getIdTratamiento()) : "");
        add(campoIdTratamiento);

        botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTratamiento();
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

    private void saveTratamiento() {
        int idTratamiento = Integer.parseInt(campoIdTratamiento.getText());
        String inicioTratamiento = campoInicioTratamiento.getText();
        String finTratamiento = campoFinTratamiento.getText();
        String servicio = campoServicio.getText();
        String medicamento = campoMedicamento.getText();

        if (tratamiento == null) {
            tratamiento = new Tratamiento(idTratamiento, inicioTratamiento, finTratamiento, servicio, medicamento);
        } else {
            tratamiento.setIdTratamiento(idTratamiento);
            tratamiento.setInicioTratamiento(inicioTratamiento);
            tratamiento.setFinTratamiento(finTratamiento);
            tratamiento.setServicio(servicio);
            tratamiento.setMedicamento(medicamento);
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO tratamiento (idTratamiento, inicio_tratamiento, fin_tratamiento, servicio, medicamento, id_animal) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, tratamiento.getIdTratamiento());
                statement.setString(2, tratamiento.getInicioTratamiento());
                statement.setString(3, tratamiento.getFinTratamiento());
                statement.setString(4, tratamiento.getServicio());
                statement.setString(5, tratamiento.getMedicamento());
                statement.setInt(6, tratamiento.getIdTratamiento());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar tratamiento: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Tratamiento guardado correctamente!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TratamientoForm(null).setVisible(true);
            }
        });
    }
}
