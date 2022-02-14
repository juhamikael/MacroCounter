public class Main {
    public static void main(String[] args){
        // Configuring basic information

        BodyInformation person = new BodyInformation(105,190,1,33);

        // Configuring activity level to person 1
        ActivityLevel person_activity = new ActivityLevel();
        person_activity.setActivityLevel(ActivityLevelMultiplierEnum.Light);

        // Getting person BMR
        BMR person_BMR = new BMR(person);

        // Passing person BMR & Activity level to caloriesIntake calculation
        CaloriesIntake person_calories = new CaloriesIntake(person_BMR,person_activity);
        person_calories.setWeightLossStyle(CaloriesIntake_WeightLossStyle_Enum.WeightLoss);
        person_calories.setCalories();

        MacroSplit person_macros = new MacroSplit(person_calories);
        person_macros.setBodyType(MacroSplitEnum.Ectomorph);

        //Print information
        person.printBodyInformation();
        person_BMR.printBMR();
        person_calories.printWeightLossStyle();
        person_activity.printActivityLevel();
        person_macros.printSplittedCalories();
        person_calories.printCalories();

    }


}
