package com.riders_buddy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.riders_buddy.dao.edit_userDAO;
import com.riders_buddy.model.edit_user;

/**
 * Servlet implementation class edit_user_servlet
 */
@WebServlet("/editprofile")
public class edit_user_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit_user_servlet() {
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
		        	System.out.println("Profile edit: " + username);
		    		
		        	//forwarding the request
		        	request.setAttribute("username", username);
					RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/profile.jsp");
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
		String userID = request.getParameter("employeeid");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String mname = request.getParameter("mi");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("values in servlet: "+userID+" "+firstname+" "+lastname+" "+password+" "+mname+" "+email+" "+username+" "+password+" ");
		
		edit_user editUserData = new edit_user();
		
		editUserData.setEmployeeId(userID);
		editUserData.setFirstname(firstname);
		editUserData.setLastname(lastname);
		editUserData.setMname(mname);
		editUserData.setEmail(email);
		editUserData.setUsername(username);
		editUserData.setPassword(password);
		
		try {
			edit_userDAO.userReg(editUserData);					 	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String suc="true";
		response.sendRedirect("/riders-buddy/editprofile?ID="+userID+"&success="+suc); 
		
	}

}
