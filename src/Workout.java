import java.util.*;
public class Workout {
    private List <Exercise> exercises;
    private String date;
    private String time;
    private int caloriesBurned;
    private int totalDuration;

    public Workout (String date, String time, int totalDuration){
        this.date = date;
        this.time = time; 
        this.totalDuration = totalDuration;
        caloriesBurned = 0; 
        exercises = new ArrayList<Exercise>();
    }

    public void addExercise(Exercise exercise){ 
        exercises.add(exercise);
        caloriesBurned += exercise.getCaloriesBurned();
    }
    

    public void displaySummary() {
        System.out.println("Workout completed on " + date + " at " + time);
        System.out.println("Total duration: " + totalDuration + " minutes");
        System.out.println("Total calories burned: " + caloriesBurned);
        System.out.println();
        System.out.println("Exercises in this workout: ");
    	
    	for (Exercise e : exercises) {
        	e.displayDetails();
        }
    }
    
    // getters and setters
    public void setDate(String date) {
    	this.date = date;
    }
    public void setTime(String time) {
    	this.time = time;
    }
    public void setTotalDuration(int totalDuration) {
    	this.totalDuration = totalDuration;
    }
    
    public String getDate() {
    	return date;
    }
    public String getTime() {
    	return time;
    }
    public int getCaloriesBurned() {
    	return caloriesBurned;
    }
    public int totalDuration() {
    	return totalDuration;
    }
}
