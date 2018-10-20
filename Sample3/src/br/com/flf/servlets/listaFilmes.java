package br.com.flf.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.jdbc.FilmeDAO;
import br.com.flf.models.Filme;

/**
 * Servlet implementation class listaFilmes
 */
@WebServlet("/listaFilmes")
public class listaFilmes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listaFilmes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		FilmeDAO dao = new FilmeDAO();
		List<Filme> rows;
		try {
			rows = dao.getFilmes();
		
		out.println("<html>");
        out.println("<body>");
        try {
			out.println("Quantidade de Filmes cadastrados: " + rows.size());
			if (rows.size()>0)
			for (int i = 0; i < rows.size(); i++) {
				out.println("<li> id:"+rows.get(i).getId()+" - "+rows.get(i).getTitulo()+"</li>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        out.println("</body>");
        out.println("</html>");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
