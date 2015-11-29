package repositorio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.sql.ResultSet;

import jdbc.conexaoBD;
import modelo.Historico;

public class HistoricoDAO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public void Inserir(Historico objHistorico){
		Connection conn = new conexaoBD().getConection();
		
		try{
			String sql = "INSERT INTO Historico (descricao, tipo) values(?,?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, objHistorico.getDescricao());
			stmt.setString(2, objHistorico.getTipo());
			
			stmt.execute();
		    System.out.print("Salvo");
			stmt.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
	public Historico PesquisarCodigo(long codigo){
		Connection conn = new conexaoBD().getConection();
		
		Historico objHistorico = new Historico();
		try{
			String sql = "SELECT descricao, tipo FROM Historico WHERE id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, codigo);
			
			ResultSet objRs = stmt.executeQuery();
			while (objRs.next()){
				objHistorico = new Historico();
				objHistorico.setId(objRs.getLong(0));
				objHistorico.setDescricao(objRs.getString(1));
				objHistorico.setTipo(objRs.getString(2));
			}
			objRs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objHistorico;
	}

	public void Alterar(Historico objHistorico){
		
		Connection conn = new conexaoBD().getConection();
		try{
			String sql = "UPDATE Historico SET descricao=?, tipo=? WHERE id=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, objHistorico.getDescricao());
			stmt.setString(2, objHistorico.getTipo());
			stmt.setLong(3, objHistorico.getId());
			
			stmt.execute();
			stmt.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void Excluir(long codigo){
		Connection conn = new conexaoBD().getConection();
		try{
			String sql = "DELETE FROM Historico WHERE id=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, codigo);
			
			stmt.execute();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public ArrayList<Historico> PesquisarTodos(){
		ArrayList<Historico> lstHistorico = new ArrayList<Historico>();
		
		Connection conn = new conexaoBD().getConection();
		
		try{
			String sql = "SELECT id, descricao, tipo, tipo FROM Historico";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet objRs = stmt.executeQuery();
			
			while (objRs.next()){
				Historico objHistorico = new Historico();
				objHistorico.setId(objRs.getLong(1));
				objHistorico.setDescricao(objRs.getString(2));
				objHistorico.setTipo(objRs.getString(3));
				
				lstHistorico.add(objHistorico);
			}
			objRs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lstHistorico;
	}
}
