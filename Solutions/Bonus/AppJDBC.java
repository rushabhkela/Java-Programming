import java.util.Scanner;

import java.sql.*;

class StudentVIT {
    String name;
    String password;
    String school;
    int marks;

    void getDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your password: ");
        password = sc.nextLine();
        System.out.println("Enter School: ");
        school = sc.nextLine();
        System.out.println("Enter marks");
        marks = sc.nextInt();
    }

    void insertRecord() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        try {
            DatabaseConn dbms = new DatabaseConn("jdbc://mysql://localhost:3306/vit", "root", "");
            Connection conn = dbms.getConnection();
            String sql = "INSERT INTO student VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3, school);
            stmt.setInt(4, marks);
            stmt.execute();
            System.out.println("Record inserted successfully");
            dbms.closeConnection(conn, stmt);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    void updateRecord() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        try {
            DatabaseConn dbms = new DatabaseConn("jdbc://mysql://localhost:3306/vit", "root", "");
            Connection conn = dbms.getConnection();
            System.out.println("Enter your name: ");
            Scanner sc = new Scanner(System.in);
            String inputname = sc.nextLine();
            System.out.println("Enter your new password: ");
            String inputpass = sc.nextLine();

            String sql = "UPDATE student SET password = ? WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, inputname);
            stmt.setString(2, inputpass);
            int i = stmt.executeUpdate();
            if(i>0) {
                System.out.println("Record updated successfully");
            }
            else {
                System.out.println("No such record found in the database");
            }
            dbms.closeConnection(conn, stmt);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    void deleteRecord() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        try {
            DatabaseConn dbms = new DatabaseConn("jdbc://mysql://localhost:3306/vit", "root", "");
            Connection conn = dbms.getConnection();
            System.out.println("Enter name to be deleted: ");
            Scanner sc = new Scanner(System.in);
            String inputname = sc.nextLine();

            String sql = "DELETE FROM student WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, inputname);
            int i = stmt.executeUpdate();
            if(i>0) {
                System.out.println("Record deleted successfully");
            }
            else {
                System.out.println("No such record found in the database");
            }
            dbms.closeConnection(conn, stmt);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    void searchRecord() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        try {
            DatabaseConn dbms = new DatabaseConn("jdbc://mysql://localhost:3306/vit", "root", "");
            Connection conn = dbms.getConnection();
            System.out.println("Enter name to be searched: ");
            Scanner sc = new Scanner(System.in);
            String inputname = sc.nextLine();

            String sql = "SELECT * FROM student WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, inputname);
            ResultSet rs = stmt.executeQuery();
            if(rs.next() == false) {
                System.out.println("No such record found in the database");
            }
            else {
                rs.previous();
                while(rs.next()) {
                    System.out.println("Name: " + rs.getString(1));
                    System.out.println("Password: " + rs.getString(2));
                    System.out.println("School: " + rs.getString(3));
                    System.out.println("Marks: " + rs.getString(4));
                }
            }
            dbms.closeConnection(conn, stmt);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}

class DatabaseConn {
    String url;
    String username;
    String password;

    DatabaseConn(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.mysql.kela.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connection is established");
        return conn;
    }

    public void closeConnection(Connection conn, Statement stmt) throws SQLException {
        stmt.close();
        conn.close();
    }
}

public class AppJDBC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        try {
            do {
                System.out.println("Select a choice.\n1. Enter Student Details\n2. Update Password\n3. Delete Student\n4. Search Record\n5. Exit");
                ch = 0;
                StudentVIT s = new StudentVIT();
                System.out.print("Enter choice: ");
                ch = sc.nextInt();
                switch(ch) 
                {
                    case 1:
                        s.getDetails();
                        s.insertRecord();
                        break;
                    
                    case 2:
                        s.updateRecord();
                        break;
                    
                    case 3:
                        s.deleteRecord();
                        break;

                    case 4:
                        s.searchRecord();
                        break;

                    case 5:
                        System.out.println("Exiting..");
                        break;

                    default:
                        System.out.println("Please select the correct option.");
                        break;
                }
            }while(ch!=5);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}