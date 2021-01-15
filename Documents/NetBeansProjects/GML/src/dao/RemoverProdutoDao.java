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
import model.RemoverProdutoModel;

/**
 *
 * @author topga
 */
public class RemoverProdutoDao {
    
    private final Connection conecta;

    public RemoverProdutoDao(Connection conecta) {
        this.conecta = conecta;
    }
    
    public ArrayList<RemoverProdutoModel> utilizandoOResultSet(RemoverProdutoModel model) throws SQLException{
        
        String sql = "SELECT * FROM " + model.getCategoria();
        
        PreparedStatement stmt = conecta.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<RemoverProdutoModel> lista = new ArrayList<>();
        
        while (rs.next()) { 
            RemoverProdutoModel dadosArrayList = new RemoverProdutoModel();
            
            dadosArrayList.setIdDoProduto(rs.getInt("ID"));
            dadosArrayList.setNomeDoProduto(rs.getString("NOME_DO_PRODUTO"));
            dadosArrayList.setCategoria(rs.getString("CATEGORIA"));
            dadosArrayList.setValor(rs.getFloat("QUANTIDADE"));
            lista.add(dadosArrayList);
            
        }
        stmt.close();
        return lista; 
    }
    
    
}
