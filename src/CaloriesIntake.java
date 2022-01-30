public class CaloriesIntake {
    private int mCaloriesIntakeDaily;
    private int mCaloriesIntakeWeekly;
    private float mWeightLossMultiplier;
    private String mWeightLossStyle;
    private final BMR mUserBMR;
    private final ActivityLevel mUserActivity;

    public CaloriesIntake(BMR aBMR, ActivityLevel aUserActivity){
        // Getting values from BMR and userActivity
        mUserBMR = aBMR;
        mUserActivity = aUserActivity;
        // Setting "weight loss style" to define daily and weekly calories here
        setWeightLossStyle(CaloriesIntake_WeightLossStyle_Enum.MaintainWeight);
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

    public void setWeightLossStyle(CaloriesIntake_WeightLossStyle_Enum aWeightlossStyle) {
        // Different weight loss styles, using Enum for this
        // Each have different multiplier, we need this to count daily calories intake
        if (aWeightlossStyle == CaloriesIntake_WeightLossStyle_Enum.MaintainWeight) {
            mWeightLossMultiplier = 1;
            mWeightLossStyle = "Maintain weight";
        } else if (aWeightlossStyle == CaloriesIntake_WeightLossStyle_Enum.MildWeightLoss) {
            mWeightLossMultiplier = (float) 0.9224;
            mWeightLossStyle = "Mild weight loss";
        } else if (aWeightlossStyle == CaloriesIntake_WeightLossStyle_Enum.WeightLoss) {
            mWeightLossMultiplier = (float) 0.8445;
            mWeightLossStyle = "Normal weight loss";
        } else if (aWeightlossStyle == CaloriesIntake_WeightLossStyle_Enum.ExtremeWeightLoss) {
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

        OwnLibrary.centerPrint("Weight goal");
        System.out.println("Goal: " + getWeightLossStyle());
        System.out.println("Multiplier: " + getWeightLossMultiplier());
        OwnLibrary.printLine();
    }
    public void printCalories(){
        OwnLibrary.centerPrint("Calories");
        System.out.println("Calories Daily: " + getCaloriesDaily());
        System.out.println("Calories Weekly: " + getCaloriesWeekly());
        OwnLibrary.printLine();
    }
}

