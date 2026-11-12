package br.com.fiap.AcolheMais.repository;

import br.com.fiap.AcolheMais.model.Consulta;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConsultaRepository {
    private DataSource dataSource;

    public ConsultaRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Consulta inserir(Consulta consulta){
        try (Connection conexao = dataSource.getConnection()){

            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT SQ_ACM_CONSULTA.NEXTVAL FROM DUAL");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt(1);

            String sql = "INSERT INTO ACM_CONSULTA (id_consulta, id_horario, id_cidadao, id_orientacao, dt_agendamento, dt_confirmacao, ds_status, vl_prob_falta, ds_risco_falta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement1 = conexao.prepareStatement(sql);

            preparedStatement1.setInt(1, id);
            preparedStatement1.setInt(2, consulta.getIdHorario());
            preparedStatement1.setInt(3, consulta.getIdCidadao());

            if (consulta.getIdOrientacao() == null) {
                preparedStatement1.setNull(4, Types.INTEGER);
            } else {
                preparedStatement1.setInt(4, consulta.getIdOrientacao());
            }

            preparedStatement1.setTimestamp(5, Timestamp.valueOf(consulta.getDtAgendamento()));

            if (consulta.getDtConfirmacao() == null) {
                preparedStatement1.setNull(6, Types.TIMESTAMP);
            } else {
                preparedStatement1.setTimestamp(6, Timestamp.valueOf(consulta.getDtConfirmacao()));
            }

            preparedStatement1.setString(7, consulta.getDsStatus());

            if (consulta.getVlProbFalta() == null) {
                preparedStatement1.setNull(8, Types.DOUBLE);
            } else {
                preparedStatement1.setDouble(8, consulta.getVlProbFalta());
            }

            preparedStatement1.setString(9, consulta.getDsRiscoFalta());

            preparedStatement1.executeUpdate();

            consulta.setIdConsulta(id);
            return consulta;

        }catch (SQLException e){
            throw new RuntimeException("Erro ao inserir consulta", e);
        }
    }

    public List<Consulta> listar(){
        List<Consulta> lista = new ArrayList<>();
        try (Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM ACM_CONSULTA");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Consulta consulta = new Consulta();
                consulta.setIdConsulta(resultSet.getInt("id_consulta"));
                consulta.setIdHorario(resultSet.getInt("id_horario"));
                consulta.setIdCidadao(resultSet.getInt("id_cidadao"));

                int idOrientacao = resultSet.getInt("id_orientacao");
                if (!resultSet.wasNull()) {
                    consulta.setIdOrientacao(idOrientacao);
                }

                consulta.setDtAgendamento(resultSet.getTimestamp("dt_agendamento").toLocalDateTime());

                Timestamp dtConfirmacao = resultSet.getTimestamp("dt_confirmacao");
                if (dtConfirmacao != null) {
                    consulta.setDtConfirmacao(dtConfirmacao.toLocalDateTime());
                }

                consulta.setDsStatus(resultSet.getString("ds_status"));

                double vlProbFalta = resultSet.getDouble("vl_prob_falta");
                if (!resultSet.wasNull()) {
                    consulta.setVlProbFalta(vlProbFalta);
                }

                consulta.setDsRiscoFalta(resultSet.getString("ds_risco_falta"));
                lista.add(consulta);
            }
            return lista;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao listar consultas", e);
        }
    }

    public Consulta buscarPorId(int id){
        try (Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM ACM_CONSULTA WHERE id_consulta = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Consulta consulta = new Consulta();
                consulta.setIdConsulta(resultSet.getInt("id_consulta"));
                consulta.setIdHorario(resultSet.getInt("id_horario"));
                consulta.setIdCidadao(resultSet.getInt("id_cidadao"));

                int idOrientacao = resultSet.getInt("id_orientacao");
                if (!resultSet.wasNull()) {
                    consulta.setIdOrientacao(idOrientacao);
                }

                consulta.setDtAgendamento(resultSet.getTimestamp("dt_agendamento").toLocalDateTime());

                Timestamp dtConfirmacao = resultSet.getTimestamp("dt_confirmacao");
                if (dtConfirmacao != null) {
                    consulta.setDtConfirmacao(dtConfirmacao.toLocalDateTime());
                }

                consulta.setDsStatus(resultSet.getString("ds_status"));

                double vlProbFalta = resultSet.getDouble("vl_prob_falta");
                if (!resultSet.wasNull()) {
                    consulta.setVlProbFalta(vlProbFalta);
                }

                consulta.setDsRiscoFalta(resultSet.getString("ds_risco_falta"));
                return consulta;
            }
            return null;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao buscar consulta", e);
        }
    }

    public boolean atualizar(Consulta consulta){
        try (Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("UPDATE ACM_CONSULTA SET id_horario=?, id_cidadao=?, id_orientacao=?, dt_agendamento=?, dt_confirmacao=?, ds_status=?, vl_prob_falta=?, ds_risco_falta=? WHERE id_consulta=?");

            preparedStatement.setInt(1, consulta.getIdHorario());
            preparedStatement.setInt(2, consulta.getIdCidadao());

            if (consulta.getIdOrientacao() == null) {
                preparedStatement.setNull(3, Types.INTEGER);
            } else {
                preparedStatement.setInt(3, consulta.getIdOrientacao());
            }

            preparedStatement.setTimestamp(4, Timestamp.valueOf(consulta.getDtAgendamento()));

            if (consulta.getDtConfirmacao() == null) {
                preparedStatement.setNull(5, Types.TIMESTAMP);
            } else {
                preparedStatement.setTimestamp(5, Timestamp.valueOf(consulta.getDtConfirmacao()));
            }

            preparedStatement.setString(6, consulta.getDsStatus());

            if (consulta.getVlProbFalta() == null) {
                preparedStatement.setNull(7, Types.DOUBLE);
            } else {
                preparedStatement.setDouble(7, consulta.getVlProbFalta());
            }

            preparedStatement.setString(8, consulta.getDsRiscoFalta());
            preparedStatement.setInt(9, consulta.getIdConsulta());
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao atualizar consulta", e);
        }
    }

    public boolean remover(int id){
        try (Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM ACM_CONSULTA WHERE id_consulta = ?");
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao remover consulta", e);
        }
    }

    public boolean horarioOcupado(int idHorario){
        try (Connection conexao = dataSource.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT COUNT(*) FROM ACM_CONSULTA WHERE id_horario = ? AND ds_status IN ('AGENDADA', 'CONFIRMADA')");
            preparedStatement.setInt(1, idHorario);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao verificar horário ocupado", e);
        }
    }
}
