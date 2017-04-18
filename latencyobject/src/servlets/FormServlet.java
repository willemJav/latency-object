package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author wfristdr
 * 
 * The simple FormServlet presents some info about the
 * Latency Object application and serves a simple form to start
 * the file/zip process described before. A simple html-form will
 * do the job by calling the zip servlet through its action (dozip).
 *
 */

public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String imagePathString;
    
    public FormServlet() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        imagePathString = config.getInitParameter("image-path");
    }

    /**
     * A print writer writes a simple html form to the page which will trigger
     * the process of the 5 text-files of 1000 line of random words  copied into a zip-file
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>File/Zip Latency Info</title>");
	            out.println("</head>");
	            out.println("<body><div align='middle'>");
	            out.println("<h2>File/Zip Latency Info</h2>");
	            
	            out.println("<ul align='left'>");
	            out.println("<li>The Webapplication generates a random text file of 1000 lines</li>");
	            out.println("<li>The file will be save under: C:/textfolder/randomtext1-5.txt</li>");
	            out.println("<li>If the directory is not present it will be created.</h5>");
	            out.println("<li>The application will copy the textfiles 5 times into a zip.</h5>");
	            out.println("<li>The zip will be saved at the same folder named: randomtextZip.zip</h5>");
	            out.println("<li>A next page invokes the decribed process.</h5>");
	            out.println("</ul>");
	         
	            out.println("<img src='" + request.getContextPath() + imagePathString + "'></img>");
	            out.println("<form action ='dozip' method='post'>");
	            out.println("<br>");
	            out.println("<input type='submit' value='Submit'>");
	            out.println("</form>");
	            out.println("</body>");
	            out.println("</html>");
	            out.println("</div></body>");
	            out.println("</html>");
	        }   
	        catch (IOException e) {
	            System.err.println("Caught IOException: " + e.getMessage());
	        } 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
