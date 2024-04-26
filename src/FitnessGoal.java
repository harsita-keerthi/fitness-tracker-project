public interface FitnessGoal {
    void updateProgress(double progress);
    boolean isGoalAchieved();
    void setGoal(double goalTarget);
    void giveAdvice();
}
