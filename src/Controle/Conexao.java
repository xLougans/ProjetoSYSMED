package Controle;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {

    public Statement stm;
    public ResultSet rs;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost/projetoclinica";
    private final String user = "admin";
    private final String pass = "nuttertools";
    public Connection conec;
    
    public void conect(){
        try {
            System.setProperty("jdbc.Drivers", driver);
            conec = DriverManager.getConnection(url, user, pass );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não conectado! Erro: " + ex.getMessage());
        }
    }
    
    public void disconnect(){
        try {
            conec.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi desconectado! Erro: " + ex.getMessage());
        }
    }
    
    /*public static Connection conectar(String banco){
        try {
            String url = "jdbc:mysql://localhost/" + banco;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection(url, "root", "");            
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());

        }
        return null;
    }*/
   
    public void executaSql(String query){
        try {
            stm = conec.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no executaSQL: " + ex.getMessage());
        }
    }
    
    
    
}
