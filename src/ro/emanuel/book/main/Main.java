package ro.emanuel.book.main;

import java.sql.SQLException;
import java.util.List;

import ro.emanuel.book.dao.bookDAO;
import ro.emanuel.book.pojo.book;



public class Main {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
	
		// 1. Luam toate bancile si le afisam
        List<book> book = bookDAO.getbook();
        System.out.println("Lista cartilor:");
        for (book book1 : book) {
            System.out.println(book1);
        }
        
        System.out.println("=====================");
        System.out.println("=====================");
        
        // 2. Cream o banca noua
        book newbook = new book("carte Noua","Autor",200);
        int rowsInserted = bookDAO.createbook(newbook);
        System.out.println("o carte noua a fost creata. Rinduri inserate: " + rowsInserted);
        
        System.out.println();
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println();


        // 3. Luam o banca dupa ID si o afisam
        book book1 = bookDAO.getById(7);
        System.out.println("carte gasita dupa ID: " + book);
        
        System.out.println();
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println();



        // 4. Facem update la banca cu ID-ul 1, ii setam numele "Banca BNR", swift si adresa noua
        // apoi afisam si verificam actualizarea
        book bookToUpdate = new book("Harry Potter", "j.k.rouling", 500);
        int rowsUpdated = bookDAO.updatebook(bookToUpdate);
        System.out.println("cartea a fost actualizata. Rinduri updatate: " + rowsUpdated);
        // iau banca cu id-ul specificat din db folosind dao, si verific daca s-a actualizat
        book1 = bookDAO.getById(7);
        System.out.println("Cub actualizat: " + book);
        
        System.out.println();
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println();

        
        // 5. Stergem banca cu ID-ul 1
        int rowsDeleted = bookDAO.deletebook(7);
        System.out.println("Cartea a fost stearsa. Rinduri sterse: " + rowsDeleted);
        // acum incerc sa o iau din nou din db, si pentru ca tocmai am sters-o, ar trebui sa primim null fiindca asa am facut in DAO.
        book1= bookDAO.getById(7);
        System.out.println(book);

        
        

		
				
	}
	


}

