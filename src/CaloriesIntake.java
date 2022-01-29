public class CaloriesIntake extends CenterPrint {
    private int mCaloriesIntakeDaily;
    private int mCaloriesIntakeWeekly;
    private BMR mUserBMR = new BMR();
    private ActivityLevel mUserActivity = new ActivityLevel();

    public CaloriesIntake(BMR aBMR, ActivityLevel aUserActivity){
        mUserBMR = aBMR;
        mUserActivity = aUserActivity;
        setCalories();
    }

    public void setCalories(){
        float weightlossMultiplier = mUserBMR.getWeightLossMultiplier();
        float activityLevel = mUserActivity.getActivityLevel();
        int BMR = mUserBMR.getBMR();
        int BMR7 = mUserBMR.getBMR() * 7;
        mCaloriesIntakeDaily = (int) (BMR * weightlossMultiplier * activityLevel);
        mCaloriesIntakeWeekly = (int) (BMR7 * weightlossMultiplier * activityLevel);
    }
    public int getCaloriesDaily(){
        return mCaloriesIntakeDaily;
    }
    public int getCaloriesWeekly(){
       return mCaloriesIntakeWeekly;
    }
    public void printCalories(){
        centerPrint("Calories");
        System.out.println("Calories Daily: " + getCaloriesDaily());
        System.out.println("Calories Weekly: " + getCaloriesWeekly());
        printLine();
    }
}

