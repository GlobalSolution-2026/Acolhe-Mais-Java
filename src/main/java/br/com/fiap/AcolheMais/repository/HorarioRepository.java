package br.com.fiap.AcolheMais.repository;

import br.com.fiap.AcolheMais.model.Horario;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HorarioRepository {
    private DataSource dataSource;

    public HorarioRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public Horario inserir(Horario horario){
        try (Connection conexao = dataSource.getConnection()){

            // pega o proximo id da sequence
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT SEQ_ACM_HORARIO.NEXTVAL FROM DUAL");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt(1);

            String sql = "INSERT INTO ACM_HORARIO (id_horario, id_unidade, dt_horario, nr_duracao_min) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement1 = conexao.prepareStatement(sql);

            preparedStatement1.setLong(1, id);
            preparedStatement1.setInt(2, horario.getIdUnidade());
            preparedStatement1.setTimestamp(3, Timestamp.valueOf(horario.getDtHorario()));
            preparedStatement1.setInt(4,  horario.getNrDuracaoMinuto());

            preparedStatement1.executeUpdate();

            horario.setIdHorario(id);
            return horario;

        }catch (SQLException e){
            throw new RuntimeException("Erro ao inserir horário", e);
        }
    }
    public List<Horario> listar(){
        List<Horario> lista = new ArrayList<>();
        try(Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM ACM_HORARIO");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Horario horario = new Horario();
                horario.setIdHorario(resultSet.getInt("id_horario"));
                horario.setIdUnidade(resultSet.getInt("id_unidade"));
                horario.setDtHorario(resultSet.getTimestamp("dt_horario").toLocalDateTime());
                horario.setNrDuracaoMinuto(resultSet.getInt("nr_duracao_min"));
                lista.add(horario);
            }
            return lista;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao listar horários", e);
        }
    }

    public List<Horario> listarPorUnidade(int idUnidade){
        List<Horario> lista = new ArrayList<>();
        try(Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM ACM_HORARIO WHERE id_unidade = ?");
            preparedStatement.setInt(1, idUnidade);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Horario horario = new Horario();
                horario.setIdHorario(resultSet.getInt("id_horario"));
                horario.setIdUnidade(resultSet.getInt("id_unidade"));
                horario.setDtHorario(resultSet.getTimestamp("dt_horario").toLocalDateTime());
                horario.setNrDuracaoMinuto(resultSet.getInt("nr_duracao_min"));
                lista.add(horario);
            }
            return lista;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao listar horários da unidade", e);
        }
    }

    public Horario buscarPorId(int id){
        try(Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM ACM_HORARIO WHERE id_horario = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Horario horario = new Horario();
                horario.setIdHorario(resultSet.getInt("id_horario"));
                horario.setIdUnidade(resultSet.getInt("id_unidade"));
                horario.setDtHorario(resultSet.getTimestamp("dt_horario").toLocalDateTime());
                horario.setNrDuracaoMinuto(resultSet.getInt("nr_duracao_min"));
                return horario;
            }
            return null;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao buscar horário", e);
        }
    }

    public boolean atualizar(Horario horario){
        try(Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("UPDATE ACM_HORARIO SET dt_horario=?, nr_duracao_min=? WHERE id_horario=?");

            preparedStatement.setTimestamp(1, Timestamp.valueOf(horario.getDtHorario()));
            preparedStatement.setInt(2, horario.getNrDuracaoMinuto());
            preparedStatement.setInt(3, horario.getIdHorario());
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao atualizar horário", e);
        }
    }

    public boolean remover(int id){
        try (Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM ACM_HORARIO WHERE id_horario = ?");
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao remover horário", e);
        }
    }

    public boolean existeHorario(int idUnidade, LocalDateTime dtHorario){
        try(Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT COUNT(*) FROM ACM_HORARIO WHERE id_unidade = ? AND dt_horario = ?");
            preparedStatement.setInt(1, idUnidade);
            preparedStatement.setTimestamp(2, Timestamp.valueOf(dtHorario));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao verificar horário duplicado", e);
        }
    }

    public boolean unidadePossuiHorarios(int idUnidade){
        try(Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT COUNT(*) FROM ACM_HORARIO WHERE id_unidade = ?");
            preparedStatement.setInt(1, idUnidade);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao verificar horários da unidade", e);
        }
    }
}
