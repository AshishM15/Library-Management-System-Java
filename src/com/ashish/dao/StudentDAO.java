package com.ashish.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ashishit.DBConnect;
import com.ashish.model.Student;

public class StudentDAO {

    private Connection conn;

    // Constructor
    public StudentDAO() {
        conn = DBConnect.getConnection();
    }

    // Add Student
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO student(name, branch) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getBranch());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // View All Students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setBranch(rs.getString("branch"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Get Student By ID
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM student WHERE student_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setBranch(rs.getString("branch"));
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Delete Student
    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE student_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
