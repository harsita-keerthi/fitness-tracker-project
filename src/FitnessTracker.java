/*
 * CS 151 Final Project Main Method
 * Authors: Harsita Keerthikanth & Amara Del Prato
 */

import java.util.*;

public class FitnessTracker {
	public static void main(String[] args) {
		/* WELCOME MESSAGE */
		System.out.println("* WELCOME TO FITNESS TRACKER *");
		System.out.println();
		
		User user = createUser();
		
		/* MENU DISPLAY */
		int choice = displayMenu();
		while (choice != 0) {
			switch(choice) {
				case 1:
					System.out.println("Creating new workout...");
					System.out.println();
					
					Scanner scnr = new Scanner(System.in);
					System.out.print("Date completed: ");
					String date = scnr.nextLine();
					
					System.out.print("Time completed: ");
					String time = scnr.nextLine();
					
					System.out.print("Total duration: ");
					int duration = scnr.nextInt();
					System.out.println();
					
					Workout workout = new Workout(date, time, duration);
					user.addWorkout(workout);
					scnr.nextLine();
					
					System.out.print("Would you like to add an exercise? (y/n): ");
					String addAnother = scnr.nextLine();
					int type = 0;
					while (addAnother.equals("y")) {
						System.out.println("Choose one of the following exercise types:");
						System.out.println("1 - weightlifting");
						System.out.println("2 - stretching");
						System.out.println("3 - cardio");
						System.out.println("4 - mind and body");
						System.out.print("Exercise type: ");
						type = scnr.nextInt();
						scnr.nextLine();
						System.out.println();
						
						System.out.print("Exercise name: ");
						String name = scnr.nextLine();
						System.out.print("Exercise description: ");
						String description = scnr.nextLine();
						System.out.print("Calories burned: ");
						int cals = scnr.nextInt();
						scnr.nextLine();
						
						Exercise e = null;
						switch(type) {
							case 1: 
								e = new Weightlifting("weightlifting", name, cals, description);
								break;
							case 2:
								e = new Stretching("stretching", name, cals, description);
								break;
							case 3:
								e = new Cardio("cardio", name, cals, description);
								break;
							case 4:
								e = new MindBody("mind and body", name, cals, description);
								break;
						}
						
						workout.addExercise(e);
						System.out.println();
						System.out.print("Would you like to add an exercise? (y/n): ");
						addAnother = scnr.nextLine();
					}
					System.out.println();
					break;
				case 2:
					System.out.println("Displaying workouts...");
					System.out.println();
					
					for (Workout w : user.getWorkouts()) {
						w.displaySummary();
					}
					
					break;
				case 3:
					System.out.println("Displaying workouts..."); // FIXME: left off here
					System.out.println();
					break;
				case 4:
					System.out.println("Creating fitness goal...");
					System.out.println();
					break;
				case 5:
					System.out.println("Displaying fitness goals...");
					System.out.println();
					break;
				case 6:
					System.out.println("Getting goal advice...");
					System.out.println();
					break;
				case 7:
					System.out.println("Displaying account info...");
					System.out.println();
					break;
				case 8:
					System.out.println("Displaying account info...");
					System.out.println();
					break;
			}
			choice = displayMenu();
		}
		
		System.out.println("Application closing...");
	}
	
	public static User createUser() {
		// ask name
		Scanner scnr = new Scanner(System.in);
		System.out.print("To begin, please enter your name: ");
		String name = scnr.nextLine();
		
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
		System.out.println("3 - Edit a workout");
		System.out.println("4 - Set fitness goal");
		System.out.println("5 - Display fitness goals");
		System.out.println("6 - Get goal advice");
		System.out.println("7 - Display account info");
		System.out.println("8 - Edit account info");
		System.out.println("0 - Quit application");
		
		System.out.println();
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter key: ");
		int key = scnr.nextInt();
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.println();
		return key;
	}
}
