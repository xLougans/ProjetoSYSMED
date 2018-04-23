package Modelo;

import Controle.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MedicoDAO {
    
    
    String tabela = "cadmedicos";
    MedicoDTO med = new MedicoDTO();
    Conexao conn = new Conexao();
    
    
    public void Salvar(MedicoDTO med){
        conn.conect();
        String insert = "INSERT INTO " + tabela + " (nome_med, nasc_med, crm_med, end_med, email_med, tel_med, espec_med)"
                + " values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conn.conec.prepareStatement(insert);
            pst.setString(1, med.getNome());
            pst.setInt(2, med.getNasc());
            pst.setInt(3, med.getCrm());
            pst.setString(4, med.getEndereco());
            pst.setString(5, med.getEmail());
            pst.setString(6, med.getTelefone());
            pst.setString(7, med.getEspecializacao());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            
        } catch (SQLException ex) {
            //Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao inserir  dados. " + ex);
        }
    }
    
    public void excluir(MedicoDTO medDTO){
        try {
            conn.conect();
            String delete = "DELETE FROM " + tabela + " WHERE cod_med = ?";
            PreparedStatement pst = conn.conec.prepareStatement(delete);
            pst.setInt(1, medDTO.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registros excluidos. ");
        } catch (SQLException ex) {
            //Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados. " + ex);
        }
        
        
    }
    
    public MedicoDTO pesquisaMed(MedicoDTO medDTO){
        try {
            conn.conect();
            conn.executaSql("SELECT * FROM " + tabela + " WHERE nome_med like '%" + medDTO.getPesquisa()+"%'");
            conn.rs.first();
            medDTO.setCodigo(conn.rs.getInt("cod_med"));
            medDTO.setNome(conn.rs.getString("nome_med"));
            medDTO.setNasc(conn.rs.getInt("nasc_med"));
            medDTO.setCrm(conn.rs.getInt("crm_med"));
            medDTO.setEndereco(conn.rs.getString("end_med"));
            medDTO.setEmail(conn.rs.getString("email_med"));
            medDTO.setTelefone(conn.rs.getString("tel_med"));
            medDTO.setEspecializacao(conn.rs.getString("espec_med"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Médico não encontrado!");
        }
        
        return medDTO;
    }
    
    public void editar(MedicoDTO medDTO){
        conn.conect();
        String edit = "UPDATE " + tabela + " SET nome_med = ?, nasc_med = ?, crm_med = ?, end_med = ?, email_med = ?, "
                + "tel_med = ?, espec_med = ? WHERE cod_med = ?;";
        try {
            PreparedStatement pst = conn.conec.prepareStatement(edit);
            pst.setString(1, medDTO.getNome());
            pst.setInt(2, medDTO.getNasc());
            pst.setInt(3, medDTO.getCrm());
            pst.setString(4, medDTO.getEndereco());
            pst.setString(5, medDTO.getEmail());
            pst.setString(6, medDTO.getTelefone());
            pst.setString(7, medDTO.getEspecializacao());
            pst.setInt(8, medDTO.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados modificados com sucesso.");
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
