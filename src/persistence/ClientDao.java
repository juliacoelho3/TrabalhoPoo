package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionFactory;
import entities.Client;

public class ClientDao {

	private Connection connection;

	public ClientDao() {
		connection = new ConnectionFactory().getConnection();
	}

	public Client findById(Integer id) {
		String sql = "SELECT * FROM geral.cliente "
				+ "WHERE idcliente = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Client client = new Client(rs.getString("nome"), 
						rs.getString("endereco"), 
						rs.getString("telefone"),
						rs.getInt("idcliente"), 
						rs.getString("cpf"),
					    rs.getDate("dtnascimento"));
				
				rs.close();
				ps.close();
				connection.close();
				
				return client;
			}
			rs.close();
			ps.close();
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar cliente! ");
			e.printStackTrace();
		}
		return null;
	}

	public List<Client> findByName(String name, int search) {
		String sql;
		if (search == 1) {
			sql = "select * from cliente where nome like '" + name + "%'";
		} else if (search == 2) {
			sql = "select * from cliente where nome like '%" + name + "'";
		} else {
			sql = "select * from cliente where nome like '%" + name + "%'";
		}

		List<Client> clientes = new ArrayList<>();

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Client client = new Client(rs.getString("name"), 
						rs.getString("address"), 
						rs.getString("phoneNumber"),
						rs.getInt("idcliente"),
						rs.getString("cpf"), 
						rs.getDate("birthdate"));
				clientes.add(client);
			}

			rs.close();
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			System.err.println("Erro ao buscar cliente!");
			e.printStackTrace();
		}
		return clientes;
	}
	
	public List<Client> findAll() {
	    String sql = "select * from cliente";
	    List<Client> clients = new ArrayList<>();
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	        	Client client = new Client(rs.getString("name"), 
						rs.getString("address"), 
						rs.getString("phoneNumber"),
					    rs.getInt("idcliente"),
						rs.getString("cpf"), 
						rs.getDate("birthdate"));
	            clients.add(client);
	        }
	        
	        stmt.close();
	        rs.close();
	        connection.close();
	        
	    } catch (SQLException e) {
	        System.out.println("Erro ao listar clientes!");
	        e.printStackTrace();
	    }
	    return clients;
	}


}