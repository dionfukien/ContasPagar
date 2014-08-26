/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexaobanco;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * Feito em consulta ao material de Richard Mateus
 */
public class DAO {
    private Connection conn;
    private EstruturaDados est;
    
    public DAO(){
      
    }
  
    public boolean inserir(String table, String content) {
        boolean retorno = false;
        
        String sql = "INSERT INTO " + table + " values(" + content + ")";
       try{
            conn = Conexao.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.executeUpdate(sql);
            retorno = true;
          //  conn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro -> " + this.getClass().getName().toString() + ") - " + e.getMessage());
        }
       
       return retorno;  
                
    }
    
     public EstruturaDados selecionar(String table, String fields, String filter) {
         int j=0;
         String sql = "SELECT " + fields + " from " + table + " where " + filter;
       try{
            conn = Conexao.getInstance().getConnection();
            Statement stm = this.conn.createStatement();
            stm.execute(sql);  
             //Adquirindo através de um objeto ResulSet, os registros retornados pela SQL:  
            ResultSet results = stm.getResultSet();  
            est = new EstruturaDados(100);
            while (results.next()){  
  //              est.inserir(results.getNString("NOME"), results.getNString("TELEFONE"), results.getInt("IDADE")); 
                JOptionPane.showMessageDialog (null, "Informações: " + results.getNString("NOME") + " | " + results.getNString("TELEFONE") + " | " + results.getInt("IDADE"));
            }
 //           return est;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro!!! -> " + this.getClass().getName().toString() + ") - " + e.getMessage());            
        }
        return null;
    }
}