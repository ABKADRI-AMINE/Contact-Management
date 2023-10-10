package com.gestioncontact.gi3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteContactServlet")
public class DeleteContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int contactId = Integer.parseInt(request.getParameter("id"));
try {
    Class.forName("com.mysql.cj.jdbc.Driver");

	 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioncontact", "root", "root")) {
         String sql = "DELETE FROM contact WHERE id=?";
         try (PreparedStatement statement = connection.prepareStatement(sql)) {
             statement.setInt(1, contactId);
             statement.executeUpdate();
         }

         response.sendRedirect("/gestionContact");
     } catch (SQLException e) {
         e.printStackTrace();
     }
}catch (ClassNotFoundException e) {
    e.printStackTrace();
}
       
    }
}
