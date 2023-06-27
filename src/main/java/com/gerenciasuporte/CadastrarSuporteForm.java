package com.gerenciasuporte;

import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Natalia
 */
public class CadastrarSuporteForm extends javax.swing.JFrame {

    ConexaoMySQL conexao = new ConexaoMySQL();
    
    public CadastrarSuporteForm() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        painel = new javax.swing.JPanel();
        painelMenu = new javax.swing.JPanel();
        labelConsultarSuporte = new javax.swing.JLabel();
        lblTipoDeSuporte_1 = new javax.swing.JLabel();
        botaoCadastrar = new javax.swing.JButton();
        campoTipoSuporte = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        painel.setBackground(new Color(192, 192, 192));
        labelConsultarSuporte.setFont(new java.awt.Font("Calibri", 0, 14));
        labelConsultarSuporte.setText("Cadastrar Suporte");

        javax.swing.GroupLayout gl_painelMenu = new javax.swing.GroupLayout(painelMenu);
        painelMenu.setLayout(gl_painelMenu);
        
        gl_painelMenu.setHorizontalGroup(
            gl_painelMenu.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_painelMenu.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelConsultarSuporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        gl_painelMenu.setVerticalGroup(
            gl_painelMenu.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_painelMenu.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelConsultarSuporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTipoDeSuporte_1.setFont(new java.awt.Font("Calibri", 0, 14));
        lblTipoDeSuporte_1.setText("Tipo de Suporte:");
	
	    botaoCadastrar.setFont(new java.awt.Font("Calibri", 0, 12));
	    botaoCadastrar.setText("Cadastrar");
	    botaoCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            botaoCadastrar(evt);
	        }
	    });
	
	    campoTipoSuporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione uma opção>", "Hardware", "Rede", "Banco de dados/aplicação" }));
	    
	    JLabel lblCidade = new JLabel();
	    lblCidade.setText("Cidade:");
	    lblCidade.setFont(new Font("Calibri", Font.PLAIN, 14));
	    
	    campoCidade = new JTextField();
	    campoCidade.setColumns(10);
	    
	    JLabel lblPas = new JLabel();
	    lblPas.setText("País:");
	    lblPas.setFont(new Font("Calibri", Font.PLAIN, 14));
	    
	    campoPais = new JTextField();
	    campoPais.setColumns(10);
	    
	    JLabel lblHorrioInicial = new JLabel();
	    lblHorrioInicial.setText("Horário Inicial:");
	    lblHorrioInicial.setFont(new Font("Calibri", Font.PLAIN, 14));
	    
	    campoHoraInicial = new JTextField();
	    campoHoraInicial.setColumns(10);
	    
	    JLabel lblHorrioFinal = new JLabel();
	    lblHorrioFinal.setText("Horário Final:");
	    lblHorrioFinal.setFont(new Font("Calibri", Font.PLAIN, 14));
	    
	    campoHoraFinal = new JTextField();
	    campoHoraFinal.setColumns(10);
	    
	    JLabel lblTipoDeSuporte = new JLabel();
	    lblTipoDeSuporte.setText("Telefone:");
	    lblTipoDeSuporte.setFont(new Font("Calibri", Font.PLAIN, 14));
	    
	    campoTelefone = new JTextField();
	    campoTelefone.setColumns(10);
	    GroupLayout gl_painel = new GroupLayout(painel);
	    gl_painel.setHorizontalGroup(
	    	gl_painel.createParallelGroup(Alignment.LEADING)
	    		.addComponent(painelMenu, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
	    		.addGroup(gl_painel.createSequentialGroup()
	    			.addGap(10)
	    			.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
	    			.addGap(4)
	    			.addComponent(campoCidade, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
	    		.addGroup(gl_painel.createSequentialGroup()
	    			.addGap(10)
	    			.addComponent(lblPas, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
	    			.addGap(4)
	    			.addComponent(campoPais, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
	    		.addGroup(gl_painel.createSequentialGroup()
	    			.addGap(10)
	    			.addComponent(lblHorrioInicial, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
	    			.addGap(4)
	    			.addComponent(campoHoraInicial, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
	    		.addGroup(gl_painel.createSequentialGroup()
	    			.addGap(10)
	    			.addComponent(lblHorrioFinal, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
	    			.addGap(4)
	    			.addComponent(campoHoraFinal, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
	    		.addGroup(gl_painel.createSequentialGroup()
	    			.addGap(10)
	    			.addComponent(lblTipoDeSuporte_1)
	    			.addGap(4)
	    			.addComponent(campoTipoSuporte, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
	    		.addGroup(gl_painel.createSequentialGroup()
	    			.addGap(10)
	    			.addComponent(lblTipoDeSuporte, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
	    			.addGap(4)
	    			.addComponent(campoTelefone, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
	    		.addGroup(gl_painel.createSequentialGroup()
	    			.addGap(10)
	    			.addComponent(botaoCadastrar, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
	    );
	    gl_painel.setVerticalGroup(
	    	gl_painel.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_painel.createSequentialGroup()
	    			.addComponent(painelMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    			.addGap(45)
	    			.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_painel.createSequentialGroup()
	    					.addGap(3)
	    					.addComponent(lblCidade))
	    				.addComponent(campoCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(6)
	    			.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_painel.createSequentialGroup()
	    					.addGap(3)
	    					.addComponent(lblPas))
	    				.addComponent(campoPais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(6)
	    			.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_painel.createSequentialGroup()
	    					.addGap(3)
	    					.addComponent(lblHorrioInicial))
	    				.addComponent(campoHoraInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(6)
	    			.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_painel.createSequentialGroup()
	    					.addGap(3)
	    					.addComponent(lblHorrioFinal))
	    				.addComponent(campoHoraFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(6)
	    			.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
	    				.addComponent(lblTipoDeSuporte_1)
	    				.addComponent(campoTipoSuporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(6)
	    			.addGroup(gl_painel.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_painel.createSequentialGroup()
	    					.addGap(3)
	    					.addComponent(lblTipoDeSuporte))
	    				.addComponent(campoTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(18)
	    			.addComponent(botaoCadastrar))
	    );
	    painel.setLayout(gl_painel);
	    GroupLayout groupLayout = new GroupLayout(getContentPane());
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addComponent(painel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addComponent(painel, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
	    );
	    getContentPane().setLayout(groupLayout);
	
	    pack();
    }

    private void botaoCadastrar(java.awt.event.ActionEvent evt) {
    	String cidade = campoCidade.getText();
    	String pais = campoPais.getText();
    	String horaInicial = campoHoraInicial.getText();
    	String horaFinal = campoHoraFinal.getText();
        String tipoSuporte = (String) campoTipoSuporte.getSelectedItem();
        String telefone = campoTelefone.getText();
        
        PreparedStatement ps;
        ResultSet rs;
        String insertQuery = "INSERT INTO `dadossuporte` VALUES(?,?,?,?,?,?,?);";
        
        try {
            ps = conexao.criarConexao().prepareStatement(insertQuery);
            ps.setInt(1, (int)(Math.random() * 999 + 1));
            ps.setString(2, cidade);
            ps.setString(3, pais);
            ps.setString(4, horaInicial);
            ps.setString(5, horaFinal);
            ps.setString(6, tipoSuporte);
            ps.setString(7, telefone);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarSuporteForm.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(CadastrarSuporteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarSuporteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarSuporteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarSuporteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarSuporteForm().setVisible(true);
            }
        });
    }
    
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JComboBox<String> campoTipoSuporte;
    private javax.swing.JLabel labelConsultarSuporte;
    private javax.swing.JLabel lblTipoDeSuporte_1;
    private javax.swing.JPanel painel;
    private javax.swing.JPanel painelMenu;
    private JTextField campoCidade;
    private JTextField campoPais;
    private JTextField campoHoraInicial;
    private JTextField campoHoraFinal;
    private JTextField campoTelefone;    
}
