package repositorio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.conexaoBD;
import modelo.Cliente;
import modelo.Historico;

public class ClienteDAO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void Inserir(Cliente objCliente){
		Connection conn = new conexaoBD().getConection();
		
		try{
			String sql = "INSERT INTO Cliente (CPF,Estado,Cidade,Email,Endereco,nome,Telefone) values(?,?,?,?,?,?,?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, objCliente.getCPF());
			stmt.setString(2, objCliente.getEstado());
			stmt.setString(3, objCliente.getCidade());
			stmt.setString(4, objCliente.getEmail());
			stmt.setString(5, objCliente.getEndereco());
			stmt.setString(6, objCliente.getNome());
			stmt.setString(7, objCliente.getTelefone());
				
			stmt.execute();
		    System.out.print("Salvo");
			stmt.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
	public Cliente PesquisarCodigo(int codigo){
		Connection conn = new conexaoBD().getConection();
		
		Cliente objCliente = null;
		try{
			String sql = "SELECT DesHis, TipHis FROM historico WHERE id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, codigo);
			
			ResultSet objRs = stmt.executeQuery();
			while (objRs.next()){
				//objCliente = new Historico();
				//objCliente.setId(objRs.getLong(0));
				//objCliente.setDescricao(objRs.getString(1));
				//objCliente.setTipo(objRs.getString(2));
			}
			objRs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public void Alterar(Cliente objCliente){
		
		Connection conn = new conexaoBD().getConection();
		try{
			String sql = "UPDATE Cliente SET CPF = ?,Estado = ?,Cidade = ?,Email = ?,Endereco = ?,nome = ?,Telefone = ? WHERE id = ?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, objCliente.getCPF());
			stmt.setString(2, objCliente.getEstado());
			stmt.setString(3, objCliente.getCidade());
			stmt.setString(4, objCliente.getEmail());
			stmt.setString(5, objCliente.getEndereco());
			stmt.setString(6, objCliente.getNome());
			stmt.setString(7, objCliente.getTelefone());
			stmt.setLong(8, objCliente.getId());
			
			
			stmt.execute();
			stmt.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void Excluir(long codigo){
		Connection conn = new conexaoBD().getConection();
		try{
			String sql = "DELETE FROM Cliente WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, codigo);
			stmt.execute();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Cliente> PesquisarTodos(){
		ArrayList<Cliente> lstCliente = new ArrayList<Cliente>();
		
		Connection conn = new conexaoBD().getConection();
		
		try{
			String sql = "SELECT id,CPF,Estado,Cidade,Email,Endereco,nome,Telefone FROM Cliente;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet objRs = stmt.executeQuery();
			
			while (objRs.next()){
				Cliente objCliente = new Cliente();
				objCliente.setId(objRs.getLong(1));
				objCliente.setCPF(objRs.getString(2));
				objCliente.setEstado(objRs.getString(3));
				objCliente.setCidade(objRs.getString(4));
				objCliente.setEmail(objRs.getString(5));
				objCliente.setEndereco(objRs.getString(6));
				objCliente.setNome(objRs.getString(7));
				objCliente.setTelefone(objRs.getString(8));
				
				
				lstCliente.add(objCliente);
			}
			objRs.close();
			stmt.close();
			conn.close();
			System.out.println("Lista de Clientes Pega com Sucesso");
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstCliente;
	}

}
