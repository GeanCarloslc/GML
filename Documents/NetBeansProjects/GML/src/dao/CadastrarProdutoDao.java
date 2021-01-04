/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CadastrarProdutoModel;

/**
 *
 * @author topga
 */
public class CadastrarProdutoDao {
    
    private final Connection conecta;

    public CadastrarProdutoDao(Connection conecta) {
        this.conecta = conecta;
    }
  
    public void cadastrarProdutoNoBanco(CadastrarProdutoModel model){
           
        try {
            
            String sql = "INSERT INTO " +model.getCategoria() + "(CATEGORIA, NOME_DO_PRODUTO, VALOR, QUANTIDADE) VALUES(?,?,?,?)";
            
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, model.getCategoria());
            stmt.setString(2, model.getNomeDoProduto());
            stmt.setFloat(3, model.getValor());
            stmt.setInt(4, model.getQuantidade());
            
            stmt.execute();
            stmt.close();    
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro no metodo cadastrarProdutosNoBanco \n" + ex);
        }
          
    }
    

    
}
