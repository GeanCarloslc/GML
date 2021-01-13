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
import model.CaixaDinheiroModel;

/**
 *
 * @author topga
 */
public class CaixaDinheiroDao {
    
    private Connection conecta;

    public CaixaDinheiroDao(Connection conecta) {
        this.conecta = conecta;
    }
    
    
    public ArrayList<CaixaDinheiroModel> buscandoDadosDoPedido(CaixaDinheiroModel model) {
        
        
        String sql = "SELECT * FROM ITENSPORCLIENTES JOIN CADASTRO_DE_CLIENTE ON CPF = CPF_ITENS WHERE ID_DO_PEDIDO = ?";
        
        
        try {
            PreparedStatement stmt = conecta.prepareStatement(sql);
            stmt.setInt(1, model.getIdDoPedido());
        
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<CaixaDinheiroModel> lista = new ArrayList<>();
        
        while (rs.next()) { 
            CaixaDinheiroModel dadosArrayList = new CaixaDinheiroModel();
            dadosArrayList.setNomeDoCliente(rs.getString("NOME"));
            dadosArrayList.setNomeDoProduto(rs.getString("NOME_DO_PRODUTO"));
            dadosArrayList.setQuantidade(rs.getInt("QUANTIDADE"));
            dadosArrayList.setValor(rs.getFloat("VALOR"));
            dadosArrayList.setDesconto(rs.getInt("DESCONTO"));
            lista.add(dadosArrayList);   
        }
        
        stmt.close();
        return lista;
        
        
        } catch (SQLException ex) {
            Logger.getLogger(CaixaDebitoDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro no metodo buscandoDadosDoPedido: \n" + ex);
        }
         
     return null;    
    }
    
    public void utilizandoOInsert (CaixaDinheiroModel model) throws SQLException{
        
        String sql = "INSERT INTO CAIXADINHEIRO(ID_CAIXA_FK, STATUS, ID_DO_PEDIDO_FK, VALOR_FINAL) VALUES (?,?,?,?)";
        
        PreparedStatement stmt = conecta.prepareStatement(sql);
        
        stmt.setInt(1, model.getId_caixa());
        stmt.setString(2, model.getStatus());
        stmt.setInt(3, model.getIdDoPedido());
        stmt.setFloat(4, model.getValorTotal());
        
        stmt.execute();
        stmt.close();
            
    }
    
}
