package com.riders_buddy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class homepage_servlet
 */
@WebServlet("/homepage")
public class homepage_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homepage_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession(false);  
		/*The boolean parameter 'false'
        has been passed so that a new session
        is not created since the session already
        exists*/
		try {
	        if(session!=null){  
		        String username = (String)session.getAttribute("username");
		        if(username!=null) {
		        	System.out.println("Hello " + username);
		        	//forwarding the request
		        	request.setAttribute("username", username);
					RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/homepage.jsp");
					dispatcher.forward(request, response);
		        } else {
		        	System.out.println("Please login first");  
		        	response.sendRedirect("/riders-buddy/login"); 
		        }
	        } else{  
	        	System.out.println("Please login first");  
	        	response.sendRedirect("/riders-buddy/login"); 
	        }  
		} catch(Exception e) {
			e.printStackTrace();
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
