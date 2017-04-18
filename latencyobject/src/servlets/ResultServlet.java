package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.RandomTextFile;
import service.RandomTextZipp;
import utility.LatencyService;

/**
 * 
 * @author wfristdr
 * 
 * The Resultservlet shows a multitude of latency properties.
 * Total words of text file
 * Average words per line of text file
 * Text file create duration
 * The 5 copies of the text file create duration
 * 5 text files create zip duration
 * Minimum word create duration
 * Maximum word create duration
 * Average word create duration
 * Average line create duration
 * 
 */

public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String imagePathString;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		imagePathString = config.getInitParameter("image-path");
	}

	public ResultServlet() {

	}

	/**
	 * The result servlet doGet method contains the session attribute info of the 
	 * duration of the process.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String durationTotal = (String) session.getAttribute("durationTotal"); 
		String totalWordsOfFile = (String) session.getAttribute("totalWordsOfFile");
		String averageWordsPerLine = (String) session.getAttribute("averageWordsPerLine");
		String textCreateDuration = (String) session.getAttribute("textCreateDuration");
		String textFileCreateDuration = (String) session.getAttribute("textFileCreateDuration");
		String textCreateCopiesDuration = (String) session.getAttribute("textCreateCopiesDuration");
		String textCreateZipDuration = (String) session.getAttribute("textCreateZipDuration");
		String minimumWordCreateDuration = (String) session.getAttribute("minimumWordCreateDuration");
		String maximumWordCreateDuration = (String) session.getAttribute("maximumWordCreateDuration");
		String totalWordsaverageWordCreateDurationOfFile = (String) session.getAttribute("averageWordCreateDuration");
		String totaaverageLineCreateDurationlWordsOfFile = (String) session.getAttribute("averageLineCreateDuration");
		
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>ResultServlet</title>");
			out.println("</head>");
			out.println("<body><div align='middle'>");
			out.println("<h1>ResultServlet Latency Object at " + request.getContextPath() + "</h1>");
			out.println("<h5>The following data is a result of the previous process:</h5>");

			out.println("<ul align='left'>");
			out.println("<li>" + totalWordsOfFile + "</li>");
			out.println("<li>" + averageWordsPerLine + "</li>");
			out.println("<li>" + textCreateDuration + "</li>");
			out.println("<li>" + textFileCreateDuration + "</li>");
			out.println("<li>" + textCreateCopiesDuration + "</li>");
			out.println("<li>" + textCreateZipDuration + "</li>");
			out.println("<li>" + minimumWordCreateDuration + "</li>");
			out.println("<li>" + maximumWordCreateDuration + "</li>");
			out.println("<li>" + totalWordsaverageWordCreateDurationOfFile + "</li>");
			out.println("<li>" + totaaverageLineCreateDurationlWordsOfFile + "</li>");
			out.println("<li>" + durationTotal + "</li>");
			out.println("</ul>");
			
			out.println("<img src='" + request.getContextPath() + imagePathString + "'></img> </br>");
			out.println("<a href='" + request.getContextPath() + "/form'>Another one?</a>");
			out.println("</div></body>");
			out.println("</html>");
		}
		catch (IOException e) {
	            System.err.println("Caught IOException: " + e.getMessage());
	    } 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
