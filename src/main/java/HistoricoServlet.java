import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Historico;
import repositorio.HistoricoDAO;

/**
 * Servlet implementation class HistoricoServlet
 */
@WebServlet("/gravarHistorico")
public class HistoricoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoricoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {//esse metodo recebe uma info ou retornando info atraves do tomcat.
		// TODO Auto-generated method stub
		
		   String txtDescricao = request.getParameter("txtDescricao");
		   String rdbTipo = request.getParameter("rdbTipo");
		   
		   Historico objHistorico = new Historico();
		   objHistorico.setDescricao(txtDescricao);
		   objHistorico.setTipo(rdbTipo);
		   
		   HistoricoDAO objHistoricoDAO = new HistoricoDAO();
		   objHistoricoDAO.Inserir(objHistorico);
		   
		   response.setCharacterEncoding("UTF-8");
		   PrintWriter Retorno = response.getWriter();
		   Retorno.append("<html><head><title>Inclusao de Historico</title></head>");
		   Retorno.append("<body>");
		   Retorno.append("<h1>Historico "+ txtDescricao+ "inserido com sucesso!</h1>");
		   Retorno.append("</body>");
		   Retorno.append("</html>");
		 
		   
		   
		   
		   
		   
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}
	
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
