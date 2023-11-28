/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Model.Livros;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Feh
 */
public class UsuarioDAO {
    
    private ConexaoDAO conexao;
    private Connection conn;
    
    public UsuarioDAO(){
        this.conexao = new ConexaoDAO();
        this.conn = this.conexao.getConexaoDAO();
    }
    
    public void inserir(Usuario objusuario){
        String sql = "INSERT INTO tb_cadastro_user(nome_user, data_nascimento, cpf_user, email_user, senha_user) VALUES (?, ?, ?, ?, ?)";
        try{
             PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setString(1, objusuario.getNome());
             stmt.setString(2, objusuario.getDataNasci());
             stmt.setString(3, objusuario.getCpf());
             stmt.setString(4, objusuario.getEmail());
             stmt.setString(5, objusuario.getSenha());
             stmt.execute();
             
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir funcionario: " + e);
            
        }
    }
  
    public ResultSet autenticacaoUsuario(Usuario objusuario) {
       
        try {
            String sql = "select * from tb_cadastro_user where nome_user = ? and senha_user = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuario.getNome());
            pstm.setString(2, objusuario.getSenha());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        }
    }
    
     public List<Usuario> getUsuarios()
        {
            String sql = "SELECT * FROM tb_cadastro_user";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                List<Usuario> listaUsuario = new ArrayList<>();
                // percorre o "rs" e salva as informações dentro de uma var "Curso"
                // e depois salva essa var dentro da lista

                while(rs.next()){
                    Usuario user = new Usuario();
                    user.setNome(rs.getString("nome_user"));
                    user.setDataNasci(rs.getString("data_nascimento"));
                    user.setCpf(rs.getString("cpf_user"));
                    user.setEmail(rs.getString("email_user"));
                    user.setSenha(rs.getString("senha_user"));
                    listaUsuario.add(user);
                }
                return listaUsuario;
            
            }catch (SQLException e) {
                return null;
    
        }
            
    }
}
