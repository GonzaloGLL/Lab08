import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComponentesGUI extends JFrame {
    public ComponentesGUI() {
        setTitle("Ejemplo de Componentes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton botonComando = new JButton("Boton de Comando");
        botonComando.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Has presionado el Boton de Comando");
            }
        });
        panel.add(botonComando);

        JCheckBox casillaVerificacion = new JCheckBox("Casilla de Verificacion");
        panel.add(casillaVerificacion);

        ButtonGroup grupoBotones = new ButtonGroup();
        JRadioButton opcion1 = new JRadioButton("Opcion 1");
        JRadioButton opcion2 = new JRadioButton("Opcion 2");
        grupoBotones.add(opcion1);
        grupoBotones.add(opcion2);
        panel.add(opcion1);
        panel.add(opcion2);

        
        String[] opcionesCombo = {"Opcion 1", "Opcion 2", "Opcion 3"};
        JComboBox<String> cuadroCombinado = new JComboBox<>(opcionesCombo);
        panel.add(cuadroCombinado);

        
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        modeloLista.addElement("Elemento 1");
        modeloLista.addElement("Elemento 2");
        modeloLista.addElement("Elemento 3");
        JList<String> lista = new JList<>(modeloLista);
        panel.add(lista);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ComponentesGUI();
        });
    }
}
