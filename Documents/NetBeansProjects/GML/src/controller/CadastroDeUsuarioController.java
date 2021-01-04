/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CadastroDeUsuarioDao;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CadastroDeUsuarioModel;
import view.CadastroDeUsuarioView;

/**
 *
 * @author topga
 */
public class CadastroDeUsuarioController {
    
    private CadastroDeUsuarioView view;

    public CadastroDeUsuarioController(CadastroDeUsuarioView view) {
        this.view = view;
    }
    
    public void salvarUsuario() {

        
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjTextFieldSenha().getText();
        String email = view.getjTextFieldEmail().getText();
        
        CadastroDeUsuarioModel cadastroDeUsuarioModel = new CadastroDeUsuarioModel(usuario, senha, email);
        
        try {
            Connection conecta = new Conexao().getConnection();
            CadastroDeUsuarioDao dao = new CadastroDeUsuarioDao(conecta);
            dao.salvarUsuarioeSenha(cadastroDeUsuarioModel);
            JOptionPane.showMessageDialog(null, "Usuário cadastro com sucesso!!!");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDeUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro no metodo salvarUsuario" + ex);
        }
        
        
        
    }
    
}
