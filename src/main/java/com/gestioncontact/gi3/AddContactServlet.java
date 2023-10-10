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

@WebServlet("/AddContactServlet")
public class AddContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String numeroTelephone = request.getParameter("numeroTelephone");
try {
    Class.forName("com.mysql.cj.jdbc.Driver");

	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioncontact", "root", "root")) {
        String sql = "INSERT INTO contact (nom, prenom, numero_telephone) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, numeroTelephone);
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
