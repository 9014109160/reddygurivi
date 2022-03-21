package com.kohli;

import java.util.Scanner;

import com.kohlicontroller.kohliControllerInterface;
import com.kohlientity.kohliUser;
import com.kohliutility.ControllerFactorty;

public class Kohliview {

	public static void main(String[] args) {
		String s = "y";
		
		Scanner sc = new Scanner(System.in);
		
		while(s.equals("y")) {
			
			System.out.println("********************");
			System.out.println("Main Menu");
			System.out.println("********************");
			System.out.println("Press 1 to SignUp");
			System.out.println("Press 2 to SignIN");
			
			
			System.out.println("Enter your choice: ");
			int ch = sc.nextInt();
			
			kohliControllerInterface kc = ControllerFactorty.createObject();
			kohliUser k;
			
			switch(ch) {
				case 1:
					kc.createProfileController();
					break;
				case 2:
					k=kc.signINController();
					if(k!=null) {
						while(s.equals("y")) {
							
							System.out.println("Press 1 to Delete Profile");
							System.out.println("Press 2 to View Profile");
							System.out.println("Press 3 to ViewAll Profile");
							System.out.println("Press 4 to Search Profile");
							System.out.println("Press 5 to  EditProfile");
							
							sc.close();
							System.out.println("Select an option");
							Scanner scan12 = new Scanner(System.in);
							int cc = scan12.nextInt();
							
							switch(cc) {
								case 1:
									kc.deleteProfileController();
									break;
								case 2:
									kc.viewProfileController();
									break;
								case 3:
									kc.viewAllProfilesController();
									break;
								case 4:
									kc.searchProfileController();
									break;
								case 5:
									kc.editProfileController();
									break;
								default:
									System.out.println("wrong choice");
							}
							System.out.println("press y to continue");
							s = scan12.next();
						}
					}
					
					else {
						System.out.println("cannot signin");
					}
					
				default:
					System.out.println("Wrong Choice");
			}
			
			System.out.println("Press y to continue");
			s = sc.next();
	}
		sc.close();
	}

}


