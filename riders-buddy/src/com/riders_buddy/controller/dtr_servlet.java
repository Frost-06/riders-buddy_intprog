package com.riders_buddy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.riders_buddy.dao.dtr_userDAO;
import com.riders_buddy.model.dtr_user;


/**
 * Servlet implementation class dtr_servlet
 */
@WebServlet("/dtr")
public class dtr_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dtr_servlet() {
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
				        	System.out.println("Profile access: " + username);
				        	//forwarding the request
				        	request.setAttribute("username", username);
							RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/dtr.jsp");
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
		String date = request.getParameter("date");
		String timein = request.getParameter("timein");
		String timeout = request.getParameter("timeout");
		
		System.out.println("values in servlet: "+userID+" "+date+" "+timein+" "+timeout+"");
		
		dtr_user dtrUserVal = new dtr_user();
		
		dtrUserVal.setEmployeeID(userID);
		dtrUserVal.setDate(date);
		dtrUserVal.setTimein(timein);
		dtrUserVal.setTimeout(timeout);
		
		try {
			dtr_userDAO.userDTR(dtrUserVal);					 	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String suc="true";
		response.sendRedirect("/riders-buddy/dtr?ID="+userID+"&success="+suc); 
	}

}
