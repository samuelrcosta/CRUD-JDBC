package dw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarroModel {
	private Integer codigo;
	private String marca;
	private String nome;
	private Integer ano;
	private Integer potencia;
  
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
  
	public Integer getPotencia() {
		return potencia;
	}
	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}

	private static Connection obterConexao() throws SQLException {
	    //Estabelecer uma conexão com o banco de dados.
	    String url = "jdbc:derby://localhost:1527/carrodb;create=true";
	    String user = "app";
	    String password = "app";
	    return DriverManager.getConnection(url, user, password);
	}

	public void incluir() throws SQLException {
	    Connection conn = obterConexao();
	    
	    //Obter sentença SQL.
	    String sql = "insert into carro (codigo, marca, nome, ano, potencia) values (?, ?, ?, ?, ?)";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setInt(1, codigo);
	    pstmt.setString(2, marca);
	    pstmt.setString(3, nome);
	    pstmt.setInt(4, ano);
	    pstmt.setInt(5, potencia);
	    pstmt.execute();
	}

	public void salvar() throws SQLException {
	    Connection conn = obterConexao();
	
	    //Obter sentença SQL.
	    String sql = "update carro set marca = ?, nome = ?, ano = ?, potencia = ? where codigo = ?";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, marca);
	    pstmt.setString(2, nome);
	    pstmt.setInt(3, ano);
	    pstmt.setInt(4, potencia);
	    pstmt.setInt(5, codigo);
	    pstmt.execute();
	}

	public void excluir() throws SQLException {
	    Connection conn = obterConexao();
	    
	    //Obter sentença SQL.
	    String sql = "delete from carro where codigo = ?";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setInt(1, codigo);
	    pstmt.execute();
	}

	public static List<CarroModel> listar() throws SQLException {
	    Connection conn = obterConexao();
	    
	    Statement stmt = conn.createStatement();
	    String sql = "select codigo, marca, nome, ano, potencia from carro order by codigo";
	    ResultSet rs = stmt.executeQuery(sql);
	  
	    List<CarroModel> listaDeCarros = new ArrayList<CarroModel>();
	    while (rs.next()) {
	    	// Cria um carro para o registro.
	    	CarroModel carro = new CarroModel();
	    	carro.setCodigo(rs.getInt("codigo"));
	    	carro.setMarca(rs.getString("marca"));
	    	carro.setNome(rs.getString("nome"));
	    	carro.setAno(rs.getInt("ano"));
	    	carro.setPotencia(rs.getInt("potencia"));
	    	// Adiciona o carro na lista de carros.
	    	listaDeCarros.add(carro);
	    }
	    return listaDeCarros;
	}
}