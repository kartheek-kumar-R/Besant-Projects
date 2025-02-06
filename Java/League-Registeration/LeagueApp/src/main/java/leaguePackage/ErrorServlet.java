package leaguePackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class ErrorServlet
 */
@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		@SuppressWarnings("unchecked")
		ArrayList<String> errorMsgs = (ArrayList<String>)request.getAttribute("errormsg");
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		out.println("<H1>Please fix the following errors:</h1>");
		
		out.println("<ul>");
		
		for(String msg:errorMsgs)
		{	
			out.println("<li>"+msg+"</li>");
		}
		
		out.println("</ul>");
		
		out.println("<form action=\"AddLeagueServlet\" method=\"GET\">\r\n"
				+ "\r\n"
				+ "<fieldset>\r\n"
				+ "<legend>League Form:</legend>\r\n"
				+ "\r\n"
				+ "<label>Year:</label><input type=\"text\" name=\"year\"><br>\r\n"
				+ "<label>Season:</label><select name=\"season\">\r\n"
				+ "<option value=\"UNKNOWN\">Select...</option>\r\n"
				+ "<option value=\"summer\">summer</option>\r\n"
				+ "<option value=\"winter\">winter</option>\r\n"
				+ "<option value=\"autumn\">autumn</option>\r\n"
				+ "<option value=\"spring\">spring</option>\r\n"
				+ "</select>\r\n"
				+ "<br>\r\n"
				+ "<label>Title:</label><input type=\"text\" name=\"title\"><br>\r\n"
				+ "<input type=\"submit\" value=\"submit\">\r\n"
				+ "</fieldset>\r\n"
				+ "</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
