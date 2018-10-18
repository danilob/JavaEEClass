package br.com.flf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fichaInteiro
 */
@WebServlet("/fichaInteiro")
public class fichaInteiro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fichaInteiro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int x = Integer.parseInt(request.getParameter("x"));
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Primeira Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Seu número é "+x+"!</h1>");
		if(x%2==0) {
			out.println("<h1>"+x+" é um número par!</h1>");
		}else {
			out.println("<h1>"+x+" é um número ímpar!</h1>");
		}
		String divisores = "";
		for(int i=1;i<=x;i++) {
			if(x%i==0) {
				divisores += i;
				if(x!=i) {
				   divisores +=", ";
				}
			}
		}
		out.println("<h1>Seus divisores são: "+divisores+"</h1>");
		
		int fatorial=x;
		for(int i=1;i<x;i++) {
			fatorial = fatorial * i; 
		}
		out.println("<h1>"+x+"! é igual a: "+fatorial+"</h1>");
		out.println("</body>");
		out.println("</html>");
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
