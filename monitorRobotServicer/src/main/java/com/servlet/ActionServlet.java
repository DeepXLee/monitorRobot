package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.updateData.AutoRun;

public class ActionServlet extends HttpServlet {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	Properties properties = new Properties();

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		properties.load(getServletContext().getResourceAsStream("/WEB-INF/token.properties"));

		String token = properties.getProperty("token");
		String urlToken = request.getParameter("token");
		if(token.equals(urlToken)) {
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		if (action.contentEquals("/index")) {
			
			int counter = AutoRun.counter();
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("counter: " + counter);
			out.flush();
			out.close();
			AutoRun.reset();
		}

		

		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("权限不足,请求错误");
			out.flush();
			out.close();
		}

	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request  the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException      if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
