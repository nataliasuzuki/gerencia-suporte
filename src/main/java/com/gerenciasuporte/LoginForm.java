package com.gerenciasuporte;

import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Natalia
 */
public class LoginForm extends javax.swing.JFrame {

    public LoginForm() {
        iniciarComponentes();
        this.setLocationRelativeTo(null);
    }

    private void iniciarComponentes() {
        tela = new javax.swing.JPanel();
        labelFundo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        botaoEntrar = new javax.swing.JButton();
        campoSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tela.setBackground(new Color(192, 192, 192));

        labelFundo.setBackground(new java.awt.Color(204, 204, 204));

        labelTitulo.setFont(new Font("Calibri", Font.BOLD, 19));
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("LOGIN");

        javax.swing.GroupLayout gl_labelFundo = new javax.swing.GroupLayout(labelFundo);
        labelFundo.setLayout(gl_labelFundo);
        gl_labelFundo.setHorizontalGroup(
            gl_labelFundo.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_labelFundo.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_labelFundo.setVerticalGroup(
            gl_labelFundo.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_labelFundo.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(labelTitulo))
        );

        labelUsuario.setFont(new java.awt.Font("Calibri", 0, 18));
        labelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labelUsuario.setText("Usuário:");

        campoUsuario.setFont(new java.awt.Font("Calibri", 0, 18));
        campoUsuario.setText("guest");

        labelSenha.setFont(new java.awt.Font("Calibri", 0, 18));
        labelSenha.setForeground(new java.awt.Color(255, 255, 255));
        labelSenha.setText("Senha:");

        botaoEntrar.setBackground(new Color(255, 255, 255));
        botaoEntrar.setFont(new java.awt.Font("Calibri", 0, 18));
        botaoEntrar.setText("Entrar");
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autenticar(evt);
            }
        });

        campoSenha.setFont(new java.awt.Font("Calibri", 0, 18));
        campoSenha.setText("guest");

        javax.swing.GroupLayout gl_tela = new javax.swing.GroupLayout(tela);
        tela.setLayout(gl_tela);
        
        gl_tela.setHorizontalGroup(
            gl_tela.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(gl_tela.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gl_tela.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, gl_tela.createSequentialGroup()
                        .addComponent(labelSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gl_tela.createSequentialGroup()
                        .addComponent(labelUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
            .addGroup(gl_tela.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(botaoEntrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        gl_tela.setVerticalGroup(
            gl_tela.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_tela.createSequentialGroup()
                .addComponent(labelFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(gl_tela.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario)
                    .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gl_tela.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSenha)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botaoEntrar)
                .addGap(0, 57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        pack();
    }

    private void autenticar(java.awt.event.ActionEvent evt) {
        PreparedStatement ps;
        ResultSet rs;
        
        String usuario = campoUsuario.getText();
        String senha = String.valueOf(campoSenha.getPassword());
        
        if(usuario.trim().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Informe seu usuário para login", "Usuário vazio", 2);
        }
        else if(senha.trim().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Informe sua senha para login", "Senha vazia", 2);
        }
        else{
            ConexaoMySQL conexao = new ConexaoMySQL();
            String selectQuery = "SELECT * FROM `usuarios` WHERE `nome`= ? AND `senha`= ?";
            
            try{
                ps = conexao.criarConexao().prepareStatement(selectQuery);
                ps.setString(1,usuario);
                ps.setString(2,senha);
                rs = ps.executeQuery();
                
                if(rs.next()){
                    MenuForm menuForm = new MenuForm();
                    menuForm.setVisible(true);
                    menuForm.pack();
                    menuForm.setLocationRelativeTo(null);
                    menuForm.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    
                    this.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Usuário ou senha inválidos", "Erro no login", 2);
                }
            }
            catch(SQLException ex)
            {
                Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    private javax.swing.JButton botaoEntrar;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JPanel tela;
    private javax.swing.JPanel labelFundo;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoUsuario;
}
