package com.gerenciasuporte;

import javax.swing.JFrame;

/**
 *
 * @author Natalia
 */
public class MenuForm extends javax.swing.JFrame {

    public MenuForm() {
        initComponents();
    }

    private void initComponents() {
        menuBarra = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        menuObterSuporte = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuConsultarSuporte = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu.setText("Menu");
        menu.setFont(new java.awt.Font("Calibri", 0, 14));

        menuObterSuporte.setFont(new java.awt.Font("Calibri", 0, 14));
        menuObterSuporte.setText("Cadastrar suporte");
        menuObterSuporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActionPerformed(evt);
            }
        });
        menu.add(menuObterSuporte);
        menu.add(jSeparator1);

        menuConsultarSuporte.setFont(new java.awt.Font("Calibri", 0, 14));
        menuConsultarSuporte.setText("Consultar suporte");
        menuConsultarSuporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu.add(menuConsultarSuporte);
        menu.add(jSeparator2);

        menuBarra.add(menu);

        setJMenuBar(menuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );

        pack();
    }

    private void jMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        CadastrarSuporteForm form = new CadastrarSuporteForm();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        ConsultarSuporteForm form = new ConsultarSuporteForm();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	MenuForm menuForm = new MenuForm();
            	menuForm.setVisible(true);
            	menuForm.setLocationRelativeTo(null);
            }
        });
    }

    private javax.swing.JMenu menu;
    private javax.swing.JMenuBar menuBarra;
    private javax.swing.JMenuItem menuObterSuporte;
    private javax.swing.JMenuItem menuConsultarSuporte;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
}
