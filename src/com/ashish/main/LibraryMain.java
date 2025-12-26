package com.ashish.main;



import java.util.Scanner;
import com.ashish.dao.BookDAO;
import com.ashish.dao.IssueDao;

public class LibraryMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO bookDAO = new BookDAO();
        IssueDao issueDAO = new IssueDao();

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.next();
                    System.out.print("Author: ");
                    String author = sc.next();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    bookDAO.addBook(title, author, qty);
                    break;

                case 2:
                    System.out.print("Student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Book ID: ");
                    int bid = sc.nextInt();
                    issueDAO.issueBook(sid, bid);
                    break;

                case 3:
                    System.exit(0);
            }
        }
    }
}

