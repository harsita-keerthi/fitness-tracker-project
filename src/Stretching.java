public class Stretching extends Exercise {
    private int duration;

    public Stretching(String activityType, String name, int caloriesBurned, String description){
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
        System.out.println("Flexibility and Stretching: Flexibility exercises promote joint health, reduce muscle tension, improve posture, and enhance range of motion, which is essential for overall mobility and injury prevention.");
    }
}
