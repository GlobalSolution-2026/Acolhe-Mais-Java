package br.com.fiap.AcolheMais.repository;

import br.com.fiap.AcolheMais.model.Unidade;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository da unidade, com o SQL em JDBC sobre ACM_UNIDADE.
 *
 * @author Nicolas Martins
 */
@Repository
public class UnidadeRepository {
    private DataSource dataSource;

    public UnidadeRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    // esse método pega o próximo id da sequence e grava a nova unidade no banco
    public Unidade inserir(Unidade unidade){
        try (Connection conexao = dataSource.getConnection()){

            // pega o proximo id da sequence
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT SEQ_ACM_UNIDADE.NEXTVAL FROM DUAL");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt(1);

            String sql = "INSERT INTO ACM_UNIDADE (id_unidade, nm_unidade, tp_unidade, ds_endereco, nr_cep, nr_telefone) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement1 = conexao.prepareStatement(sql);

            preparedStatement1.setLong(1, id);
            preparedStatement1.setString(2, unidade.getNmUnidade());
            preparedStatement1.setString(3, unidade.getTpUnidade());
            preparedStatement1.setString(4, unidade.getDsEndereco());
            preparedStatement1.setString(5, unidade.getNrCep());
            preparedStatement1.setString(6, unidade.getNrTelefone());
            preparedStatement1.executeUpdate();

            unidade.setIdUnidade(id);
            return unidade;

        }catch (SQLException e){
            throw new RuntimeException("Erro ao inserir unidade", e);
        }
    }

    // esse método busca todas as unidades no banco
    public List<Unidade> listar(){
        List<Unidade> lista = new ArrayList<>();
        try (Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM ACM_UNIDADE");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Unidade unidade = new Unidade();
                unidade.setIdUnidade(resultSet.getInt("id_unidade"));
                unidade.setNmUnidade(resultSet.getString("nm_unidade"));
                unidade.setTpUnidade(resultSet.getString("tp_unidade"));
                unidade.setDsEndereco(resultSet.getString("ds_endereco"));
                unidade.setNrCep(resultSet.getString("nr_cep"));
                unidade.setNrTelefone(resultSet.getString("nr_telefone"));
                lista.add(unidade);
            }
            return lista;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao listar unidades", e);
        }
    }

    // esse método busca uma unidade pelo id e devolve null se não achar
    public Unidade buscarPorId(int id){
        try(Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM ACM_UNIDADE WHERE id_unidade = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Unidade unidade = new Unidade();
                unidade.setIdUnidade(resultSet.getInt("id_unidade"));
                unidade.setNmUnidade(resultSet.getString("nm_unidade"));
                unidade.setTpUnidade(resultSet.getString("tp_unidade"));
                unidade.setDsEndereco(resultSet.getString("ds_endereco"));
                unidade.setNrCep(resultSet.getString("nr_cep"));
                unidade.setNrTelefone(resultSet.getString("nr_telefone"));
                return unidade;
            }
            return null; // devolve null se nao achar
        }catch (SQLException e){
            throw new RuntimeException("Erro ao buscar unidade", e);
        }
    }

    // esse método altera os dados da unidade no banco
    public boolean atualizar(Unidade unidade){
        try(Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("UPDATE ACM_UNIDADE SET nm_unidade=?, tp_unidade=?, ds_endereco=?, nr_cep=?, nr_telefone=? WHERE id_unidade=?");

            preparedStatement.setString(1, unidade.getNmUnidade());
            preparedStatement.setString(2, unidade.getTpUnidade());
            preparedStatement.setString(3, unidade.getDsEndereco());
            preparedStatement.setString(4, unidade.getNrCep());
            preparedStatement.setString(5, unidade.getNrTelefone());
            preparedStatement.setLong(6, unidade.getIdUnidade());
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao atualizar unidade", e);
        }
    }

    // esse método apaga a unidade do banco
    public boolean remover(int id){
        try (Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM ACM_UNIDADE WHERE id_unidade = ?");
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao remover unidade", e);
        }
    }
}
