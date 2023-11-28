/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author Feh
 */
public class FuncionarioDAO {
    
    private ConexaoDAO conexao;
    private Connection conn;
    
    public FuncionarioDAO(){
        this.conexao = new ConexaoDAO();
        this.conn = this.conexao.getConexaoDAO();
    }
    
    public void inserir(Funcionario funcionario){
        String sql = "INSERT INTO tb_cadastro_user(nome_user, data_nascimento, cfp_user, email_user) VALUES (?, ?, ?, ?, ?)";
        try{
             PreparedStatement stmt = this.conn.prepareStatement(sql);
             stmt.setString(1, funcionario.getNome());
             stmt.setString(2, funcionario.getDataNasci());
             stmt.setString(3, funcionario.getCpf());
             stmt.setString(4, funcionario.getEmail());
             stmt.setString(5, funcionario.getSenha());
             stmt.execute();
             
        }
        catch (Exception e) {
            System.out.println("Erro ao inserir funcionario: " + e.getMessage());
            
        }
    }
  
}
