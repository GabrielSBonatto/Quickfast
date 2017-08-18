/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class Conexao {
    
    public static Connection conexao;
    
    public static Connection getConexao(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "agenda", "root", "root");
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("ERRO NA conexao");
        }
        
        return conexao;
    }
    /*
    public static void main(String... a){
        Conexao con = new Conexao();
        con.getConexao();
    }
*/
}
