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
import utility.DirectoryNotCreatedException;
import utility.LatencyService;

/**
 * 
 * @author wfristdr
 * 
 * The FormServlet invokes the ZipServlet and starts the file saving zip process.
 * All measured latency properties of the created text, the 5 files and the zip-file
 * to be saved at the local disk will be saved into the session. 
 * Those attributes will be displayed at a next servlet together with the duration of the web-interface.
 * The process may be repeated many times in order to revise the results.
 *
 */

public class ZipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String imagePathString;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		imagePathString = config.getInitParameter("image-path");
	}

	public ZipServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String lineSize = request.getParameter("lineSize");

		RandomTextFile tf = new RandomTextFile();
		RandomTextZipp rz = new RandomTextZipp();
		try {
			tf.createTextFile();
		} catch (DirectoryNotCreatedException e1) {
			e1.printStackTrace();
			response.setContentType("text/html;charset=UTF-8");
			try (PrintWriter out = response.getWriter()) {
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Error-page</title>");
				out.println("</head>");
				out.println("<body><div align='middle'>");
				out.println("<h5>" + e1.getMessage() + "</h5>");
				out.println("<h5>at: C:/textfolder/</h5>");
				out.println("</div></body>");
				out.println("</html>");
			}
			catch (IOException e) {
		            System.err.println("Caught IOException: " + e.getMessage());
		    } 
		}
		rz.createRandomTextZipp();
		
		HttpSession session = request.getSession();
		session.setAttribute("totalWordsOfFile",          "Total words of text file:           " + LatencyService.getTotalWordsOfFile());
		session.setAttribute("averageWordsPerLine",       "Average words per line:             " + LatencyService.getAverageWordsPerLine());
		session.setAttribute("textCreateDuration",        "Text create duration:               " + LatencyService.getTextCreateDuration() + "ms");
		session.setAttribute("textFileCreateDuration",    "Text file create duration:          " + LatencyService.getTextFileCreateDuration() + "ms");
		session.setAttribute("textCreateCopiesDuration",  "Text file create 5 copies duration: " + LatencyService.getTextCreateCopiesDuration() + "ms");
		session.setAttribute("textCreateZipDuration",     "5 text files create zip duration:   " + LatencyService.getTextCreateZipDuration() + "ms");
		session.setAttribute("minimumWordCreateDuration", "Minimum word create duration:       " + LatencyService.getMinimumWordCreateDuration() + "ms");
		session.setAttribute("maximumWordCreateDuration", "Maximum word create duration:       " + LatencyService.getMaximumWordCreateDuration() + "ms");
		session.setAttribute("averageWordCreateDuration", "Average word create duration:       " + LatencyService.getAverageWordCreateDuration() + "ms");
		session.setAttribute("averageLineCreateDuration", "Average line create duration:       " + LatencyService.getAverageLineCreateDuration() + "ms");
		LatencyService.clearService();
		
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>The 5 files abd Zip has been created</title>");
			out.println("</head>");
			out.println("<body><div align='middle'>");
			out.println("<h5>The process ran succesfully and the 5 files and zip were created</h5>");
			out.println("<h5>at: C:/textfolder/</h5>");
	
			out.println("<img src='" + request.getContextPath() + imagePathString + "'></img> </br>");
			out.println("<a href='" + request.getContextPath() + "/result'>See latency info?</a>");
			out.println("</div></body>");
			out.println("</html>");
		}
		catch (IOException e) {
	            System.err.println("Caught IOException: " + e.getMessage());
	    } 
	}
}
