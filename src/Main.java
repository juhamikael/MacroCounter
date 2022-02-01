public class Main {
    public static void main(String[] args){
        // Configuring basic information
        BodyInformation person1 = new BodyInformation(108,199,1,33);

        // Configuring activity level to person 1
        ActivityLevel person1_activity = new ActivityLevel();
        person1_activity.setActivityLevel(ActivityLevelMultiplierEnum.Light);

        // Getting person1 BMR
        BMR person1_BMR = new BMR(person1);

        // Passing person1 BMR & Activity level to caloriesIntake calculation
        CaloriesIntake person1_calories = new CaloriesIntake(person1_BMR,person1_activity);
        person1_calories.setWeightLossStyle(CaloriesIntake_WeightLossStyle_Enum.WeightLoss);
        person1_calories.setCalories();

        MacroSplit person1_macros = new MacroSplit(person1_calories);
        person1_macros.setBodyType(MacroSplitEnum.Ectomorph);
        //Print information

        person1.printBodyInformation();
        person1_BMR.printBMR();
        person1_calories.printWeightLossStyle();
        person1_activity.printActivityLevel();
        person1_macros.printSplittedCalories();
        person1_calories.printCalories();
    }

}
