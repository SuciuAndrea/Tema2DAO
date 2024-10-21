package ro.emanuel.cube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.cube.helper.DBHelper;
import ro.emanuel.cube.pojo.Cube;


public class CubeDAO {
	
	
	
    
    public static List<Cube> getCube() throws SQLException {
        List<Cube> cubes = new ArrayList<>();

       
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
       
        ResultSet rs = stmt.executeQuery("select * from rubikscube");
        while(rs.next()) {
           
            int id = rs.getInt("id");
            String brand = rs.getString("brand");
            double weight = rs.getDouble("weight");
            int sides = rs.getInt("sides");
            Cube cube = new Cube(id, brand, weight, sides);
            cubes.add(cube); 
        }
        
        DBHelper.closeConnection(); 
        
        return cubes;     }

    
    public static int deleteCube(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
        
        int deletedRows = stmt.executeUpdate("delete from rubikscube where id = " + id);
        
        DBHelper.closeConnection();
        
        return deletedRows; 
    }

   
    public static int createCube(Cube CubeToCreate) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "insert into rubikscube (id, brand, weight, sides) values(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        
       
        ps.setInt(1, CubeToCreate.getId());
        ps.setString(2, CubeToCreate.getBrand());
        ps.setDouble(3, CubeToCreate.getWeight());
        ps.setInt(4, CubeToCreate.getSides());
        
       
        int affectedRows = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return affectedRows; 
    }

    
    public static int updateCube(Cube cube) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "update cube set id = ?, brand = ?, weight = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        
        
        ps.setInt(1, cube.getId());
        ps.setString(2, cube.getBrand());
        ps.setDouble(3, cube.getWeight());
        ps.setInt(4, cube.getSides());
        
  
        int rowsUpdated = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return rowsUpdated; 
    }

   
    public static Cube getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        
        
        List<Cube> cube = getCube();
        for(Cube c : cube) {
            if(c.getId() == id) {
                return c; 
            }
        }
        
        
        return null;
    }
}
