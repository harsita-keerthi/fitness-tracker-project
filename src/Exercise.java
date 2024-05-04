abstract class Exercise {
    private String activityType;
    private String name;
    private int caloriesBurned;
    private String description;

    public Exercise(String activityType, String name, int caloriesBurned, String description){
        this.activityType = activityType;
        this.name = name;
        this.caloriesBurned = caloriesBurned;
        this.description = description;
    }

    //getters and setters
    public String getActivityType(){
        return activityType;
    }

    public void setActivityType(String activityType){
        this.activityType = activityType;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getCaloriesBurned(){
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned){
        this.caloriesBurned = caloriesBurned;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
    //abstract methods, extend classes
    public abstract void displayDetails();
}
