package interfacegrafica3.repository;

import interfacegrafica3.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class FornecedorRepository implements Crud<Fornecedor> {

    @Override
    public boolean inserir(Connection connection, Fornecedor fornecedor) {
        String comando = "INSERT INTO fornecedor (nome_fantasia, razao_social, cnpj, inscricao_estadual, categoria) " +
                         "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(comando)) {
            stmt.setString(1, fornecedor.getNomeFantasia());
            stmt.setString(2, fornecedor.getRazaoSocial());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getInscricaoEstadual());
            stmt.setString(5, fornecedor.getCategoria());

            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao inserir fornecedor: " + ex.getMessage(),
                    "Erro ao inserir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    @Override
    public boolean atualizar(Connection connection, Fornecedor fornecedor) {
        String comando = "UPDATE fornecedor SET nome_fantasia = ?, razao_social = ?, cnpj = ?, inscricao_estadual = ?, categoria = ? " +
                         "WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(comando)) {
            stmt.setString(1, fornecedor.getNomeFantasia());
            stmt.setString(2, fornecedor.getRazaoSocial());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getInscricaoEstadual());
            stmt.setString(5, fornecedor.getCategoria());
            stmt.setInt(6, fornecedor.getId());

            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao atualizar fornecedor: " + ex.getMessage(),
                    "Erro ao atualizar",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    @Override
    public boolean deletar(Connection connection, Fornecedor fornecedor) {
        String comando = "DELETE FROM fornecedor WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(comando)) {
            stmt.setInt(1, fornecedor.getId());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
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
        String comando = "SELECT * FROM fornecedor WHERE id " + operador + " ? ";
        if (operador.equals("<")) {
            comando += " ORDER BY id DESC";
        }

        try (PreparedStatement stmt = connection.prepareStatement(comando)) {
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(res.getInt("id"));
                fornecedor.setNomeFantasia(res.getString("nome_fantasia"));
                fornecedor.setRazaoSocial(res.getString("razao_social"));
                fornecedor.setCnpj(res.getString("cnpj"));
                fornecedor.setInscricaoEstadual(res.getString("inscricao_estadual"));
                fornecedor.setCategoria(res.getString("categoria"));

                return fornecedor;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao buscar fornecedor: " + ex.getMessage(),
                    "Erro ao buscar",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return null;
    }
}

    
    

