package com.riders_buddy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.riders_buddy.dao.loginDAO;
import com.riders_buddy.model.Login;

/**
 * Servlet implementation class login_servlet
 */
@WebServlet("/login")
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() {
		new loginDAO();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//forwarding the request
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("username");
        String password = request.getParameter("password");
        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);

        try {
            if (loginDAO.validate(login)) {
            	//to be pass to another page
            	HttpSession session = request.getSession();
                session.setAttribute("username",username);
                //use this to pass session to another page
                //String session_username = (String)session.getAttribute("username");
                response.sendRedirect("/riders-buddy/homepage");        		
                return;
        		
            } else {
                HttpSession session = request.getSession();
                System.out.println("Wrong username and password");
                String error ="true";
                response.sendRedirect("/riders-buddy/login?error="+error);
                //session.setAttribute("user", username);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

}
