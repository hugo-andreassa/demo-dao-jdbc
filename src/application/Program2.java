package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("---- Test #1: FindById ----");
		Department dep = depDao.findById(3);
		System.out.println(dep);
		
		System.out.println("\n---- Test #3: FindAll ----");
		List<Department> list = depDao.findAll();
		list.forEach(System.out::println);	
		
		System.out.println("\n---- Test #4: Insert ----");
		Department dep2 = new Department(null, "D50");
		depDao.insert(dep2);
		System.out.println("Inserted! New Id = " + dep2.getId());
		
		System.out.println("\n---- Test #5: Updated ----");
		dep = depDao.findById(1);
		dep.setName("Segurança");
		depDao.update(dep);
		System.out.println("Updated completed!");
		
		System.out.println("\n---- Test #5: Deleted ----");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter id for delete: ");
		depDao.deleteById(sc.nextInt());
		System.out.println("Deleted completed!");
	}

}
