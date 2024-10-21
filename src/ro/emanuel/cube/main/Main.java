package ro.emanuel.cube.main;

import java.sql.SQLException;
import java.util.List;

import ro.emanuel.cube.dao.CubeDAO;
import ro.emanuel.cube.pojo.Cube;

public class Main {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
	
		
        List<Cube> cubes = CubeDAO.getCube();
        System.out.println("Lista cuburilor:");
        for (Cube cube : cubes) {
            System.out.println(cube);
        }
        
        System.out.println("=====================");
        System.out.println("=====================");
        
       
        Cube newCube = new Cube("Cub Nou", 79, 8);
        int rowsInserted = CubeDAO.createCube(newCube);
        System.out.println("Cub nou a fost creat. Rinduri inserate: " + rowsInserted);
        
        System.out.println();
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println();


        
        Cube cube = CubeDAO.getById(7);
        System.out.println("Cub gasit dupa ID: " + cube);
        
        System.out.println();
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println();



  
        Cube cubeToUpdate = new Cube(7, "Cub", 78, 8);
        int rowsUpdated = CubeDAO.updateCube(cubeToUpdate);
        System.out.println("Cubul a fost actualizat. Rinduri updatate: " + rowsUpdated);
       
        cube = CubeDAO.getById(7);
        System.out.println("Cub actualizat: " + cube);
        
        System.out.println();
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println();

        
        
        int rowsDeleted = CubeDAO.deleteCube(7);
        System.out.println("Cubul a fost stears. Rinduri sterse: " + rowsDeleted);
       
        cube= CubeDAO.getById(7);
        System.out.println(cube);

        
        

		
				
	}
	


}
