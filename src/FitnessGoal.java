public interface FitnessGoal {
	void updateProgress(double progress);
    boolean isGoalAchieved();
    void giveAdvice();
}

class WeightGoal implements FitnessGoal {
	private double weightTarget;
	private double progressPercentage;
	private double weightChange; // can be negative or positive depending on weight loss/gain goal
	
	WeightGoal(double weightTarget) {
		this.weightTarget = weightTarget;
		progressPercentage = 0.0;
		weightChange = 0.0;
	}
	
	public void updateProgress(double weight) {
		weightChange += weight; 
		progressPercentage = weightChange / weightTarget; 
		if (progressPercentage > 100.0) { progressPercentage = 100.0; }
	}
	
	public boolean isGoalAchieved() {
		if (Math.abs(progressPercentage - 100.0) > 0.00001) { return true; }
		return false; 
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
}

class RunningGoal implements FitnessGoal {
	private double milesTarget;
	private double progressPercentage;
	private double totalMiles; 
	
	RunningGoal(double milesTarget) {
		this.milesTarget = milesTarget;
		progressPercentage = 0.0;
		totalMiles = 0.0;
	}
	
	public void updateProgress(double miles) {
		totalMiles += miles; 
		progressPercentage = totalMiles / milesTarget; 
		if (progressPercentage > 100.0) { progressPercentage = 100.0; }
	}
	
	public boolean isGoalAchieved() {
		if (Math.abs(progressPercentage - 100.0) > 0.00001) { return true; }
		return false; 
	}
	
	public void giveAdvice() {
		System.out.println("Advice for completing this running goal:");
		System.out.println(" * Stretch before and after your run");
		System.out.println(" * Try out pilates, yoga, and/or climbing to increase flexibility and strength");
		System.out.println(" * Pace yourself and keep a comfortable and consistent stride");
		System.out.println(" * Make sure to hydrate before, during, and after running");
	}
}

class WeightLiftingGoal implements FitnessGoal {
	private double liftingTarget;
	private double progressPercentage;
	private double weightPR;
	
	WeightLiftingGoal(double liftingTarget) {
		this.liftingTarget = liftingTarget;
		progressPercentage = 0.0;
		weightPR = 0.0;
	}
	
	public void updateProgress(double weightLifted) {
		if (weightLifted > weightPR) {
			weightPR = weightLifted;
		}
		progressPercentage = weightPR / liftingTarget; 
		if (progressPercentage > 100.0) { progressPercentage = 100.0; }
	}
	
	public boolean isGoalAchieved() {
		if (Math.abs(progressPercentage - 100.0) > 0.00001) { return true; }
		return false; 
	}
	
	public void giveAdvice() {
		System.out.println("Advice for completing this weight lifting goal:");
		System.out.println(" * Check that you are usign proper form");
		System.out.println(" * Don't hold your breath, breathe out as you lift and in as you lower");
		System.out.println(" * Add strength training to your fitness routine");
		System.out.println(" * Don't ignore pain and/or push yourself too hard");
	}
}
