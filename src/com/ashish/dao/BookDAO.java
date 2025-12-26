package com.ashish.dao;

import java.sql.*;
import com.ashishit.*;

public class BookDAO {

	Connection conn = DBConnect.getConnection();
	
	public void addBook(String title, String author, int qty) {
		String sql = "INSERT INTO book(title,author,quantity) VALUES (?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, qty);
            ps.executeUpdate();
            System.out.println("Book Added Successfully");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
