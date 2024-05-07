public class Cardio extends Exercise{
    private int duration;

    public Cardio(String activityType, String name, int caloriesBurned, String description, int duration){
        super(activityType, name, caloriesBurned, description);
        this.duration = duration;
    }

    public int getDuration(){
        return duration;
    }

    @Override
    public void displayDetails(){
        System.out.println("Exercise: " + getName());
        System.out.println("Type: " + getActivityType());
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Calories burned: " + getCaloriesBurned());
        System.out.println("Description: " + getDescription());
        System.out.println();
    }

    @Override
    public void displayType(){
        System.out.println("Cardiovascular or Aerobic Exercise: Cardio exercises are crucial for improving heart health, increasing endurance, burning calories, and boosting overall stamina.");
    }
}
