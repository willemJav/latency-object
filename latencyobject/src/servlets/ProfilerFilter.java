package servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 
 * @author wfristdr
 * 
 * The filter provides additional info concernin the latency. The
 * properties collapse time and url are saved into the session
 * attribute to be displayed at the Result servlet.
 *
 */

public class ProfilerFilter implements Filter {

	private FilterConfig filterConfig;
	private List<String> timerList;

	@Override
	/**
	 * 
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;

		long startTime = System.currentTimeMillis();
		long elapsed = 0;
		chain.doFilter(req, res);
		elapsed = System.currentTimeMillis() - startTime;

		String name = "servlet";
		if (request instanceof HttpServletRequest) {
			name = ((HttpServletRequest) request).getRequestURI();
		}

		HttpSession session = request.getSession(true);
		session.setAttribute("durationTotal", name + " took " + elapsed + "ms");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void destroy() {
	}
}
