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

@WebServlet("/UpdateContactServlet")
public class UpdateContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int contactId = Integer.parseInt(request.getParameter("id"));
        System.out.println("id : " + contactId);
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String numeroTelephone = request.getParameter("numeroTelephone");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioncontact", "root", "root")) {
                String sql = "UPDATE contact SET nom=?, prenom=?, numero_telephone=? WHERE id=?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, nom);
                    statement.setString(2, prenom);
                    statement.setString(3, numeroTelephone);
                    statement.setInt(4, contactId);
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
