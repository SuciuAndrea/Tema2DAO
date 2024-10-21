package ro.emanuel.vehicle.main;

import java.sql.SQLException;
import java.util.List;

import ro.emanuel.vehicle.dao.VehicleDAO;
import ro.emanuel.vehicle.pojo.Vehicle;



public class Main {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
	
        List<Vehicle> vehicles = VehicleDAO.getVehicle();
        System.out.println("Lista vehiculelor:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
        
        System.out.println("=====================");
        System.out.println("=====================");
        
        Vehicle newVehicle = new Vehicle("Vehicul bou", 1450, 4);
        int rowsInserted = VehicleDAO.createVehicle(newVehicle);
        System.out.println("vehiculul nou a fost creat. Rinduri inserate: " + rowsInserted);
        
        System.out.println();
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println();


        Vehicle vehicle = VehicleDAO.getById(7);
        System.out.println("Vehicul gasit dupa ID: " + vehicle);
        
        System.out.println();
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println();



  
        Vehicle vehicleToUpdate = new Vehicle(7, "Toyota", 1350, 4);
        int rowsUpdated = VehicleDAO.updateVehicle(vehicleToUpdate);
        System.out.println("Vehiculul a fost actualizat. Rinduri updatate: " + rowsUpdated);
      
        vehicle = VehicleDAO.getById(7);
        System.out.println("Vehicul actualizat: " + vehicle);
        
        System.out.println();
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println();

      
        int rowsDeleted = VehicleDAO.deleteVehicle(7);
        System.out.println("Vehiculul a fost sters. Rinduri sterse: " + rowsDeleted);
        
        vehicle= VehicleDAO.getById(7);
        System.out.println(vehicle);

        
        

		
				
	}
	


}
