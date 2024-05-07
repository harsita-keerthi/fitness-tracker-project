public class Weightlifting extends Exercise{
    private int duration;

    public Weightlifting(String activityType, String name, int caloriesBurned, String description){
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
        System.out.println("Strength Training or Weightlifting: Strength training helps build and maintain muscle mass, improve bone density, enhance metabolism, and support functional movement patterns.");
    }
}
