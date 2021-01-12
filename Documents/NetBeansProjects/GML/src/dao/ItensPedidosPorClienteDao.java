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
import model.ItensPedidosPorClienteModel;

/**
 *
 * @author topga
 */
public class ItensPedidosPorClienteDao {
    
    private final Connection conecta;

    public ItensPedidosPorClienteDao(Connection conecta) {
        this.conecta = conecta;
    }
    
    public void updateDiminuindoAQuantidadeDaEntidadeCategoria(ItensPedidosPorClienteModel model) throws SQLException{
        
        String sql = "UPDATE " +model.getCategoria()+ " SET QUANTIDADE = QUANTIDADE - ? WHERE NOME_DO_PRODUTO = ? ";
        
        PreparedStatement stmt = conecta.prepareStatement(sql);
        
        stmt.setInt(1, model.getQuantidade());
        stmt.setString(2, model.getNomeDoProduto());
        
        stmt.execute();
        stmt.close();  
        
    }
    
    public void insertNaTabelaItensPorClientes (ItensPedidosPorClienteModel model) throws SQLException{
        
        String sql = "INSERT INTO ITENSPORCLIENTES(ID_CATEGORIA, CPF_ITENS, NOME_DO_PRODUTO, QUANTIDADE, DESCONTO, VALOR) VALUES(?,?,?,?,?,?)";
        
        PreparedStatement stmt = conecta.prepareStatement(sql);
        
        stmt.setInt(1, model.getIdCategoria());
        stmt.setString(2, model.getCpf());
        stmt.setString(3, model.getNomeDoProduto());
        stmt.setInt(4, model.getQuantidade());
        stmt.setInt(5, model.getDesconto());
        stmt.setFloat(6, model.getValor());
        
        stmt.execute();
        stmt.close();
          
    }
    
    public ArrayList<ItensPedidosPorClienteModel> listandoOIdDoPedido(ItensPedidosPorClienteModel model){
        
        
        try {
  
            String sql = "SELECT ID_DO_PEDIDO FROM ITENSPORCLIENTES WHERE CPF_ITENS = ?";
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, model.getCpf());
            
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<ItensPedidosPorClienteModel> ordemDeServiço = new ArrayList<>();
            
            while (rs.next()) { 
                
                ItensPedidosPorClienteModel buscaIdDoPedido = new ItensPedidosPorClienteModel(); 
                buscaIdDoPedido.setIdDoPedido(rs.getInt("ID_DO_PEDIDO"));
                ordemDeServiço.add(buscaIdDoPedido);
                     
            }
            
            stmt.close();
            return ordemDeServiço;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ItensPedidosPorClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;  
    }
    
    public ArrayList<ItensPedidosPorClienteModel> listandoOsValoresDoBancoComOBotao(ItensPedidosPorClienteModel model){
        
        try { 
        String sql ="SELECT * FROM " +model.getCategoria()+ " WHERE NOME_DO_PRODUTO = ?";
        PreparedStatement stmt = conecta.prepareStatement(sql);
        
        stmt.setString(1, model.getNomeDoProduto());
        
        ArrayList<ItensPedidosPorClienteModel> lista = new ArrayList<>();
        
        ResultSet rs = stmt.executeQuery();
        
            while (rs.next()) {
                ItensPedidosPorClienteModel DadosArray = new ItensPedidosPorClienteModel();
                DadosArray.setValor(rs.getFloat("VALOR"));
                DadosArray.setQuatidadeEmEstoque(rs.getInt("QUANTIDADE"));
                lista.add(DadosArray);
                
            }
            
            stmt.close();
            return lista;
        
        
        } catch (SQLException ex) {
            Logger.getLogger(ItensPedidosPorClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
