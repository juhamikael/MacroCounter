public class Main {

    public static void main(String[] args){
        BodyInformation person1 = new BodyInformation(116,187,1,29);
        ActivityLevel person1_activity = new ActivityLevel();
        person1_activity.setActivityLevel(ActivityMultiplier.Moderate);
        person1_activity.printActivityLevel();
        BMR person1_BRM = new BMR(person1);
        person1_BRM.setWeightLossStyle(WeightLossStyle.MaintainWeight);
        person1_BRM.printBMR();
        CaloriesIntake person1_calories = new CaloriesIntake(person1_BRM,person1_activity);
        person1_calories.printCalories();

    }

}
