public interface FitnessGoal {
	void updateProgress(double progress);
    boolean isGoalAchieved();
    void giveAdvice();
    void printGoal();
}

class WeightGoal implements FitnessGoal {
	private double weightTarget;
	private double progressPercentage;
	private double weightChange; // can be negative or positive depending on weight loss/gain goal
	
	WeightGoal(){

	}

	WeightGoal(double weightTarget) {
		this.weightTarget = weightTarget;
		progressPercentage = 0.0;
		weightChange = 0.0;
	}
	
	public void updateProgress(double weight) {
		weightChange += weight; 
		progressPercentage = (weightChange / weightTarget) * 100.0;
		if (progressPercentage > 100.0) { progressPercentage = 100.0; }
	}
	
	public boolean isGoalAchieved() {
		return progressPercentage >= 100.0;
	}
	
	public void giveAdvice() {
		System.out.println("Advice for completing this weight goal:");
		if (weightTarget < 0) {
			System.out.println(" * Keep physically active daily");
			System.out.println(" * Stay hydrated with water and avoid drinks that have added sugar, such as soda");
			System.out.println(" * Swap usual foods and ingredients with healthier alternatives");
		}
		else {
			System.out.println(" * Stay active to boost your appetite");
			System.out.println(" * Eat foods with healthy fats to gain weight (avocado, peanut butter, etc.)");
			System.out.println(" * Eat nutrient-rich food such as nuts and cheese");
		}
	}
	
	public void printGoal() {
		System.out.print("Your weight goal: ");
		if (weightTarget < 0) { System.out.print("lose "); }
		else { System.out.print("gain "); }
		System.out.print(Math.abs(weightTarget) + " pounds");
		System.out.println();
		
		System.out.println("Progress completed: " + progressPercentage + "%");
		if (isGoalAchieved()) {
			System.out.println("Congrats! You've completed this goal.");
		}
	}
}

class RunningGoal implements FitnessGoal {
	private double milesTarget;
	private double progressPercentage;
	private double totalMiles; 
	
	RunningGoal(){

	}

	RunningGoal(double milesTarget) {
		this.milesTarget = milesTarget;
		progressPercentage = 0.0;
		totalMiles = 0.0;
	}
	
	public void updateProgress(double miles) {
		totalMiles += miles; 
		progressPercentage = (totalMiles / milesTarget) * 100.0;
		if (progressPercentage > 100.0) { progressPercentage = 100.0; }
	}
	
	public boolean isGoalAchieved() {
		return progressPercentage >= 100.0;
	}
	
	public void giveAdvice() {
		System.out.println("Advice for completing this running goal:");
		System.out.println(" * Stretch before and after your run");
		System.out.println(" * Try out pilates, yoga, and/or climbing to increase flexibility and strength");
		System.out.println(" * Pace yourself and keep a comfortable and consistent stride");
		System.out.println(" * Make sure to hydrate before, during, and after running");
	}
	
	public void printGoal() {
		System.out.print("Your running goal: run " + milesTarget + " miles");
		System.out.println();
		
		System.out.println("Progress completed: " + progressPercentage + "%");
		if (isGoalAchieved()) {
			System.out.println("Congrats! You've completed this goal.");
		}
	}
}

class WeightLiftingGoal implements FitnessGoal {
	private double liftingTarget;
	private double progressPercentage;
	private double weightPR;

	WeightLiftingGoal(){

	}

	WeightLiftingGoal(double liftingTarget) {
		this.liftingTarget = liftingTarget;
		progressPercentage = 0.0;
		weightPR = 0.0;
	}
	
	public void updateProgress(double weightLifted) {
		if (weightLifted > weightPR) {
			weightPR = weightLifted;
		}
		progressPercentage = (weightPR / liftingTarget) * 100.0;
		if (progressPercentage > 100.0) { progressPercentage = 100.0; }
	}
	
	public boolean isGoalAchieved() {
		return progressPercentage >= 100.0;
	}
	
	public void giveAdvice() {
		System.out.println("Advice for completing this weight lifting goal:");
		System.out.println(" * Check that you are using proper form");
		System.out.println(" * Don't hold your breath, breathe out as you lift and in as you lower");
		System.out.println(" * Add strength training to your fitness routine");
		System.out.println(" * Don't ignore pain and/or push yourself too hard");
	}
	
	public void printGoal() {
		System.out.print("Your weightlifting goal: lift " + liftingTarget + " pounds");
		System.out.println();
		
		System.out.println("Progress completed: " + progressPercentage + "%");
		if (isGoalAchieved()) {
			System.out.println("Congrats! You've completed this goal.");
		}
	}
}
