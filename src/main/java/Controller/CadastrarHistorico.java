package Controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.faces.view.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import modelo.Historico;
import repositorio.HistoricoDAO;
import util.FacesMessages;

@ManagedBean
@javax.faces.bean.ViewScoped
//@Named
//@ViewScoped
public class CadastrarHistorico implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    
	private HistoricoDAO historicoDao;
	private FacesMessages messages = new FacesMessages();
	private Historico objHistorico;
	private ArrayList<Historico> historico;
	private Historico historicoSelecionado;
	private long codigoBusca;
	private ArrayList<Historico> historicoFiltrado;
	
	
	public void buscar()
	{
		System.out.println("Codigo de busca:" + codigoBusca);
		historicoDao = new HistoricoDAO();
		historico = new ArrayList<Historico>();
		historico.add(historicoDao.PesquisarCodigo(codigoBusca));
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs","frm:tabelaHistorico"));
		
	}

    
    public void clearHistorico()
    {
    	objHistorico = new Historico();
    }
  
	public void getHistoricos()
	{
		historicoDao = new HistoricoDAO();
		historico = historicoDao.PesquisarTodos();
	}
	
	public void salvarHistorico()
	{		
		historicoDao = new HistoricoDAO();
		historicoDao.Inserir(objHistorico);
		messages.info("Histórico salvo com sucesso!");
		getHistoricos();
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs","frm:tabelaHistorico"));
	}
	
	public void alterarHistorico()
	{
		historicoDao = new HistoricoDAO();
		historicoDao.Alterar(objHistorico);
		messages.info("Histórico alterado com sucesso!");
		getHistoricos();
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs","frm:tabelaHistorico"));
	}
	
	public void removerHistorico()
	{
		historicoDao = new HistoricoDAO();
		objHistorico = historicoSelecionado;
		historicoDao.Excluir(objHistorico.getId());
		messages.info("Histórico removido com sucesso!");
		getHistoricos();
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs","frm:tabelaHistorico"));
		System.out.print("Excluir");
	}
	
	
	public long getCodigoBusca() {
		return codigoBusca;
	}

	public void setCodigoBusca(long codigoBusca) {
		this.codigoBusca = codigoBusca;
	}
	
	public void getHistoricoParaAlterar()
	{
	    objHistorico = historicoSelecionado; 
	}
	
	public Historico getObjHistorico() {
		return objHistorico;
	}

	public void setObjHistorico(Historico objHistorico) {
		this.objHistorico = objHistorico;
	}
	
	public List<Historico> getHistorico() {
		return historico;
	}
	
	public void setHistorico(ArrayList<Historico> historico) {
		this.historico = historico;
	}

	public Historico getHistoricoSelecionado() {
		return historicoSelecionado;
	}

	public void setHistoricoSelecionado(Historico historicoSelecionado) {
		this.historicoSelecionado = historicoSelecionado;
	}


	public ArrayList<Historico> getHistoricoFiltrado() {
		return historicoFiltrado;
	}


	public void setHistoricoFiltrado(ArrayList<Historico> historicoFiltrado) {
		this.historicoFiltrado = historicoFiltrado;
	}
	
	
	

}
