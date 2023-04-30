package Demo.masai;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class Main {
	static EntityManagerFactory emf;
	
	static {
		emf=Persistence.createEntityManagerFactory("Connect");
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int c;
		do {
			System.out.println("1. Insert Student Data");
			System.out.println("2. Print Student Data");
			System.out.println("0. Exit");
			
			c=sc.nextInt();
			
			switch(c) {
			case 1:
				Addui(sc);
				break;
			case 2:
				PrintUi(sc);
				break;
			case 0:
				System.out.println("Thanks Visit Again");
				break;
				default :
					System.out.println("Invalid Slection");
					break;
			}
		}while(c!=0);
		sc.close();
		
	}

	 static void Addui(Scanner sc) {
	EntityManager em=emf.createEntityManager();
	
	System.out.println("Enter name");
	String name=sc.next();
	System.out.println("Enter Hobbies");
	String hob=sc.next();
	System.out.println("Enter standard");
	String standard=sc.next();
	System.out.println("Enter age");
	int age=sc.nextInt();
	
	Student a=new Student(name,hob,standard,age);
	
	EntityTransaction et =em.getTransaction();
	
	et.begin();
	try {
	em.persist(a);
	System.out.println("addedd");
	}
	catch(PersistenceException e)
	{
		System.out.println("not addedd");
	}
	finally {
	et.commit();
	em.close();
	}
		
	}

	static void PrintUi(Scanner sc) {
		EntityManager em=emf.createEntityManager();
		
		String q="select e from Student e ";
		Query tr=em.createQuery(q);
		List<Student> sb=tr.getResultList();
		sb.forEach(System.out::println);
		
		
	}
}
