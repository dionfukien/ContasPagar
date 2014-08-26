/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexaobanco;

import java.sql.Connection; // conexão SQL para java
import java.sql.DriverManager; // driver de conexão SQL para Java
import java.sql.SQLException; // classe para tratamento de exceções
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Dion
 */
// classe responsavel pela conexão do banco de dados 
/*public class Conexao {
    private final String b = 
    
    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver"); // ORACLE
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.1.0.40:1521:XE", "login", "senha");            
        }
        catch(SQLException excecao){
            throw new RuntimeException(excecao);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
}
*/ 

public class Conexao{

	private final String Bd = "xe";
	private final String ConnString = "jdbc:oracle:thin:@10.1.0.40:1521." + Bd;
	private final String User = "Login";
	private final String Pass = "Senha";
	private Connection connection;
	
	private static  Conexao instance;

    public String getUser() {
        return User;
    }

    public String getPass() {
        return Pass;
    }

       
	
	public static Conexao getInstance(){
		if (instance == null){
			instance = new Conexao();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		if (connection == null){
			connection = DriverManager.getConnection(ConnString,User,Pass);
		}
		return connection;
	}
}