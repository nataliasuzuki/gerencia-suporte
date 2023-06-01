package com.gerenciasuporte;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natalia
 */
public class ConexaoMySQL {
    
    public Connection criarConexao() {
        
        Connection conexao = null;
        MysqlDataSource banco = new MysqlDataSource();
        banco.setServerName("localhost");
        banco.setPortNumber(3306);
        banco.setUser("root");
        banco.setPassword("root");
        banco.setDatabaseName("gerencia-suporte_db");
        banco.setUseSSL(false);
        
        try {
            conexao = banco.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexao;
    }
}
