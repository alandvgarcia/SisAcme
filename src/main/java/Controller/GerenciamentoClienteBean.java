package Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import modelo.Cliente;
import repositorio.ClienteDAO;
import util.FacesMessages;


@ManagedBean
@ViewScoped
public class GerenciamentoClienteBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Cliente cliente;
	ClienteDAO clienteDao;
	ArrayList<Cliente> clientesList;
	Cliente clienteSelecionado;
	FacesMessages messages = new FacesMessages();
	
    
    public void clear()
    {
    	cliente = new Cliente();
    }
  
	public void getTable()
	{
		clienteDao = new ClienteDAO();
		clientesList = clienteDao.PesquisarTodos();
	}
	
	public void getParaAlterar()
	{
		cliente = clienteSelecionado;
	}
	
	public void salvar()
	{		
		clienteDao = new ClienteDAO();
		clienteDao.Inserir(cliente);
		messages.info("Cliente salvo com sucesso!");
		getTable();
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs","frm:tabelaCliente"));
	}
	
	public void alterar()
	{
		clienteDao = new ClienteDAO();
		clienteDao.Alterar(cliente);
		messages.info("Cliente alterado com sucesso!");
		getTable();
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs","frm:tabelaCliente"));
	}
	
	public void remover()
	{
		clienteDao = new ClienteDAO();
		cliente = clienteSelecionado;
		clienteDao.Excluir(cliente.getId());
		messages.info("Cliente removido com sucesso!");
		getTable();
		clienteSelecionado = null;
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs","frm:tabelaCliente","frm:toolbar"));
		System.out.print("Excluir");
		clear();
	}
	
	
	
	public ArrayList<Cliente> getClientesList() {
		return clientesList;
	}

	public void setClientesList(ArrayList<Cliente> clientes) {
		this.clientesList = clientes;
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	
	

}
