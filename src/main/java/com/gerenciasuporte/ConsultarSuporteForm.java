package com.gerenciasuporte;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 *
 * @author Natalia
 */
public class ConsultarSuporteForm extends javax.swing.JFrame {

    ConexaoMySQL conexao = new ConexaoMySQL();
    
    public ConsultarSuporteForm() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        painelConsultarSuporte2 = new javax.swing.JPanel();
        painelConsultarSuporte = new javax.swing.JPanel();
        labelConsultarSuporte = new javax.swing.JLabel();
        labelTipoSuporte = new javax.swing.JLabel();
        painelDadosSuporte = new javax.swing.JScrollPane();
        tabelaDadosSuporte = new javax.swing.JTable();
        botaoPesquisar = new javax.swing.JButton();
        botaoGerarRelatorio = new javax.swing.JButton();
        comboBoxTipoSuporte = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelConsultarSuporte2.setBackground(new Color(192, 192, 192));
        labelConsultarSuporte.setFont(new java.awt.Font("Calibri", 0, 14));
        labelConsultarSuporte.setText("Consultar Suporte");

        javax.swing.GroupLayout gl_painelConsultarSuporte = new javax.swing.GroupLayout(painelConsultarSuporte);
        painelConsultarSuporte.setLayout(gl_painelConsultarSuporte);
        
        gl_painelConsultarSuporte.setHorizontalGroup(
            gl_painelConsultarSuporte.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_painelConsultarSuporte.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelConsultarSuporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        gl_painelConsultarSuporte.setVerticalGroup(
            gl_painelConsultarSuporte.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_painelConsultarSuporte.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelConsultarSuporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelTipoSuporte.setFont(new java.awt.Font("Calibri", 0, 14));
        labelTipoSuporte.setText("Tipo de suporte:");

        tabelaDadosSuporte.setFont(new java.awt.Font("Calibri", 0, 12));
        tabelaDadosSuporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"id", "Cidade", "País", "Hora Inicial", "Hora Final", "Tipo de Suporte", "Telefone"})

        	{public boolean isCellEditable(int row, int column){return false;}}
        );
        
	    painelDadosSuporte.setViewportView(tabelaDadosSuporte);
	    botaoPesquisar.setFont(new java.awt.Font("Calibri", 0, 12));
	    botaoPesquisar.setText("Pesquisar");
	    botaoPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            eventoPesquisar(evt);
	        }
	    });
	
	    botaoGerarRelatorio.setFont(new java.awt.Font("Calibri", 0, 12));
	    botaoGerarRelatorio.setText("Gerar relatório");
	    botaoGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            eventoGerarRelatorio(evt);
	        }
	    });
	
	    comboBoxTipoSuporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione uma opção>", "Hardware", "Rede", "Banco de dados/aplicação" }));
	    javax.swing.GroupLayout gl_painelConsultarSuporte2 = new javax.swing.GroupLayout(painelConsultarSuporte2);
	    
	    gl_painelConsultarSuporte2.setHorizontalGroup(
	    	gl_painelConsultarSuporte2.createParallelGroup(Alignment.LEADING)
	    		.addComponent(painelConsultarSuporte, GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
	    		.addGroup(gl_painelConsultarSuporte2.createSequentialGroup()
	    			.addGroup(gl_painelConsultarSuporte2.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_painelConsultarSuporte2.createSequentialGroup()
	    					.addGap(118)
	    					.addGroup(gl_painelConsultarSuporte2.createParallelGroup(Alignment.TRAILING, false)
	    						.addComponent(comboBoxTipoSuporte, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
	    						.addGroup(Alignment.LEADING, gl_painelConsultarSuporte2.createSequentialGroup()
	    							.addComponent(botaoGerarRelatorio)
	    							.addPreferredGap(ComponentPlacement.UNRELATED)
	    							.addComponent(botaoPesquisar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	    				.addGroup(gl_painelConsultarSuporte2.createSequentialGroup()
	    					.addGap(22)
	    					.addGroup(gl_painelConsultarSuporte2.createParallelGroup(Alignment.LEADING)
	    						.addComponent(painelDadosSuporte, GroupLayout.PREFERRED_SIZE, 848, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(labelTipoSuporte))))
	    			.addContainerGap(19, Short.MAX_VALUE))
	    );
	    
	    gl_painelConsultarSuporte2.setVerticalGroup(
	    	gl_painelConsultarSuporte2.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_painelConsultarSuporte2.createSequentialGroup()
	    			.addComponent(painelConsultarSuporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    			.addGap(35)
	    			.addGroup(gl_painelConsultarSuporte2.createParallelGroup(Alignment.LEADING)
	    				.addComponent(labelTipoSuporte)
	    				.addComponent(comboBoxTipoSuporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(23)
	    			.addGroup(gl_painelConsultarSuporte2.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(botaoPesquisar)
	    				.addComponent(botaoGerarRelatorio))
	    			.addGap(18)
	    			.addComponent(painelDadosSuporte, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    );
	    
	    painelConsultarSuporte2.setLayout(gl_painelConsultarSuporte2);
	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    
	    layout.setHorizontalGroup(
	        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(layout.createSequentialGroup()
	            .addComponent(painelConsultarSuporte2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	            .addContainerGap())
	    );
	    
	    layout.setVerticalGroup(
	        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(layout.createSequentialGroup()
	            .addComponent(painelConsultarSuporte2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	            .addGap(0, 0, Short.MAX_VALUE))
	    );
	
	    pack();
    }

    private void eventoGerarRelatorio(java.awt.event.ActionEvent evt) {
        String tipoSuporte = (String) comboBoxTipoSuporte.getSelectedItem();
        gerarRelatorio(tipoSuporte);
    }

    private void eventoPesquisar(java.awt.event.ActionEvent evt) {
        String tipoSuporte = (String) comboBoxTipoSuporte.getSelectedItem();
        tabelaDadosSuporte.setModel(new DefaultTableModel(null, new Object[]{"id", "Cidade", "País", "Hora Inicial", "Hora Final", "Tipo de Suporte", "Telefone"}));
        buscarDadosSuporte(tabelaDadosSuporte,tipoSuporte);
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
            java.util.logging.Logger.getLogger(ConsultarSuporteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarSuporteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarSuporteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarSuporteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarSuporteForm().setVisible(true);
            }
        });
    }

    private javax.swing.JButton botaoGerarRelatorio;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JComboBox<String> comboBoxTipoSuporte;
    private javax.swing.JLabel labelConsultarSuporte;
    private javax.swing.JLabel labelTipoSuporte;
    private javax.swing.JPanel painelConsultarSuporte2;
    private javax.swing.JPanel painelConsultarSuporte;
    private javax.swing.JScrollPane painelDadosSuporte;
    private javax.swing.JTable tabelaDadosSuporte;

    public void buscarDadosSuporte(JTable tabelaSuporte, String tipoSuporte) {
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `dadossuporte` WHERE `TipoSuporte` LIKE ?";
        if(tipoSuporte.equals("<Selecione uma opção>")) {
        	selectQuery = "SELECT * FROM `dadossuporte`";
        }
        
        try {
            ps = conexao.criarConexao().prepareStatement(selectQuery);
            if(!tipoSuporte.equals("<Selecione uma opção>")) {
            	ps.setString(1, tipoSuporte);
            }
            rs = ps.executeQuery();
            DefaultTableModel tabelaModel = (DefaultTableModel) tabelaSuporte.getModel();
            
            Object[] row;
            while(rs.next())
            {
                row = new Object[7];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                
                tabelaModel.addRow(row);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarSuporteForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gerarRelatorio(String tipoSuporteSelecionado){
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `dadossuporte` WHERE `TipoSuporte` LIKE ?";
        
        try {
            ps = conexao.criarConexao().prepareStatement(selectQuery);
            ps.setString(1, tipoSuporteSelecionado);
            rs = ps.executeQuery();
            
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet abaManual = workbook.createSheet("Suportes disponiveis");
            
            HSSFFont fsTitle = workbook.createFont();
            fsTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            fsTitle.setColor(HSSFColor.WHITE.index);
            
            HSSFCellStyle sTitle = workbook.createCellStyle();
            sTitle.setFont(fsTitle);
            sTitle.setBorderBottom((short) 1);
            sTitle.setBorderLeft((short) 1);
            sTitle.setBorderRight((short) 1);
            sTitle.setBorderTop((short) 1);
            sTitle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
            sTitle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            
            HSSFCellStyle sLinha1 = workbook.createCellStyle();
            sLinha1.setBorderBottom((short) 1);
            sLinha1.setBorderLeft((short) 1);
            sLinha1.setBorderRight((short) 1);
            sLinha1.setBorderTop((short) 1);
            sLinha1.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
            sLinha1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

            HSSFCellStyle sLinha2 = workbook.createCellStyle();
            sLinha2.setBorderBottom((short) 1);
            sLinha2.setBorderLeft((short) 1);
            sLinha2.setBorderRight((short) 1);
            sLinha2.setBorderTop((short) 1);

            FileOutputStream fos = null;
            
            try	{
                File file = File.createTempFile("relatorioTemp", ".xls");
                fos = new FileOutputStream(file);

                HSSFRow row0 = abaManual.createRow(0);
                HSSFCell cell0 = row0.createCell(0);
                cell0.setCellValue("Relatório:");
                cell0.setCellStyle(sTitle);

                HSSFCell cell1 = row0.createCell(1);
                GregorianCalendar dataAtual = new GregorianCalendar();
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                fmt.setCalendar(dataAtual);
                String dateFormatted = fmt.format(dataAtual.getTime());
                cell1.setCellValue(dateFormatted);
                cell1.setCellStyle(sTitle);

                HSSFRow row1 = abaManual.createRow(1);
                HSSFCell cell2 = row1.createCell(0);
                cell2.setCellValue("");

                HSSFRow row = abaManual.createRow(2);
                HSSFCell cell0Title = row.createCell(0);
                cell0Title.setCellValue("Cidade");
                cell0Title.setCellStyle(sTitle);

                HSSFCell cell1Title = row.createCell(1);
                cell1Title.setCellValue("País");
                cell1Title.setCellStyle(sTitle);

                HSSFCell cell2Title = row.createCell(2);
                cell2Title.setCellValue("Hora Inicial");
                cell2Title.setCellStyle(sTitle);

                HSSFCell cell3Title = row.createCell(3);
                cell3Title.setCellValue("Hora Final");
                cell3Title.setCellStyle(sTitle);

                HSSFCell cell4Title = row.createCell(4);
                cell4Title.setCellValue("Tipo de Suporte");
                cell4Title.setCellStyle(sTitle);

                HSSFCell cell5Title = row.createCell(5);
                cell5Title.setCellValue("Telefone");
                cell5Title.setCellStyle(sTitle);
                
                int i = 3;
                while(rs.next()){

                        Object cidade = rs.getString(2);
                        Object pais = rs.getString(3);			
                        Object horaInicial = rs.getString(4);
                        Object horaFinal = rs.getString(5);
                        Object tipoSuporte = rs.getString(6);
                        Object telefone = rs.getString(7);

                        row = abaManual.createRow(i);
                        popularLinhas(sLinha1, sLinha2, i, row, cidade, pais, horaInicial, horaFinal, tipoSuporte, telefone);
                        i++;
                }

                File currDir = new File(".");
                String path = currDir.getAbsolutePath();
                String fileLocation = path.substring(0, path.length() - 1) + "relatorioSuporte.xls";
                System.out.println(fileLocation);
                FileOutputStream outputStream = new FileOutputStream(fileLocation);
                workbook.write(outputStream);
                outputStream.close();
        }
        catch (IOException e)
        {
        }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarSuporteForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void popularLinhas(HSSFCellStyle sLinha1, HSSFCellStyle sLinha2, int i, HSSFRow row, Object cidade, Object pais, Object horaInicial, Object horaFinal, Object tipoSuporte, Object telefone) {

        HSSFCell cell0 = row.createCell(0);
        if(cidade != null){
        	cell0.setCellValue(cidade.toString());
        } else {
        	cell0.setCellValue("");
        }

        HSSFCell cell1 = row.createCell(1);
        if(pais != null){
        	cell1.setCellValue(pais.toString());
        } else {
        	cell1.setCellValue("");
        }	

        HSSFCell cell2 = row.createCell(2);
        if(horaInicial != null){
        	cell2.setCellValue(horaInicial.toString());
        } else {
        	cell2.setCellValue("");
        }

        HSSFCell cell3 = row.createCell(3);
        if(horaFinal != null){
        	cell3.setCellValue(horaFinal.toString());
        } else {
        	cell3.setCellValue("");
        }
        
        HSSFCell cell4 = row.createCell(4);
        if(tipoSuporte != null){
        	cell4.setCellValue(tipoSuporte.toString());
        } else {
        	cell4.setCellValue("");
        }

        HSSFCell cell5 = row.createCell(5);
        if(telefone != null){
        	cell5.setCellValue(telefone.toString());
        } else {
        	cell5.setCellValue("");
        }

        if(i % 2 == 0) {
	        cell0.setCellStyle(sLinha1);
	        cell1.setCellStyle(sLinha1);
	        cell2.setCellStyle(sLinha1);
	        cell3.setCellStyle(sLinha1);
	        cell4.setCellStyle(sLinha1);
	        cell5.setCellStyle(sLinha1);
        } else {
            cell0.setCellStyle(sLinha2);
            cell1.setCellStyle(sLinha2);
            cell2.setCellStyle(sLinha2);
            cell3.setCellStyle(sLinha2);
            cell4.setCellStyle(sLinha2);
            cell5.setCellStyle(sLinha2);
        }
    }
}
