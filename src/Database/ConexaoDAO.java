/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




/**
 *
 * @author fernandadourado
 */
public class ConexaoDAO {
    
    public Connection getConexaoDAO()
    {
        // estabelecer conexao
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Livroteca?serverTimezone=UTC", //linha de conexao
                    "root", //user mysql
                    "123456" //senha mysql
            );
            return conn;
            
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ConexaoDAO" + e.getMessage());
            return null;
        }
    }
} 