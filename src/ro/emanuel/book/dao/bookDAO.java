package ro.emanuel.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.book.helper.DBHelper;
import ro.emanuel.book.pojo.book;




public class bookDAO {
	
	
	
    
    public static List<book> getbook() throws SQLException {
        List<book> books = new ArrayList<>();

       
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
       
        ResultSet rs = stmt.executeQuery("select * from book");
        while(rs.next()) {
           
            int id = rs.getInt("id");
            String title= rs.getString("title");
            String author = rs.getString("author");
            int pages = rs.getInt("pages");
            book book = new book(id, title, author, pages);
            books.add(book); 
        }
        
        DBHelper.closeConnection(); 
        
        return books; 
    }

   
    public static int deletebook(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
        
        int deletedRows = stmt.executeUpdate("delete from book where id = " + id);
        
        DBHelper.closeConnection();
        
        return deletedRows; 
    }

    
    public static int createbook(book bookToCreate) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "insert into book (id, title, author, pages) values(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        
        
        ps.setInt(1, bookToCreate.getId());
        ps.setString(2, bookToCreate.getTitle());
        ps.setString(3, bookToCreate.getAuthor());
        ps.setInt(4, bookToCreate.getPages());
        
        
        int affectedRows = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return affectedRows; 
    }

    
    public static int updatebook(book book) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "update book set id = ?, title = ?, author = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        
        
        ps.setInt(1, book.getId());
        ps.setString(2, book.getTitle());
        ps.setString(3, book.getAuthor());
        ps.setInt(4, book.getPages());
        
        
        int rowsUpdated = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return rowsUpdated; 
    }

    
    public static book getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        
        
        List<book> book = getbook();
        for(book b : book) {
            if(b.getId() == id) {
                return b; 
            }
        }
        
        
        return null;
    }
}
