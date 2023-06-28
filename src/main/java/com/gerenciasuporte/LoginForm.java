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
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

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

        labelTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("Login");

        javax.swing.GroupLayout gl_labelFundo = new javax.swing.GroupLayout(labelFundo);
        gl_labelFundo.setHorizontalGroup(
        	gl_labelFundo.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_labelFundo.createSequentialGroup()
        			.addGap(228)
        			.addComponent(labelTitulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(307))
        );
        gl_labelFundo.setVerticalGroup(
        	gl_labelFundo.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_labelFundo.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(labelTitulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        labelFundo.setLayout(gl_labelFundo);

        labelUsuario.setFont(new Font("Arial", Font.BOLD, 16));
        labelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labelUsuario.setText("Usuário");

        campoUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
        campoUsuario.setText("guest");

        labelSenha.setFont(new Font("Arial", Font.BOLD, 16));
        labelSenha.setForeground(new java.awt.Color(255, 255, 255));
        labelSenha.setText("Senha");

        botaoEntrar.setBackground(new Color(255, 255, 255));
        botaoEntrar.setFont(new Font("Arial", Font.PLAIN, 14));
        botaoEntrar.setText("Entrar");
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autenticar(evt);
            }
        });

        campoSenha.setFont(new Font("Arial", Font.PLAIN, 16));
        campoSenha.setText("guest");

        javax.swing.GroupLayout gl_tela = new javax.swing.GroupLayout(tela);
        gl_tela.setHorizontalGroup(
        	gl_tela.createParallelGroup(Alignment.LEADING)
        		.addComponent(labelFundo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addGroup(gl_tela.createSequentialGroup()
        			.addGap(188)
        			.addComponent(botaoEntrar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(256, Short.MAX_VALUE))
        		.addGroup(gl_tela.createSequentialGroup()
        			.addGap(100)
        			.addGroup(gl_tela.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_tela.createSequentialGroup()
        					.addComponent(labelSenha)
        					.addContainerGap())
        				.addGroup(gl_tela.createParallelGroup(Alignment.LEADING)
        					.addGroup(gl_tela.createSequentialGroup()
        						.addComponent(labelUsuario)
        						.addContainerGap())
        					.addGroup(gl_tela.createSequentialGroup()
        						.addGroup(gl_tela.createParallelGroup(Alignment.TRAILING)
        							.addComponent(campoUsuario, Alignment.LEADING)
        							.addComponent(campoSenha, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
        						.addGap(175)))))
        );
        gl_tela.setVerticalGroup(
        	gl_tela.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_tela.createSequentialGroup()
        			.addComponent(labelFundo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(labelUsuario)
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(campoUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(23)
        			.addComponent(labelSenha)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(campoSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(botaoEntrar)
        			.addGap(33))
        );
        tela.setLayout(gl_tela);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(tela, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(tela, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        getContentPane().setLayout(groupLayout);
        
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
