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
import model.CaixaModel;

/**
 *
 * @author topga
 */
public class CaixaDao {
    
    private Connection conecta;

    public CaixaDao(Connection conecta) {
        this.conecta = conecta;
    }
    
    public ArrayList<CaixaModel> retornandoOsValoresParaATabela (CaixaModel model){
        
        try {
            String sql = "SELECT * FROM ITENSPORCLIENTES INNER JOIN CADASTRO_DE_CLIENTE ON CPF = CPF_ITENS WHERE CPF LIKE ?";
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, model.getCpf());
            
            
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<CaixaModel> lista = new ArrayList<>();
            
            while (rs.next()){
                
                CaixaModel produto = new CaixaModel();
                produto.setCliente(rs.getString("NOME"));
                produto.setProduto(rs.getString("NOME_DO_PRODUTO"));
                produto.setQuantidade(rs.getInt("QUANTIDADE"));
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
