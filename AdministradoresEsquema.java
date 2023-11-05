import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AdministradoresEsquema {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            crearVentana("FlowLayout", new FlowLayout());
            crearVentana("BorderLayout", new BorderLayout());
            crearVentana("GridLayout", new GridLayout(2, 3));
        });
    }

    private static void crearVentana(String titulo, LayoutManager layout) {
        JFrame ventana = new JFrame(titulo);
        ventana.setLayout(layout);
        ventana.setSize(400, 200);

        ArrayList<JButton> botones = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            botones.add(new JButton("Boton " + i));
        }

        switch (layout.getClass().getSimpleName()) {
            case "FlowLayout":
                for (JButton boton : botones) {
                    ventana.add(boton);
                }
                break;

            case "BorderLayout":
                ventana.add(botones.get(0), BorderLayout.NORTH);
                ventana.add(botones.get(1), BorderLayout.SOUTH);
                ventana.add(botones.get(2), BorderLayout.WEST);
                ventana.add(botones.get(3), BorderLayout.EAST);
                ventana.add(botones.get(4), BorderLayout.CENTER);
                break;

            case "GridLayout":
                for (JButton boton : botones) {
                    ventana.add(boton);
                }
                break;
        }

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
