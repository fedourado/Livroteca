/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Model.Livros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Feh
 */
public class LivroDAO {
    
        private ConexaoDAO conexao;
        private Connection conn;

        public LivroDAO(){
            this.conexao = new ConexaoDAO();
            this.conn = this.conexao.getConexaoDAO();        
        }

        public void inserir(Livros objlivro){
            String sql = "INSERT INTO tb_livros(nome_livro, subtitulo_livro, resumo_livro, data_pub, editora_livro) VALUES (?, ?, ?, ?, ?)";
            try{
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 stmt.setString(1, objlivro.getTitulo());
                 stmt.setString(2, objlivro.getSubtitulo());
                 stmt.setString(3, objlivro.getAutor());
                 stmt.setString(4, objlivro.getEditora());
                 stmt.setString(5, objlivro.getDatapublicacao());
                 stmt.execute();

            }
            catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir livros: " + e);

            }
        }
    
        public List<Livros> getLivros()
        {
            String sql = "SELECT * FROM tb_livros";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                List<Livros> listaLivros = new ArrayList<>();
                // percorre o "rs" e salva as informações dentro de uma var "Curso"
                // e depois salva essa var dentro da lista

                while(rs.next()){
                    Livros livro = new Livros();
                    livro.setTitulo(rs.getString("nome_livro"));
                    livro.setSubtitulo(rs.getString("subtitulo_livro"));
                    livro.setAutor(rs.getString("resumo_livro"));
                    livro.setEditora(rs.getString("editora_livro"));
                    livro.setDatapublicacao(rs.getString("data_pub"));
                    listaLivros.add(livro);
                }
                return listaLivros;
            
            }catch (Exception e) {
                return null;
    
        }
    }
}