package com.gerenciasuporte;

import javax.swing.JTable;

/**
 *
 * @author Natalia
 */
public interface Objeto {
    
    public boolean insereObjeto();
    public boolean alteraObjeto();
    public boolean deletaObjeto();
    public void consultaObjeto(JTable tabela, String string);
}
