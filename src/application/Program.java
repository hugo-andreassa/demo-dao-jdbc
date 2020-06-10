package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("---- Test #1: FindById ----");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n---- Test #2: FindByDepartment ----");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		list.forEach(System.out::println);		
		
		System.out.println("\n---- Test #3: FindAll ----");
		List<Seller> list2 = sellerDao.findAll();
		list2.forEach(System.out::println);	
		
		System.out.println("\n---- Test #4: Insert ----");
		Seller seller2 = new Seller(null, "Carlão", "carlao@gmail", new Date(), 2900.0, dep);
		sellerDao.insert(seller2);
		System.out.println("Inserted! New Id = " + seller2.getId());
		
		System.out.println("\n---- Test #5: Updated ----");
		seller = sellerDao.findById(1);
		seller.setName("Carlinhos");
		sellerDao.update(seller);
		System.out.println("Updated completed!");
		
		System.out.println("\n---- Test #5: Deleted ----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter id for delete: ");
		sellerDao.deleteById(sc.nextInt());
		System.out.println("Deleted completed!");
	}

}
