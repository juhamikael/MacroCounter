public class CaloriesIntake extends CenterPrint {
    private int mCaloriesIntakeDaily;
    private int mCaloriesIntakeWeekly;
    private float mWeightLossMultiplier;
    private String mWeightLossStyle;
    private final BMR mUserBMR;
    private final ActivityLevel mUserActivity;

    public CaloriesIntake(BMR aBMR, ActivityLevel aUserActivity){
        // Default constructor to get access to BMR and userActivity
        mUserBMR = aBMR;
        mUserActivity = aUserActivity;
        // Setting daily and weekly calories here
        setWeightLossStyle(WeightLossStyle.MaintainWeight);
    }

    public void setCalories(){
        // Using variables for getters for easier reading
        // Using multipliers: weightLoss, activityLevel and BMR
        // which was set in BMR and ActivityLevel to count calories
        float weightLossMultiplier = getWeightLossMultiplier();
        float activityLevel = mUserActivity.getActivityLevel();
        int BMR = mUserBMR.getBMR();
        int BMR7 = mUserBMR.getBMR() * 7;
        // Returning both daily and weekly calories here
        mCaloriesIntakeDaily = (int) (BMR * weightLossMultiplier * activityLevel);
        mCaloriesIntakeWeekly = (int) (BMR7 * weightLossMultiplier * activityLevel);
    }

    public void setWeightLossStyle(WeightLossStyle aWeightlossStyle) {
        // Different weight loss styles, using Enum for this
        // Each have different multiplier, we need this to count daily calories intake
        if (aWeightlossStyle == WeightLossStyle.MaintainWeight) {
            mWeightLossMultiplier = 1;
            mWeightLossStyle = "Maintain weight";
        } else if (aWeightlossStyle == WeightLossStyle.MildWeightLoss) {
            mWeightLossMultiplier = (float) 0.9224;
            mWeightLossStyle = "Mild weight loss";
        } else if (aWeightlossStyle == WeightLossStyle.WeightLoss) {
            mWeightLossMultiplier = (float) 0.8445;
            mWeightLossStyle = "Normal weight loss";
        } else if (aWeightlossStyle == WeightLossStyle.ExtremeWeightLoss) {
            mWeightLossMultiplier = (float) 0.689;
            mWeightLossStyle = "Extreme weight loss";
        }
    }
    public String getWeightLossStyle(){
        return mWeightLossStyle;
    }
    public float getWeightLossMultiplier() {
        return mWeightLossMultiplier;
    }

    public int getCaloriesDaily(){
        return mCaloriesIntakeDaily;
    }
    public int getCaloriesWeekly(){
       return mCaloriesIntakeWeekly;
    }
    public void printWeightLossStyle(){
        centerPrint("Weight goal");
        System.out.println("Goal: " + getWeightLossStyle());
        System.out.println("Multiplier: " + getWeightLossMultiplier());
        printLine();
    }
    public void printCalories(){
        centerPrint("Calories");
        System.out.println("Calories Daily: " + getCaloriesDaily());
        System.out.println("Calories Weekly: " + getCaloriesWeekly());
        printLine();
    }
}

