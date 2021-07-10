/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciasuporte;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Natalia
 */
public class Cliente {
    
    My_Connection mycon = new My_Connection();
    
    
    public boolean insereCliente(String nome, String email){
        
        PreparedStatement st;
        ResultSet rs;
        String insereQuery = "INSERT INTO `clientes`(`nome`, `email`) VALUES (?,?)";
        
        try {
            st = mycon.criarConexao().prepareStatement(insereQuery);
            st.setString(1, nome);
            st.setString(2, email);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean editarCliente(int idC, String nome, String email)
    {
        PreparedStatement st;
        ResultSet rs;
        String editarQuery = "UPDATE `clientes` SET `nome` = ?, `email` = ? WHERE `idC`=?";
        
        try {
            st = mycon.criarConexao().prepareStatement(editarQuery);
            st.setString(1, nome);
            st.setString(2, email);
            st.setInt(3, idC);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean removeCliente(int idC)
    {
        PreparedStatement st;
        ResultSet rs;
        String removeQuery = "DELETE FROM `clientes` WHERE `idC`=?";
        
        try {
            st = mycon.criarConexao().prepareStatement(removeQuery);
            st.setInt(1, idC);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void populaTabelaClientes(JTable tabelaClientes){
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `clientes`";
        
        try {
            ps = mycon.criarConexao().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            DefaultTableModel tabelaModel = (DefaultTableModel) tabelaClientes.getModel();
            
            Object[] row;
            while(rs.next())
            {
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                
                tabelaModel.addRow(row);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
