/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ListarProdutosDoEstoqueModel;

/**
 *
 * @author topga
 */
public class ListarProdutosDoEstoqueDao {
    
    private Connection conecta;

    public ListarProdutosDoEstoqueDao(Connection conecta) {
        this.conecta = conecta;
    }
    
    
    
    public ArrayList<ListarProdutosDoEstoqueModel> listandoValoresDoBanco (ListarProdutosDoEstoqueModel model) {
        
        
        
        try {
            
        String sql = "SELECT * FROM " + model.getCategoria() + " WHERE NOME_DO_PRODUTO = ?";
        
        PreparedStatement stmt = conecta.prepareStatement(sql);
        
        stmt.setString(1, model.getNomeDoProduto());
        
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<ListarProdutosDoEstoqueModel> lista = new ArrayList<>();
       
        
        while (rs.next()){
            
            ListarProdutosDoEstoqueModel produtos = new ListarProdutosDoEstoqueModel();
            produtos.setNomeDoProduto(rs.getString("NOME_DO_PRODUTO"));
            produtos.setCategoria(rs.getString("CATEGORIA"));
            produtos.setValor(rs.getFloat("VALOR"));
            produtos.setQuantidade(rs.getInt("QUANTIDADE"));
            lista.add(produtos);
            
        }
            
        stmt.close();
        return lista;
        
        } catch (SQLException ex) {
            Logger.getLogger(ListarProdutosDoEstoqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
          
    
}
    
    public ArrayList<ListarProdutosDoEstoqueModel> listandoTodosOsDadosPorCategoria(ListarProdutosDoEstoqueModel model){
        
        try {
            
        String sql = "SELECT * FROM " + model.getCategoria() + " WHERE CATEGORIA = ? ";
        
        PreparedStatement stmt = conecta.prepareStatement(sql);
        
        stmt.setString(1, model.getCategoria());
        
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<ListarProdutosDoEstoqueModel> lista = new ArrayList<>();
        
        while (rs.next()){
            
            ListarProdutosDoEstoqueModel produtos = new ListarProdutosDoEstoqueModel();
            produtos.setCategoria(rs.getString("CATEGORIA"));
            produtos.setId(rs.getInt("ID"));
            produtos.setNomeDoProduto(rs.getString("NOME_DO_PRODUTO"));
            produtos.setQuantidade(rs.getInt("QUANTIDADE"));
            produtos.setValor(rs.getFloat("VALOR"));
            lista.add(produtos);
            
            
        }
        stmt.close();
        return lista;
         
        } catch (SQLException ex) {
            Logger.getLogger(ListarProdutosDoEstoqueDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
  
    }    
}

