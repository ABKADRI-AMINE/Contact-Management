package com.gestioncontact.gi3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet
public class ReadContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");

    		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioncontact", "root", "root")) {
            	
                ContactDAO contactDAO = new ContactDAO(connection);
                List<Contact> contacts = contactDAO.getAllContacts();
                for(Contact c : contacts) {
                	System.out.println("contact name : " + c.getNom());
                }
                request.setAttribute("contacts", contacts);
                RequestDispatcher dispatcher = request.getRequestDispatcher("list-contact.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    	}catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }

}
