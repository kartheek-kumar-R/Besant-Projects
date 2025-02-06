package leaguePackage;

import jakarta.servlet.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * Servlet implementation class AddLeagueServlet
 */
@WebServlet("/AddLeagueServlet")
public class AddLeagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLeagueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String yearString = request.getParameter("year");
		String season = request.getParameter("season");
		String title = request.getParameter("title");
		
		ArrayList<String> errormsg = new ArrayList<String>();
		
		try 
		{
			 @SuppressWarnings("unused")
			int year=Integer.parseInt(yearString);
		}
		catch (NumberFormatException nfe)
		{
			errormsg.add("Please Enter a valid year");
		}
		
			if(season.equals("UNKNOWN"))
			{
			errormsg.add("Please Enter the Season");
			}
		if(!errormsg.isEmpty())
		{
			RequestDispatcher rd1 = request.getRequestDispatcher("ErrorServlet");
			request.setAttribute("errormsg", errormsg);
			rd1.forward(request, response);
		}
		else
		{
			FileWriter fw = new FileWriter("D:/java installation/work-space/LeagueApp/src/main/webapp/WEB-INF/league.txt",true);
			BufferedWriter bw=new BufferedWriter(fw);
			try
			{
				String str = yearString+","+season+","+title+"\n";
				bw.write(str);
				bw.flush();
				fw.flush();
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
			finally
			{
				try
				{
					bw.close();
					fw.close();
				}
				catch(IOException ioe)
				{
					ioe.printStackTrace();
				}
			}
			

			RequestDispatcher rd2 = request.getRequestDispatcher("SuccessServlet");
			int year=Integer.parseInt(yearString);
			League l = new League(year,season,title);
			request.setAttribute("league", l);
			rd2.forward(request, response);
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
