package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import entities.Pessoa;
import factories.ConnectionFactory;
import interfaces.IRepository;

public class PessoaRepository implements IRepository<Pessoa> {

	@Override
	public void save(Pessoa entity) throws Exception {

		// abrir conexão com banco de dados
		Connection connection = ConnectionFactory.getConnection();

		// cadastrando pessoa na tabela do banco de dados
		PreparedStatement statement = connection.prepareStatement("insert into pessoa(nome, email) values(?,?)");
		statement.setString(1, entity.getNome());
		statement.setString(2, entity.getEmail());
		statement.execute();

		connection.close();
	}

	@Override
	public void update(Pessoa entity) throws Exception {

	}

	@Override
	public void delete(Pessoa entity) throws Exception {

	}

	@Override
	public List<Pessoa> findAll() throws Exception {

		return null;
	}

	@Override
	public Pessoa findById(Integer id) throws Exception {

		return null;
	}

}
