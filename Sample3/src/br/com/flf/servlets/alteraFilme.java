package br.com.flf.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.jdbc.FilmeDAO;
import br.com.flf.models.Filme;

/**
 * Servlet implementation class alteraFilme
 */
@WebServlet("/alteraFilme")
public class alteraFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alteraFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		// pegando os parâmetros do request
		long id = Long.parseLong(request.getParameter("id"));
		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		int duracao = Integer.parseInt(request.getParameter("duracao"));
		float imdb = Float.parseFloat(request.getParameter("imdb"));
		String lancamento = request.getParameter("lancamento");
		
		Calendar data = null;
	    // fazendo a conversão da data
	    try {
	        Date date_lanc = (Date) new	 SimpleDateFormat("dd/mm/yyyy").parse(lancamento);
	        data = Calendar.getInstance();
	        data.setTime(date_lanc);
	    } catch (ParseException e) {
	        out.println("Erro de conversão da data");
	        return; //para a execução do método
	    }
	    
	    Filme novo_filme = new Filme();
        novo_filme.setTitulo(titulo);
        novo_filme.setGenero(genero);
        novo_filme.setDuracao(duracao);
        novo_filme.setIMDb(imdb);
        novo_filme.setLancamento(data);
        novo_filme.setId(id);
        
        FilmeDAO dao = new FilmeDAO();
        try {
			dao.altera(novo_filme);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        RequestDispatcher disp = request.getRequestDispatcher("listar-filme.jsp");
		disp.forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
