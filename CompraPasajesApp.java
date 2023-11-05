import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompraPasajesApp extends JFrame {
    private JTextField nombreField, documentoField, fechaField;
    private JCheckBox audifonosCheckBox, mantaCheckBox, revistasCheckBox;
    private JRadioButton primerPisoRadioButton, segundoPisoRadioButton;
    private JComboBox<String> origenComboBox, destinoComboBox;
    private JList<String> calidadServicioList;

    public CompraPasajesApp() {
        setTitle("Compra de Pasajes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 2));

        add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Documento de Identidad:"));
        documentoField = new JTextField();
        add(documentoField);

        add(new JLabel("Fecha de Viaje:"));
        fechaField = new JTextField();
        add(fechaField);

        add(new JLabel("Servicios Opcionales:"));
        audifonosCheckBox = new JCheckBox("Audifonos");
        mantaCheckBox = new JCheckBox("Manta");
        revistasCheckBox = new JCheckBox("Revistas");
        JPanel serviciosPanel = new JPanel(new GridLayout(1, 0));
        serviciosPanel.add(audifonosCheckBox);
        serviciosPanel.add(mantaCheckBox);
        serviciosPanel.add(revistasCheckBox);
        add(serviciosPanel);

        add(new JLabel("Piso:"));
        ButtonGroup pisoGroup = new ButtonGroup();
        primerPisoRadioButton = new JRadioButton("Primer Piso");
        segundoPisoRadioButton = new JRadioButton("Segundo Piso");
        pisoGroup.add(primerPisoRadioButton);
        pisoGroup.add(segundoPisoRadioButton);
        JPanel pisoPanel = new JPanel(new GridLayout(1, 0));
        pisoPanel.add(primerPisoRadioButton);
        pisoPanel.add(segundoPisoRadioButton);
        add(pisoPanel);

        add(new JLabel("Origen:"));
        origenComboBox = new JComboBox<>(new String[]{"Ciudad A", "Ciudad B", "Ciudad C"});
        add(origenComboBox);

        add(new JLabel("Destino:"));
        destinoComboBox = new JComboBox<>(new String[]{"Ciudad X", "Ciudad Y", "Ciudad Z"});
        add(destinoComboBox);

        add(new JLabel("Calidad de Servicio:"));
        calidadServicioList = new JList<>(new String[]{"Economico", "Standard", "VIP"});
        add(new JScrollPane(calidadServicioList));

        JButton resumenButton = new JButton("Mostrar Resumen");
        resumenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarResumen();
            }
        });
        add(resumenButton);
    }

    private void mostrarResumen() {
        String nombre = nombreField.getText();
        String documento = documentoField.getText();
        String fecha = fechaField.getText();
        String servicios = obtenerServiciosOpcionales();
        String piso = obtenerPisoSeleccionado();
        String origen = (String) origenComboBox.getSelectedItem();
        String destino = (String) destinoComboBox.getSelectedItem();
        String calidadServicio = calidadServicioList.getSelectedValue();

        String resumen = "Resumen de Compra:\n" +
                "Nombre: " + nombre + "\n" +
                "Documento de Identidad: " + documento + "\n" +
                "Fecha de Viaje: " + fecha + "\n" +
                "Servicios Opcionales: " + servicios + "\n" +
                "Piso: " + piso + "\n" +
                "Origen: " + origen + "\n" +
                "Destino: " + destino + "\n" +
                "Calidad de Servicio: " + calidadServicio;

        JOptionPane.showMessageDialog(this, resumen, "Resumen de Compra", JOptionPane.INFORMATION_MESSAGE);
    }

    private String obtenerServiciosOpcionales() {
        StringBuilder servicios = new StringBuilder();
        if (audifonosCheckBox.isSelected()) {
            servicios.append("Audifonos, ");
        }
        if (mantaCheckBox.isSelected()) {
            servicios.append("Manta, ");
        }
        if (revistasCheckBox.isSelected()) {
            servicios.append("Revistas, ");
        }
        return servicios.toString().replaceAll(", $", ""); 
    }

    private String obtenerPisoSeleccionado() {
        if (primerPisoRadioButton.isSelected()) {
            return "Primer Piso";
        } else if (segundoPisoRadioButton.isSelected()) {
            return "Segundo Piso";
        }
        return "No especificado";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CompraPasajesApp app = new CompraPasajesApp();
            app.setVisible(true);
        });
    }
}
