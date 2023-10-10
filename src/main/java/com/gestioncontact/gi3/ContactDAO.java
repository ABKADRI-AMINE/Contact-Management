package com.gestioncontact.gi3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    private Connection connection; 

    public ContactDAO(Connection connection) {
        this.connection = connection;
    }

   

	public List<Contact> getAllContacts() throws SQLException {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contact";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("id"));
                contact.setNom(resultSet.getString("nom"));
                contact.setPrenom(resultSet.getString("prenom"));
                contact.setNumeroTelephone(resultSet.getString("numero_telephone"));
                contacts.add(contact);
            }
        }

        return contacts;
    }
}
