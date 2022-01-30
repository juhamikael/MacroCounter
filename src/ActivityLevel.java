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
        // 1 to 3 days per week         select  Light
        // 3 to 5 days per week         select  Moderate
        // 6 to 7 days per week         select  Active
        // Every Day + other activity   select  VeryActive
        if (aActivity == ActivityLevelMultiplierEnum.Light) {
            mActivity_level = (float) 1.3624;
            mActivity_level_text = "Light";
        } else if(aActivity == ActivityLevelMultiplierEnum.Moderate) {
            mActivity_level =  (float) 1.55;
            mActivity_level_text = "Moderate";
        } else if(aActivity == ActivityLevelMultiplierEnum.Active){
            mActivity_level =  (float) 1.709;
            mActivity_level_text = "Active";
        } else if(aActivity == ActivityLevelMultiplierEnum.VeryActive){
            mActivity_level = (float) 1.9;
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
