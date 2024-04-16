package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionFactory;
import entities.Product;

public class ProductDao {
	
	private Connection connection;
	
	public ProductDao() {
		connection = new ConnectionFactory().getConnection();
	}

	public Product findById(Integer id) {
		String sql = "SELECT * FROM geral.produto "
				+ "WHERE idproduto = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Product product = new Product(rs.getInt("idproduto"),
						rs.getString("descricao"),
						rs.getDouble("vlcusto"),
						rs.getDouble("vlvenda"),
						rs.getString("categoria"));
				return product;
			}
			
			rs.close();
			ps.close();
			connection.close();	
		}
		
		catch (SQLException e) {
			System.out.println("Erro ao buscar o produto! ");
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> findAll() {
		String sql = "SELECT * FROM geral.produto";
		List<Product> products = new ArrayList<>();
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Product product = new Product(rs.getInt("idproduto"),
						rs.getString("descricao"),
						rs.getDouble("vlcusto"),
						rs.getDouble("vlvenda"),
						rs.getString("categoria"));
				products.add(product);
			}
			rs.close();
			ps.close();
			connection.close();
		}
		catch (SQLException e) {
			System.out.println("Erro ao buscar os produtos! ");
			e.printStackTrace();
		}
		return products;
	}


}
