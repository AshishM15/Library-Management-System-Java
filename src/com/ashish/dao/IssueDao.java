package com.ashish.dao;


import java.sql.*;
import com.ashishit.DBConnect;

public class IssueDao {

    Connection conn = DBConnect.getConnection();

    public void issueBook(int studentId, int bookId) {
        try {
            String check = "SELECT quantity FROM book WHERE book_id=?";
            PreparedStatement ps1 = conn.prepareStatement(check);
            ps1.setInt(1, bookId);
            ResultSet rs = ps1.executeQuery();

            if (rs.next() && rs.getInt("quantity") > 0) {
                String issue = "INSERT INTO issue_record(student_id,book_id,issue_date,status) VALUES (?, ?, CURDATE(), 'Issued')";
                PreparedStatement ps2 = conn.prepareStatement(issue);
                ps2.setInt(1, studentId);
                ps2.setInt(2, bookId);
                ps2.executeUpdate();

                String update = "UPDATE book SET quantity = quantity - 1 WHERE book_id=?";
                PreparedStatement ps3 = conn.prepareStatement(update);
                ps3.setInt(1, bookId);
                ps3.executeUpdate();

                System.out.println("Book Issued Successfully");
                } 
            else {
                System.out.println("Book Not Available");
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

