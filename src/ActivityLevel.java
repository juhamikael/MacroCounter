public class ActivityLevel {
    private float mActivity_level;
    private String mActivity_level_text;

    public ActivityLevel(){
        // Activity level is set Light as default
        setActivityLevel(ActivityLevelMultiplierEnum.Light);
    }
    public ActivityLevel(float aActivity_level){
        mActivity_level = aActivity_level;
    }

    public void setActivityLevel( ActivityLevelMultiplierEnum aActivity ){
        // Choose between:
        // Light, Moderate, Active or Very Active
        // If you move:
        // little / no exercise         select  Sedentary
        // 1 to 3 days per week         select  Light
        // 3 to 5 days per week         select  Moderate
        // 6 to 7 days per week         select  Active
        // Every Day + other activity   select  VeryActive
        if (aActivity== ActivityLevelMultiplierEnum.Sedentary){
            mActivity_level = 1.2f;
            mActivity_level_text = "Sedentary";
        } else if (aActivity == ActivityLevelMultiplierEnum.Light) {
            mActivity_level = 1.3624f;
            mActivity_level_text = "Light";
        } else if(aActivity == ActivityLevelMultiplierEnum.Moderate) {
            mActivity_level =  1.55f;
            mActivity_level_text = "Moderate";
        } else if(aActivity == ActivityLevelMultiplierEnum.Active){
            mActivity_level =  1.709f;
            mActivity_level_text = "Active";
        } else if(aActivity == ActivityLevelMultiplierEnum.VeryActive){
            mActivity_level = 1.9f;
            mActivity_level_text = "Very Active";
        }
    }
    public float getActivityLevel(){
        return mActivity_level;
    }
    public void printActivityLevel(){
        OwnLibrary.centerPrint("Activity");
        System.out.println("Activity: " + mActivity_level_text);
        System.out.println("Activity multiplier: " + mActivity_level);
        OwnLibrary.printLine();

    }

}
