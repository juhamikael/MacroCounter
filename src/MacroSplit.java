public class MacroSplit {
    private int mProtein;
    private int mCarbs;
    private int mFat;
    private float mProteinMultiplier;
    private float mCarbsMultiplier;
    private float mFatMultiplier;
    private String mBodyType;
    private final CaloriesIntake mUserCalories;

    // COMMENTS COMING

    public MacroSplit(CaloriesIntake aUserCalories){
        mUserCalories = aUserCalories;
        setSplittedCalories(mUserCalories);
    }
    public void setBodyType(MacroSplitEnum aBodyType){
        if(aBodyType == MacroSplitEnum.Ectomorph){
            mBodyType = "Ectomorph";
            mProteinMultiplier = 0.25f;
            mCarbsMultiplier = 0.55f;
            mFatMultiplier = 0.2f;
        }
        if(aBodyType == MacroSplitEnum.Mesomorph){
            mBodyType = "Mesomorph";
            mProteinMultiplier = 0.3f;
            mCarbsMultiplier = 0.4f;
            mFatMultiplier = 0.3f;
        }
        if(aBodyType == MacroSplitEnum.Endomorph){
            mBodyType = "Endomorph";
            mProteinMultiplier = 0.35f;
            mCarbsMultiplier = 0.25f;
            mFatMultiplier = 0.4f;
        }
    }
    public int getProtein(){
        return (int) (mProtein * mProteinMultiplier);
    }
    public int getCarbs(){
        return (int) (mCarbs * mCarbsMultiplier);
    }
    public int getFat(){
        return (int) (mFat * mFatMultiplier);
    }
    public void setSplittedCalories(CaloriesIntake aUserCalories){
        mProtein = aUserCalories.getCaloriesDaily()/4;
        mCarbs = aUserCalories.getCaloriesDaily()/4;
        mFat = aUserCalories.getCaloriesDaily()/9;
    }

    public String getBodyType(){
        return mBodyType;
    }
    public void printMultipliers(){
        System.out.println("Protein: "+((int)(mProteinMultiplier*100) + "%"));
        System.out.println("Carbs: ");
        System.out.println("Fat: ");
    }

    public void printOneMacro(String aString, float aMultiplier, int aGetter){
        System.out.print(aString + ": ");
        System.out.print(((int)(aMultiplier*100) + "% = "));
        System.out.println(aGetter + " g");
    }

    public void printSplittedCalories(){
        OwnLibrary.centerPrint("Splitted Macros");
        System.out.println("Body type: "+getBodyType());
        System.out.println("Daily calories: "+ mUserCalories.getCaloriesDaily());
        printOneMacro("Protein",mProteinMultiplier, getProtein());
        printOneMacro("Carbs",mCarbsMultiplier, getCarbs());
        printOneMacro("Fat",mFatMultiplier, getFat());
        OwnLibrary.printLine();
    }
}

