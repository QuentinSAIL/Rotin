package org.example;

import javax.swing.*;
import java.awt.*;

public class CustomWindow {
    public static void main(String[] args) {
        // Creation de la fenetre
        JFrame frame = new JFrame("Ma fenetre");

        // Configuration de la fenetre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // permet de fermer le programme lorsqu'on ferme la fenêtre
        frame.setSize(600, Toolkit.getDefaultToolkit().getScreenSize().height / 2); // taille de la fenêtre

        // Positionnement de la fenetre
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(screenSize.width - frame.getSize().width, 0); // positionnement en haut à droite

        // Affichage de la fenetre
        frame.setVisible(true);
    }
}
