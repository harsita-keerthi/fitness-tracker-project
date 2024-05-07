/*
 * CS 151 Final Project Main Method
 * Authors: Harsita Keerthikanth & Amara Del Prato
 */

import java.util.*;

public class FitnessTracker {
	public static void main(String[] args) {
		/* WELCOME MESSAGE */
		System.out.println("* Welcome to Fitness Tracker! *");
		System.out.println();
		
		User user = createUser();
		
		/* MENU DISPLAY */
		int choice = displayMenu();
		System.out.println("You chose option " + choice);
	}
	
	public static User createUser() {
		// ask name
		Scanner scnr = new Scanner(System.in);
		System.out.print("To begin, please enter your name: ");
		String name = scnr.nextLine();
		System.out.println();
		
		// ask age
		boolean ageValid = false; 
		double age = 0.0;
		System.out.print("Enter your age in years: ");
        while (!ageValid) {
            try {
                age = scnr.nextDouble();
                ageValid = true;
            } 
            catch (InputMismatchException e) {
                System.out.print("ERROR: invalid input. Please Retry: ");
                scnr.nextLine(); 
            }
        }
		System.out.println();
		
		// ask height
		boolean heightValid = false; 
		double height = 0.0;
		System.out.print("Enter your height in inches: ");
        while (!heightValid) {
            try {
                height = scnr.nextDouble();
                heightValid = true;
            } 
            catch (InputMismatchException e) {
                System.out.print("ERROR: invalid input. Please Retry: ");
                scnr.nextLine(); 
            }
        }
		System.out.println();
		
		// ask weight
		boolean weightValid = false; 
		double weight = 0.0;
		System.out.print("Enter your weight in pounds: ");
        while (!weightValid) {
            try {
                weight = scnr.nextDouble();
                weightValid = true;
            } 
            catch (InputMismatchException e) {
                System.out.print("ERROR: invalid input. Please Retry: ");
                scnr.nextLine(); 
            }
        }
		System.out.println();
		User user = new User(name, age, height, weight);
		return user;
	}
	
	public static int displayMenu() {
		System.out.println("---------------------------------------------------");
		System.out.println();
		System.out.println("* MAIN MENU *");
		System.out.println("Choose an action by typing its corresponding number.");
		System.out.println();
		
		System.out.println("1 - Create a workout");
		System.out.println("2 - Display workouts");
		System.out.println("0 - Quit application");
		
		System.out.println();
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter key: ");
		int key = scnr.nextInt();
		return key;
	}
}
