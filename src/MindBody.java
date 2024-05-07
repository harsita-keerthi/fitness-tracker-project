public class MindBody extends Exercise {
    private int duration;

    public MindBody(String activityType, String name, int caloriesBurned, String description){
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
        System.out.println("Mind-Body Exercises: Mind-body exercises like yoga, tai chi, or Pilates offer numerous benefits, including stress reduction, improved mental focus, enhanced relaxation, and better mind-body awareness.");
    }
}
