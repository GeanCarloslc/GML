/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.CadastrarClienteModel;

/**
 *
 * @author topga
 */
public class CadastrarClienteDao {
    
    private Connection conecta;

    public CadastrarClienteDao(Connection conecta) {
        this.conecta = conecta;
    }
    
    
    public void cadastrarClientes(CadastrarClienteModel model) throws SQLException {
        
        
        String sql = "INSERT INTO CADASTRODECLIENTE(NOME, CPF, RG, NASCIMENTO, EMAIL) VALUES (?,?,?,?,?)";
         
        PreparedStatement stmt = conecta.prepareStatement(sql);
        stmt.setString(1, model.getNomeCliente());
        stmt.setString(2, model.getCpf());
        stmt.setString(3, model.getRg());
        stmt.setString(4, model.getDataDeNascimento());
        stmt.setString(5, model.getEmail());
        
        stmt.execute();
        
        conecta.close();
        
    }
    
}
