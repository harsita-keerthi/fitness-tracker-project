import java.util.*;
public class User {
    private String name;
    private double age;
    private double heightIn;
    private double weightLbs;
    private List workouts;
    private List goals;

    public User (String name, double age, double height, double weight){
        this.name = name;
        this.age = age;
        this.weightLbs = weight;
        this.heightIn = height;
        workouts = new ArrayList<Workout>();
        goals = new ArrayList<FitnessGoal>();
    }

    // getters and setters
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public double getWeight(){
        return weightLbs;
    }

    public void setWeight(double weight){
        this.weightLbs = weight;
    }

    public double getHeight(){
        return heightIn;
    }

    public void setHeight(double height){
        this.heightIn = height;
    }
    // updating personal info
    public void updatePersonalInfo(int age, double weight, double height){
        this.age = age;
        this.weightLbs = weight;
        this.heightIn = height;
    }
    // method for accessing user's workouts
    public void addWorkout(Workout workout){
        workouts.add(workout);
    }

    public List<Workout> getWorkouts(){
        return workouts;
    }
    
    public void addGoal(FitnessGoal goal){
        goals.add(goal);
    }
    
    public List<Workout> getGoals(){
        return goals;
    }

    public void printUser() {
    	System.out.println("Name: " + name);
    	System.out.println("Age: " + age + " years");
    	System.out.println("Weight: " + weightLbs + " lbs");
    	System.out.println("Height: " + heightIn + " inches");
    }
}
