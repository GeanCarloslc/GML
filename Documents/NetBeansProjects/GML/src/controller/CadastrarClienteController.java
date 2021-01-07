/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CadastrarClienteDao;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CadastrarClienteModel;
import view.CadastrarClienteView;


/**
 *
 * @author topga
 */
public class CadastrarClienteController {
    
    private final CadastrarClienteView view;
    

    public CadastrarClienteController(CadastrarClienteView view) {
        this.view = view;
    }

    public void cadastrarCliente(CadastrarClienteView cadastrarClienteView){
        
        String nomeCliente = cadastrarClienteView.getjTextFieldNomeCliente().getText();
        String cpf = cadastrarClienteView.getjTextFieldCPF().getText();
        String rg = cadastrarClienteView.getjTextFieldRG().getText();
        String dataDeNascimento = cadastrarClienteView.getjTextFieldDataDeNascimento().getText();
        String email = cadastrarClienteView.getjTextFieldEmail().getText();
        
        CadastrarClienteModel model = new CadastrarClienteModel(nomeCliente, cpf, rg, dataDeNascimento, email);
        
        
        try {
            Connection conecta = new Conexao().getConnection();
            CadastrarClienteDao dao = new CadastrarClienteDao(conecta);
            dao.cadastrarClientes(model);
            JOptionPane.showMessageDialog(view, "Cliente cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarClienteController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(view, "Erro ao cadastrar o cliente");
        }
        
        
        
        
    }
    
    
}
