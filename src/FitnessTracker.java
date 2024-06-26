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
		List<FitnessGoal> fitnessGoalsList = new ArrayList<>();
		
		/* MENU DISPLAY */
		int choice = displayMenu();
		while (choice != 0) {
			switch (choice) {
				case 0:
					break;
				case 1:
					System.out.println("Creating new workout...");
					System.out.println();
					Workout workout = createWorkout();
					user.addWorkout(workout);
					System.out.println();
					break;
				case 2:
					System.out.println("Displaying workouts...");
					System.out.println();

					List<Workout> workouts = user.getWorkouts();
					for (int i = 0; i < workouts.size(); ++i) {
						System.out.println("* WORKOUT " + (i+1) + " *");
						workouts.get(i).displaySummary();
						System.out.println("---");
						System.out.println();
					}

					break;
				case 3:
					System.out.println("Type the number of the workout you want to edit."); 
					System.out.println();
					
					List<Workout> editWorkouts = user.getWorkouts();
					for (int i = 0; i < editWorkouts.size(); ++i) {
						System.out.println("* WORKOUT " + (i+1) + " *");
						editWorkouts.get(i).displaySummary();
						System.out.println("---");
						System.out.println();
					}
					System.out.print("Workout number: ");
					Scanner s = new Scanner(System.in);
					int workoutNum = s.nextInt();
					
					System.out.println();
					Workout editWorkout = editWorkouts.get(workoutNum - 1);
					
					System.out.println("Select the number of what you want to change.");
					System.out.println("1 - Add exercise");
					System.out.println("2 - Date");
					System.out.println("3 - Time");
					System.out.println("4 - Duration");
					System.out.print("Number: ");
					int editChoice = s.nextInt();
					s.nextLine();
					switch(editChoice) {
						case 1:
							addExercises(editWorkout);
							break;
						case 2:
							System.out.print("New date: ");
							String newDate = s.nextLine();
							editWorkout.setDate(newDate);
							break;
						case 3:
							System.out.print("New time: ");
							String newTime = s.nextLine();
							editWorkout.setTime(newTime);
							break;
						case 4:
							System.out.print("New duration: ");
							int newDuration = s.nextInt();
							editWorkout.setTotalDuration(newDuration);
							break;
					}
					
					System.out.println();
					break;
				case 4:
					Scanner scan = new Scanner(System.in);

					System.out.println("Creating fitness goal...");
					System.out.println();
					System.out.println("Choose the type of fitness goal:");
					System.out.println("1 - Weight Goal");
					System.out.println("2 - Running Goal");
					System.out.println("3 - Weightlifting Goal");
					System.out.print("Enter your choice: ");
					int goalType = scan.nextInt();
					scan.nextLine();

					switch (goalType) {
						case 1:
							System.out.print("Enter weight target: ");
							double weightTarget = scan.nextDouble();
							scan.nextLine();
							fitnessGoalsList.add(new WeightGoal(weightTarget));
							break;
						case 2:
							System.out.print("Enter miles target: ");
							double milesTarget = scan.nextDouble();
							scan.nextLine();
							fitnessGoalsList.add(new RunningGoal(milesTarget));
							break;
						case 3:
							System.out.print("Enter lifting goal: ");
							double liftingTarget = scan.nextDouble();
							scan.nextLine();
							fitnessGoalsList.add(new WeightLiftingGoal(liftingTarget));
							break;
						default:
							System.out.println("Invalid choice");
							break;
					}
					System.out.println();
					break;
				case 5:
					System.out.println("Displaying fitness goals...");
					System.out.println();
					if (fitnessGoalsList.isEmpty()) {
						System.out.println("No fitness goals set.");
					} else {
						System.out.println("Fitness Goals: ");
						for (FitnessGoal goal : fitnessGoalsList) {
							goal.printGoal();
						}
					}
					System.out.println();
					break;
				case 6:
					Scanner sc = new Scanner(System.in);
					System.out.println("Getting goal advice...");
					System.out.println();

					System.out.println("Choose the fitness goal you want advice for: ");
					System.out.println("1 - Weight Goal");
					System.out.println("2 - Running Goal");
					System.out.println("3 - Weightlifting Goal");
					System.out.print("Enter your choice: ");

					int goalChoice = sc.nextInt();
					sc.nextLine();
					System.out.println();
					switch (goalChoice) {
						case 1:
							FitnessGoal selectedGoal1 = new WeightGoal();
							selectedGoal1.giveAdvice();
							break;
						case 2:
							FitnessGoal selectedGoal2 = new RunningGoal();
							selectedGoal2.giveAdvice();
							break;
						case 3:
							FitnessGoal selectedGoal3 = new WeightLiftingGoal();
							selectedGoal3.giveAdvice();
							break;
						default:
							System.out.println("Invalid choice");
							break;
					}
					System.out.println();
					break;
				case 7:
					System.out.println("Update goal progress...");
					System.out.println();
					Scanner sr = new Scanner(System.in);
					if(fitnessGoalsList.isEmpty()){
						System.out.println("No fitness goals set.");
					} else {
						System.out.println("Choose the fitness goal you want to update progress for: ");
						for (int i = 0; i < fitnessGoalsList.size(); i++){
							System.out.println((i+1) + " - " + fitnessGoalsList.get(i).getClass().getSimpleName());
						}
						System.out.print("Enter your choice: ");
						int goalUpdate = sr.nextInt();
						sr.nextLine();
	
						if (goalUpdate < 1 || goalUpdate > fitnessGoalsList.size()) {
							System.out.println("Invalid choice!");
						} else {
							FitnessGoal selectedGoal = fitnessGoalsList.get(goalUpdate - 1);
							System.out.println("Updating progress for " + selectedGoal.getClass().getSimpleName() + " goal...");
	
							switch(selectedGoal.getClass().getSimpleName()){
								case "WeightGoal":
									System.out.print("Enter weight change (in pounds): ");
									double weightChange = sr.nextDouble();
									sr.nextLine();
									selectedGoal.updateProgress(weightChange);
									if (selectedGoal.getProgressPercentage() >= 100.0){
										user.setWeight(user.getWeight() + weightChange);
									}
									System.out.println();
									break;
								case "RunningGoal":
									System.out.print("Enter distance ran (in miles): ");
									double miles = sr.nextDouble();
									sr.nextLine();
									selectedGoal.updateProgress(miles);
									System.out.println();
									break;
								case "WeightLiftingGoal":
									System.out.print("Enter weight lifted (in pounds): ");
									double weightLifted = sr.nextDouble();
									sr.nextLine();
									selectedGoal.updateProgress(weightLifted);
									System.out.println();
									break;
								default:
									System.out.println("Unsupported goal type.");
									System.out.println();
									break;
							}
						}
					}
					break;
				case 8:
					System.out.println("Displaying account info...");
					System.out.println();
	
					System.out.println("Personal Information:");
					System.out.println("Name: " + user.getName());
					System.out.println("Age: " + user.getAge());
					System.out.println("Height: " + user.getHeight() + " inches");
					System.out.println("Weight: " + user.getWeight() + " pounds");
					System.out.println();
	
					if (fitnessGoalsList.isEmpty()){
						System.out.println("No fitness goals set.");
					} else {
						System.out.println("Fitness Goals: ");
						for (int i = 0; i < fitnessGoalsList.size(); i++){
							fitnessGoalsList.get(i).printGoal();
						}
					}
					System.out.println();
					break;
				case 9:
					System.out.println("Edit account info...");
					System.out.println();
	
					System.out.println("Choose the information you want to edit: ");
					System.out.println("1 - Name");
					System.out.println("2 - Age");
					System.out.println("3 - Height");
					System.out.println("4 - Weight");
					System.out.println("0 - Return to main menu");
					System.out.print("Enter your choice: ");
					Scanner in = new Scanner (System.in);
					int accEditChoice = in.nextInt();
					in.nextLine();
	
					switch(accEditChoice){
						case 1:
							System.out.print("Enter new name: ");
							String newName = in.nextLine();
							user.setName(newName);
							break;
						case 2:
							System.out.print("Enter new age: ");
							int newAge = in.nextInt();
							user.setAge(newAge);
							break;
						case 3:
							System.out.print("Enter new height in inches: ");
							int newHeight = in.nextInt();
							user.setHeight(newHeight);
							break;
						case 4:
							System.out.print("Enter new weight in pounds: ");
							int newWeight = in.nextInt();
							user.setWeight(newWeight);
							break;
						case 0:
							System.out.println("Returning to main menu...");
							break;
						default:
							System.out.println("Invalid choice");
							break;
					}
					System.out.println();
					break;
				default:
					System.out.println("ERROR: Please choose a valid number 0-9.");
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
	
	public static Workout createWorkout() {
		Scanner scnr = new Scanner(System.in);
		System.out.print("Date completed: ");
		String date = scnr.nextLine();
		
		System.out.print("Time completed: ");
		String time = scnr.nextLine();
		
		System.out.print("Total duration (in minutes): ");
		int duration = scnr.nextInt();
		System.out.println();
		
		Workout workout = new Workout(date, time, duration);
		addExercises(workout);
		
		return workout;
	}

	
	public static void addExercises(Workout w) {
		Scanner scnr = new Scanner(System.in);
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
			System.out.print("Duration (in minutes): ");
			int length = scnr.nextInt();
			scnr.nextLine();
			System.out.print("Exercise description: ");
			String description = scnr.nextLine();
			System.out.print("Calories burned: ");
			int cals = scnr.nextInt();
			scnr.nextLine();
			
			Exercise e = null;
			switch(type) {
				case 1: 
					e = new Weightlifting("weightlifting", name, cals, description, length);
					break;
				case 2:
					e = new Stretching("stretching", name, cals, description, length);
					break;
				case 3:
					e = new Cardio("cardio", name, cals, description, length);
					break;
				case 4:
					e = new MindBody("mind and body", name, cals, description, length);
					break;
			}
			
			w.addExercise(e);
			System.out.println();
			System.out.print("Would you like to add an exercise? (y/n): ");
			addAnother = scnr.nextLine();
		}
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
		System.out.println("7 - Update goal progress");
		System.out.println("8 - Display account info");
		System.out.println("9 - Edit account info");
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
