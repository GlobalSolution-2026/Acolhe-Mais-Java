package br.com.fiap.AcolheMais.repository;

import br.com.fiap.AcolheMais.model.Cidadao;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository do cidadão, com o SQL em JDBC sobre ACM_CIDADAO, sem regra de negócio.
 *
 * @author Nicolas Martins
 */
@Repository
public class CidadaoRepository {
    private DataSource dataSource;

    public CidadaoRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Cidadao inserir(Cidadao cidadao){
        try (Connection conexao = dataSource.getConnection()){

            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT SEQ_ACM_CIDADAO.NEXTVAL FROM DUAL");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt(1);

            String sql = "INSERT INTO ACM_CIDADAO (id_cidadao, nm_cidadao, nr_cns, nr_cpf, dt_nascimento, ds_sexo, nr_celular, nm_contato_recado, nr_contato_recado, nr_cep, tp_acesso, ds_senha_hash) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement1 = conexao.prepareStatement(sql);

            preparedStatement1.setInt(1, id);
            preparedStatement1.setString(2, cidadao.getNmCidadao());
            preparedStatement1.setString(3, cidadao.getNrCns());
            preparedStatement1.setString(4, cidadao.getNrCpf());
            preparedStatement1.setDate(5, Date.valueOf(cidadao.getDtNascimento()));
            preparedStatement1.setString(6, cidadao.getDsSexo());
            preparedStatement1.setString(7, cidadao.getNrCelular());
            preparedStatement1.setString(8, cidadao.getNmContatoRecado());
            preparedStatement1.setString(9, cidadao.getNrContatoRecado());
            preparedStatement1.setString(10, cidadao.getNrCep());
            preparedStatement1.setString(11, cidadao.getTpAcesso());
            preparedStatement1.setString(12, cidadao.getDsSenhaHash());

            preparedStatement1.executeUpdate();

            cidadao.setIdCidadao(id);
            return cidadao;

        }catch (SQLException e){
            throw new RuntimeException("Erro ao inserir cidadão", e);
        }
    }

    public List<Cidadao> listar(){
        List<Cidadao> lista = new ArrayList<>();
        try (Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM ACM_CIDADAO");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Cidadao cidadao = new Cidadao();
                cidadao.setIdCidadao(resultSet.getInt("id_cidadao"));
                cidadao.setNmCidadao(resultSet.getString("nm_cidadao"));
                cidadao.setNrCns(resultSet.getString("nr_cns"));
                cidadao.setNrCpf(resultSet.getString("nr_cpf"));
                cidadao.setDtNascimento(resultSet.getDate("dt_nascimento").toLocalDate());
                cidadao.setDsSexo(resultSet.getString("ds_sexo"));
                cidadao.setNrCelular(resultSet.getString("nr_celular"));
                cidadao.setNmContatoRecado(resultSet.getString("nm_contato_recado"));
                cidadao.setNrContatoRecado(resultSet.getString("nr_contato_recado"));
                cidadao.setNrCep(resultSet.getString("nr_cep"));
                cidadao.setTpAcesso(resultSet.getString("tp_acesso"));
                cidadao.setDsSenhaHash(resultSet.getString("ds_senha_hash"));
                lista.add(cidadao);
            }
            return lista;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao listar cidadãos", e);
        }
    }

    public Cidadao buscarPorId(int id){
        try (Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM ACM_CIDADAO WHERE id_cidadao = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Cidadao cidadao = new Cidadao();
                cidadao.setIdCidadao(resultSet.getInt("id_cidadao"));
                cidadao.setNmCidadao(resultSet.getString("nm_cidadao"));
                cidadao.setNrCns(resultSet.getString("nr_cns"));
                cidadao.setNrCpf(resultSet.getString("nr_cpf"));
                cidadao.setDtNascimento(resultSet.getDate("dt_nascimento").toLocalDate());
                cidadao.setDsSexo(resultSet.getString("ds_sexo"));
                cidadao.setNrCelular(resultSet.getString("nr_celular"));
                cidadao.setNmContatoRecado(resultSet.getString("nm_contato_recado"));
                cidadao.setNrContatoRecado(resultSet.getString("nr_contato_recado"));
                cidadao.setNrCep(resultSet.getString("nr_cep"));
                cidadao.setTpAcesso(resultSet.getString("tp_acesso"));
                cidadao.setDsSenhaHash(resultSet.getString("ds_senha_hash"));
                return cidadao;
            }
            return null;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao buscar cidadão", e);
        }
    }

    public Cidadao buscarPorCns(String nrCns){
        try (Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM ACM_CIDADAO WHERE nr_cns = ?");
            preparedStatement.setString(1, nrCns);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Cidadao cidadao = new Cidadao();
                cidadao.setIdCidadao(resultSet.getInt("id_cidadao"));
                cidadao.setNmCidadao(resultSet.getString("nm_cidadao"));
                cidadao.setNrCns(resultSet.getString("nr_cns"));
                cidadao.setNrCpf(resultSet.getString("nr_cpf"));
                cidadao.setDtNascimento(resultSet.getDate("dt_nascimento").toLocalDate());
                cidadao.setDsSexo(resultSet.getString("ds_sexo"));
                cidadao.setNrCelular(resultSet.getString("nr_celular"));
                cidadao.setNmContatoRecado(resultSet.getString("nm_contato_recado"));
                cidadao.setNrContatoRecado(resultSet.getString("nr_contato_recado"));
                cidadao.setNrCep(resultSet.getString("nr_cep"));
                cidadao.setTpAcesso(resultSet.getString("tp_acesso"));
                cidadao.setDsSenhaHash(resultSet.getString("ds_senha_hash"));
                return cidadao;
            }
            return null;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao buscar cidadão pelo CNS", e);
        }
    }

    public boolean atualizar(Cidadao cidadao){
        try (Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("UPDATE ACM_CIDADAO SET nm_cidadao=?, nr_cns=?, nr_cpf=?, dt_nascimento=?, ds_sexo=?, nr_celular=?, nm_contato_recado=?, nr_contato_recado=?, nr_cep=?, tp_acesso=?, ds_senha_hash=? WHERE id_cidadao=?");

            preparedStatement.setString(1, cidadao.getNmCidadao());
            preparedStatement.setString(2, cidadao.getNrCns());
            preparedStatement.setString(3, cidadao.getNrCpf());
            preparedStatement.setDate(4, Date.valueOf(cidadao.getDtNascimento()));
            preparedStatement.setString(5, cidadao.getDsSexo());
            preparedStatement.setString(6, cidadao.getNrCelular());
            preparedStatement.setString(7, cidadao.getNmContatoRecado());
            preparedStatement.setString(8, cidadao.getNrContatoRecado());
            preparedStatement.setString(9, cidadao.getNrCep());
            preparedStatement.setString(10, cidadao.getTpAcesso());
            preparedStatement.setString(11, cidadao.getDsSenhaHash());
            preparedStatement.setInt(12, cidadao.getIdCidadao());
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao atualizar cidadão", e);
        }
    }

    public boolean remover(int id){
        try (Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM ACM_CIDADAO WHERE id_cidadao = ?");
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao remover cidadão", e);
        }
    }

// cns = cartão nacional de saúde
    public boolean existeCns(String nrCns){
        try (Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT COUNT(*) FROM ACM_CIDADAO WHERE nr_cns = ?");
            preparedStatement.setString(1, nrCns);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao verificar CNS", e);
        }
    }

    public boolean existeCpf(String nrCpf){
        try (Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT COUNT(*) FROM ACM_CIDADAO WHERE nr_cpf = ?");
            preparedStatement.setString(1, nrCpf);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao verificar CPF", e);
        }
    }
}
