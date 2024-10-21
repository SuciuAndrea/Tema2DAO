package ro.emanuel.vehicle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.vehicle.helper.DBHelper;
import ro.emanuel.vehicle.pojo.Vehicle;

public class VehicleDAO {
	
	
	
  
    public static List<Vehicle> getVehicle() throws SQLException {
        List<Vehicle> vehicle = new ArrayList<>();

       
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
      
        ResultSet rs = stmt.executeQuery("select * from vehicle");
        while(rs.next()) {
            
            int id = rs.getInt("id");
            String brand= rs.getString("brand");
            int weight = rs.getInt("weight");
            int sides = rs.getInt("sides");
            Vehicle vehicle1 = new Vehicle(id, brand, weight, sides);
            vehicle1.add(vehicle1); 
        }
        
        DBHelper.closeConnection(); // Inchidem conexiunea
        
        return vehicle; 
    }

   
    public static int deleteVehicle(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
       
        int deletedRows = stmt.executeUpdate("delete from vehicle where id = " + id);
        
        DBHelper.closeConnection();
        
        return deletedRows; 
    }

   
    public static int createVehicle(Vehicle VehicleToCreate) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "insert into vehicle (id, brand, weight, sides) values(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        
       
        ps.setInt(1, VehicleToCreate.getId());
        ps.setString(2, VehicleToCreate.getBrand());
        ps.setInt(3, VehicleToCreate.getWeight());
        ps.setInt(4, VehicleToCreate.getSides());
        
       
        int affectedRows = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return affectedRows; 
    }

    
    public static int updateVehicle(Vehicle vehicle) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "update vehicle set id = ?, brand = ?, weight = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        
       
        ps.setInt(1, vehicle.getId());
        ps.setString(2, vehicle.getBrand());
        ps.setInt(3, vehicle.getWeight());
        ps.setInt(4, vehicle.getSides());
        
        
        int rowsUpdated = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return rowsUpdated; 
    }


    public static Vehicle getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        
       
        List<Vehicle> vehicle = getVehicle();
        for(Vehicle v : vehicle) {
            if(v.getId() == id) {
                return v; 
            }
        }
        
        
        return null;
    }
}
