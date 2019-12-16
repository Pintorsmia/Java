package amazon.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amazon.java.Colis;
import amazon.java.ColisManagerInter;

@WebServlet("/EnregistrementServlet")
public class EnregistrementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ColisManagerInter ejb;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public EnregistrementServlet() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/Enregistrement.jsp").forward(request, response);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		float poids = Float.parseFloat(request.getParameter("poids"));
		float valeur = Float.parseFloat(request.getParameter("valeur"));
		String origine = request.getParameter("origine");
		String destination = request.getParameter("destination");

		Colis c = ejb.createColis(poids, valeur, origine, destination);

	//	PrintWriter out = response.getWriter();
	//	system.out.println("Creation Colis : " + c.getNumero());
		request.setAttribute("monColis",c);
		request.getRequestDispatcher("/Enregistrement.jsp").forward(request, response);
		

	}
}

