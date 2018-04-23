package Modelo;

import Controle.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    String tabela = "cadusuarios";
    UsuarioDTO user = new UsuarioDTO();
    Conexao conn = new Conexao();
    
    public void Salvar(UsuarioDTO user){
        conn.conect();
        String insert = "INSERT INTO " + tabela + " (nome_user, usuario_user, email_user, rg_user, senha_user, senha2_user, acesso_user)"
                + " values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conn.conec.prepareStatement(insert);
            pst.setString(1, user.getUserNome());
            pst.setString(2, user.getUserUsuario());
            pst.setString(3, user.getUserEmail());
            pst.setInt(4, user.getUserRg());
            pst.setString(5, user.getUserSenha());
            pst.setString(6, user.getUserSenha2());
            pst.setString(7, user.getUserTipo());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            //Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao inserir o usuário. " + ex);
        }
    }
    
    public UsuarioDTO pesquisaUser(UsuarioDTO userDTO){
        try {
            conn.conect();
            conn.executaSql("SELECT * FROM " + tabela + " WHERE nome_user like '%" + userDTO.getPesquisa()+"%'");
            conn.rs.first();
            userDTO.setUserCod(conn.rs.getInt("cod_user"));
            userDTO.setUserNome(conn.rs.getString("nome_user"));
            userDTO.setUserUsuario(conn.rs.getString("usuario_user"));
            userDTO.setUserEmail(conn.rs.getString("email_user"));
            userDTO.setUserRg(conn.rs.getInt("rg_user"));
            userDTO.setUserSenha(conn.rs.getString("senha_user"));
            userDTO.setUserSenha2(conn.rs.getString("senha2_user"));
            userDTO.setUserTipo(conn.rs.getString("acesso_user"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
        }
        
        return userDTO;
    }
    
    public void editar(UsuarioDTO userDTO){
        conn.conect();
        String edit = "UPDATE " + tabela + " SET nome_user = ?, usuario_user = ?, email_user = ?, rg_user = ?, senha_user = ?, "
                + "senha2_user = ?, acesso_user = ? WHERE cod_user = ?;";
        try {
            PreparedStatement pst = conn.conec.prepareStatement(edit);
            pst.setString(1, userDTO.getUserNome());
            pst.setString(2, userDTO.getUserUsuario());
            pst.setString(3, userDTO.getUserEmail());
            pst.setInt(4, userDTO.getUserRg());
            pst.setString(5, userDTO.getUserSenha());
            pst.setString(6, userDTO.getUserSenha2());
            pst.setString(7, userDTO.getUserTipo());
            pst.setInt(8, userDTO.getUserCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados modificados com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Os dados não foram salvos devido a um erro. Verifique e tente novamente."+ex);
        }
    }
    public void excluir(UsuarioDTO userDTO){
        try {
            conn.conect();
            String delete = "DELETE FROM " + tabela + " WHERE cod_user = ?";
            PreparedStatement pst = conn.conec.prepareStatement(delete);
            pst.setInt(1, userDTO.getUserCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário excluido. ");
        } catch (SQLException ex) {
            //Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário. " + ex);
        }
    }
    
}
