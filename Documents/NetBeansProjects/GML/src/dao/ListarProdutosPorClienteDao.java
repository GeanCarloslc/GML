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
import javax.swing.JOptionPane;
import model.ListarProdutosPorClienteModel;

/**
 *
 * @author topga
 */
public class ListarProdutosPorClienteDao {
    
    private Connection conecta;

    public ListarProdutosPorClienteDao(Connection conecta) {
        this.conecta = conecta;
    }
    
    public ArrayList<ListarProdutosPorClienteModel> listandoProdutoPorCliente(ListarProdutosPorClienteModel model){
        
        try {
            String sql = "SELECT * FROM ITENSPORCLIENTES INNER JOIN CADASTRO_DE_CLIENTE ON CPF = CPF_ITENS WHERE CPF = ? OR NOME = ?"  ;
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, model.getCpf());
            stmt.setString(2, model.getNomeDoCliente());
            
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<ListarProdutosPorClienteModel> lista = new ArrayList<>();
            
            while (rs.next()){
                
                ListarProdutosPorClienteModel produto = new ListarProdutosPorClienteModel();
                produto.setNomeDoCliente(rs.getString("NOME"));
                produto.setNomeDoProduto(rs.getString("NOME_DO_PRODUTO"));
                produto.setQuantidade(rs.getInt("QUANTIDADE"));
                produto.setEmail(rs.getString("EMAIL"));
                produto.setValor(rs.getFloat("VALOR"));
                produto.setIdDoPedido(rs.getInt("ID_DO_PEDIDO"));
                lista.add(produto);
                   
            }
            stmt.close();
            return lista;
            
        
        } catch (SQLException ex) {
            Logger.getLogger(ListarProdutosPorClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro no metodo listandoProdutoPorCliente " + ex);
        } 
        return null;
    }
    
}
