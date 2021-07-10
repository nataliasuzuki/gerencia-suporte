package com.gerenciasuporte;

import javax.swing.JButton;

/**
 *
 * @author Natalia
 */
public class Mediador {
    private JButton botaoConsultar;

    public void pesquisar() {
        botaoConsultar.setEnabled(false);
        botaoConsultar.setFont(new java.awt.Font("Calibri", 0, 12));
        botaoConsultar.setText("Pesquisar");
        botaoConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
}