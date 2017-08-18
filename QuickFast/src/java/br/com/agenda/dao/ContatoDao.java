/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.dao;

import br.com.agenda.jdbc.Conexao;
import br.com.agenda.model.ModelContato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class ContatoDao {
   PreparedStatement pst;
   ResultSet rs;
   String sql;
   Connection conexao;
   
   
   public void salvar(ModelContato cont ){
       sql = "INSERT INTO contato (nome,celular,telefone,email) values (?,?,?,?)";
       
       try {
           Connection conecta = Conexao.getConexao();
           pst=conecta.prepareStatement(sql);
           pst.setString(1, cont.getNome());
           pst.setString(2, cont.getCelular());
           pst.setString(3, cont.getTelefone());
           pst.setString(4, cont.getEmail());
           
           pst.execute();
           Conexao.getConexao().close();
           System.out.println("Cadastrado com Sucesso");
           
       } catch (Exception e) {
           System.out.println("Erro" + e);
       }
   }
   
   public List buscar(){
       
       sql = "SELECT * FROM contato";
       List<ModelContato> lista = new ArrayList<>();
       try {
           conexao = Conexao.getConexao();
           pst = conexao.prepareStatement(sql);
           rs = pst.executeQuery();
           
           while(rs.next()){
               ModelContato cont = new ModelContato();
               cont.setId(rs.getInt("id"));
               cont.setNome(rs.getString("nome"));
               cont.setCelular(rs.getString("celular"));
               cont.setTelefone(rs.getString("telefone"));
               cont.setEmail(rs.getString("email"));
               
               lista.add(cont);
           }
           
           Conexao.getConexao().close();
           
       } catch (Exception e) {
           System.out.println("Erro na consulta");
       }
       
       return lista;
   }
   
   public void deletar(ModelContato cont){
      sql = "DELETE FROM contato where id=?";
       try {
           conexao=Conexao.getConexao();
           pst = conexao.prepareStatement(sql);
           pst.setInt(1, cont.getId());
           pst.execute();
           Conexao.getConexao().close();
           System.out.println("Apagou");
       } catch (Exception e) {
           System.out.println("Não apagou " + e);
       }
       
   }
   
      public void alterar(ModelContato cont){
      sql = "UPDATE contato SET nome=?, celular=?, telefone=?, email=? WHERE id=?";
       try {
           conexao=Conexao.getConexao();
           pst = conexao.prepareStatement(sql);
           pst.setString(1, cont.getNome());
           pst.setString(2, cont.getCelular());
           pst.setString(3, cont.getTelefone());
           pst.setString(4, cont.getEmail());
           pst.setInt(5, cont.getId());
           pst.execute();
           Conexao.getConexao().close();
           System.out.println("Alterou");
       } catch (Exception e) {
           System.out.println("Não apagou " + e);
       }
       
   }
     
      public List encontrar(ModelContato c){
       
       sql = "SELECT nome FROM contato where nome=?";
       List<ModelContato> lista = new ArrayList<>();
       try {
           conexao = Conexao.getConexao();
           pst = conexao.prepareStatement(sql);
           rs = pst.executeQuery();
           
           while(rs.next()){
               ModelContato cont = new ModelContato();
               cont.setNome(rs.getString("nome"));
               
               lista.add(cont);
           }
           
           Conexao.getConexao().close();
           
       } catch (Exception e) {
           System.out.println("Erro na consulta");
       }
       
       return lista;
   }
      
   
}
