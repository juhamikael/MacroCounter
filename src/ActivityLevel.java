public class ActivityLevel extends CenterPrint {
    private float mActivity_level;
    private String mActivity_level_text;

    public ActivityLevel(){
        // Basic constructor
        // Activity level is set Light as default
        setActivityLevel(ActivityMultiplier.Light);
    }
    public ActivityLevel(float aActivity_level){
        // 1 parameter constructor
        mActivity_level = aActivity_level;
    }

    public void setActivityLevel( ActivityMultiplier aActivity ){
        // Choose between:
        // Light, Moderate, Active or Very Active
        // If you move:
        // 1 to 3 days per week         select  Light
        // 3 to 5 days per week         select  Moderate
        // 6 to 7 days per week         select  Active
        // Every Day + other activity   select  VeryActive
        if (aActivity == ActivityMultiplier.Light) {
            mActivity_level = (float) 1.3624;
            mActivity_level_text = "Light";
        } else if(aActivity == ActivityMultiplier.Moderate) {
            mActivity_level =  (float) 1.55;
            mActivity_level_text = "Moderate";
        } else if(aActivity == ActivityMultiplier.Active){
            mActivity_level =  (float) 1.709;
            mActivity_level_text = "Active";
        } else if(aActivity == ActivityMultiplier.VeryActive){
            mActivity_level = (float) 1.9;
            mActivity_level_text = "Very Active";
        }
    }
    public float getActivityLevel(){
        return mActivity_level;
    }
    public void printActivityLevel(){
        centerPrint("Activity");
        System.out.println("Activity: " + mActivity_level_text);
        System.out.println("Activity multiplier: " + mActivity_level);
        printLine();
    }

}
