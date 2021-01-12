/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.ListarProdutosPorClienteDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ListarProdutosPorClienteModel;
import view.ListarProdutosPorClienteView;

/**
 *
 * @author topga
 */
public class ListarProdutosPorClienteController {
    
    private ListarProdutosPorClienteView view;

    public ListarProdutosPorClienteController(ListarProdutosPorClienteView view) {
        this.view = view;
    }
    
    public void buscandoInformacoesDoBanco(){
        
        String nomeDoCliente = view.getjTextFieldCliente().getText() + "%";
        String cpf = view.getjTextFieldCpf().getText();
        
        ListarProdutosPorClienteModel model = new ListarProdutosPorClienteModel(nomeDoCliente, cpf);
        DefaultTableModel modelo = (DefaultTableModel) view.getjTProdutos().getModel();

        try {
        
        Connection conecta = new Conexao().getConnection();
        ListarProdutosPorClienteDao dao = new ListarProdutosPorClienteDao(conecta);
        ArrayList<ListarProdutosPorClienteModel> lista = dao.listandoProdutoPorCliente(model);
        
        if ( lista != null){
            for (ListarProdutosPorClienteModel busca : lista){
                    modelo.addRow(new Object[]{
                    busca.getIdDoPedido(),
                    busca.getNomeDoProduto(),
                    busca.getValor(),
                    busca.getQuantidade(),
                    busca.getEmail()
                            
                });
                
                
                
            }      
        }
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(ListarProdutosPorClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(view, "Erro no metodo buscandoInformacoesDoBanco \n" + ex);
        }
        
        
    }
    
    public void carregarTabela(){
        
         
        
    }
    
    
    
}
