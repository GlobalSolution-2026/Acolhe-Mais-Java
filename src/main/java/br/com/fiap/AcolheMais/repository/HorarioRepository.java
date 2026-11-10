package br.com.fiap.AcolheMais.repository;

import br.com.fiap.AcolheMais.model.Horario;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Repository
public class HorarioRepository {
    private DataSource dataSource;

    public HorarioRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public Horario inserir(Horario horario){
        try (Connection conexao = dataSource.getConnection()){

            // pega o proximo id da sequence
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT SQ_ACM_HORARIO.NEXTVAL FROM DUAL");
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
}
