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
            mProteinMultiplier = (float) 0.25;
            mCarbsMultiplier = (float) 0.55;
            mFatMultiplier = (float) 0.2;
        }
        if(aBodyType == MacroSplitEnum.Mesomorph){
            mBodyType = "Mesomorph";
            mProteinMultiplier = (float) 0.3;
            mCarbsMultiplier = (float) 0.4;
            mFatMultiplier = (float) 0.3;
        }
        if(aBodyType == MacroSplitEnum.Endomorph){
            mBodyType = "Endomorph";
            mProteinMultiplier = (float) 0.35;
            mCarbsMultiplier = (float) 0.25;
            mFatMultiplier = (float) 0.4;
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

