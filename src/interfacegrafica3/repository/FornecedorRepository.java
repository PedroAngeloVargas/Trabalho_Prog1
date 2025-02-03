/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacegrafica3.repository;

import interfacegrafica3.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author joaol
 */
public class FornecedorRepository implements Crud<Fornecedor> {
    
    @Override
    public boolean inserir(Connection connection, Fornecedor fornecedor) {
        PreparedStatement stmt = null;
        try{
            String comando = "INSERT INTO fornecedor(categoria) " +
                             "VALUES(?)";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, fornecedor.getNome());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao inserir Fornecedor: " + ex.getMessage(),
                    "Erro ao inserir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    @Override
    public boolean atualizar(Connection connection, Fornecedor fornecedor) {
        PreparedStatement stmt = null;
        try{
            String comando = "UPDATE fornecedor SET " +
                             "categoria = ?" +
                             "WHERE id = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, fornecedor.getNome());
            stmt.setInt(2, fornecedor.getId());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao atualizar Fornecedor: " + ex.getMessage(),
                    "Erro ao atualizar",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    @Override
    public boolean deletar(Connection connection, Fornecedor fornecedor) {
        PreparedStatement stmt = null;
        try{
            String comando = "DELETE FROM fornecedor " +
                             "WHERE id = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1, fornecedor.getId());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao excluir fornecedor: " + ex.getMessage(),
                    "Erro ao excluir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    @Override
    public Fornecedor selecionar(Connection connection, String operador, int id) {
        try{
            Fornecedor fornecedor = new Fornecedor();
            PreparedStatement stmt = null;
            String comando = "SELECT * FROM uf WHERE id " + 
                             operador + " ? ";
            if(operador.equals("<"))
                comando += " ORDER BY id DESC";
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if(res != null){
                while(res.next()){
                    fornecedor.setId(Integer.parseInt(res.getString("id") ));
                    fornecedor.setCategoria(res.getString("categoria"));
                    break;
                }
            }
            return fornecedor;
        }catch(Exception ex){            
            return null;
        }
        }
    }
    
    
    
    
    
    
    
    

