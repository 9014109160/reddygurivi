package com.kohlicontroller;
import java.util.List;

import java.util.Scanner;

import com.kohlientity.kohliUser;
import com.kohliservice.kohliServiceInterface;
import com.kohliutility.ServiceFactory;

public class kohlicontroller implements kohliControllerInterface {
	kohliServiceInterface ks = null;
	
	public kohlicontroller() {
		ks = ServiceFactory.createObject();
	}

	public void createProfileController() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name: ");
		String name = sc.next();
		
		System.out.println("Enter Password: ");
		String password = sc.next();
		
		System.out.println("Enter Email: ");
		String email = sc.next();
		
		System.out.println("Enter Address: ");
		String address = sc.next();
		
		kohliUser ku = new kohliUser();
		ku.setName(name);
		ku.setPassword(password);
		ku.setEmail(email);
		ku.setAddress(address);
		
		
		//kohliServiceInterface ks = ServiceFactory.createObject();
		int i = ks.createProfileService(ku);
		
		if(i>0) {
			System.out.println("Your Profile is created "+name);
		}
		
		else {
			System.out.println("Sorry..... Your Profile is not created");
		}

	}

	public void deleteProfileController() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Email: ");
		String email = sc.next();
		kohliUser ku = new kohliUser();
		ku.setEmail(email);
		
		int i = ks.deleteProfileService(ku);
		
		if(i>0) {
			System.out.println("Profile is deleted");
		}
		
		else {
			System.out.println("Profile is not deleted");
		}
		
	}

	public void viewProfileController() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Email: ");
		String email = sc.next();
		
		kohliUser ku = new kohliUser();
		ku.setEmail(email);
		
		kohliUser i = ks.viewProfileService(ku);
		
		if(i!=null) {
			
			System.out.println("**********");
			System.out.println("Your name is "+i.getName());
			System.out.println("Your Password is "+i.getPassword());
			System.out.println("Your Email is "+i.getEmail());
			System.out.println("Your Address is "+i.getAddress());
			System.out.println("**********");
			
		}
		
		else {
			System.out.println("No Record Found");
		}
		
		
	}

	
	public void viewAllProfilesController() {
		List<kohliUser> ll = ks.viewAllProfilesService();
		
		System.out.println(ll.size()+" records found in the database");
		
		
		ll.forEach(p->{
			
			System.out.println("**********");
			System.out.println("Name is "+p.getName());
			System.out.println("Password is "+p.getPassword());
			System.out.println("Email is "+p.getEmail());
			System.out.println("Address is "+p.getAddress());
			System.out.println("**********");
			
		});
		
		
	}

	@Override
	public void searchProfileController() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name :");
		String name = sc.next();
		
		kohliUser ku = new kohliUser();
		ku.setName(name);
		
		List<kohliUser> i = ks.searchProfileService(ku);
		
		System.out.println(i.size()+" records found in the database");
		
		//if(i!=null) {
			
			i.forEach(p->{
				
				System.out.println("**********");
				System.out.println("Name is "+p.getName());
				System.out.println("Password is "+p.getPassword());
				System.out.println("Email is "+p.getEmail());
				System.out.println("Address is "+p.getAddress());
				System.out.println("**********");
				
			});
			
		//}
		
		/*else {
			System.out.println("Cannot search Profile");
		}*/
		
	}

	@Override
	public void editProfileController() {
		System.out.println("Your Older Data");
		viewProfileController();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter new Name: ");
		String name = sc.next();
		
		System.out.println("Enter new Password: ");
		String password = sc.next();
		
		System.out.println("Enter old Email: ");
		String email = sc.next();
		
		System.out.println("Enter new Address: ");
		String address = sc.next();
		sc.close();
		
		kohliUser ku = new kohliUser();
		ku.setName(name);
		ku.setPassword(password);
		ku.setEmail(email);
		ku.setAddress(address);
		
		int i = ks.editProfileService(ku);
		
		if(i>0) {
			System.out.println("Your Profile is edited "+name);
		}
		
		else {
			System.out.println("Sorry..... Your Profile is not edited");
		}
		
		
		
	}

	@Override
	public kohliUser signINController() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Email: ");
		String email = sc.next();
		
		System.out.println("Enter Password: ");
		String password = sc.next();
		//sc.close();
		
		kohliUser ku = new kohliUser();
		ku.setEmail(email);
		ku.setPassword(password);
		
		kohliUser i = ks.signINService(ku);
		
		if(i!=null) {
			
			System.out.println("Signed in Successfully");
			System.out.println("name :"+i.getName());
			System.out.println("adress :"+i.getAddress());
			System.out.println("email :"+i.getEmail());
			System.out.println("password :"+i.getPassword());
			
		}
		
		else {
			System.out.println("unable to signIn");
		}
		return i;
		
	}
		
}


