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
public class My_Connection {
    
    public Connection criarConexao(){
        
        Connection con = null;
        MysqlDataSource mds = new MysqlDataSource();
        mds.setServerName("localhost");
        mds.setPortNumber(3306);
        mds.setUser("root");
        mds.setPassword("");
        mds.setDatabaseName("GerenciaSuporte");
        
        try {
            con = mds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(My_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}
