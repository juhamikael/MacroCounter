public class Macrot {
    private String mFoodName;
    private float mProtein;
    private float mFat;
    private float mCarbs;
    private float mWeight = 0;
    private float mAmountTaken;
    private float mDefaultWeight = 100;


    public Macrot(){
        mFoodName = "N/A";
        mProtein = 0;
        mCarbs = 0;
        mFat = 0;
    }

    public Macrot(String aFoodName, float aProtein, float aCarbs, float aFat){
        mFoodName = aFoodName;
        mProtein = aProtein;
        mCarbs = aCarbs;
        mFat = aFat;
    }
    public void setFoodName(String aFoodName){
        mFoodName = aFoodName;
    }
    public void setProtein(float aProtein) {
        mProtein = aProtein;
    }
    public void setCarbs(float aCarbs) {
        mCarbs = aCarbs;
    }
    public void setFat(float aFat) {
        mFat = aFat;
    }
    public void setWeight(float aWeight){
        mWeight = aWeight;
    }
    public float getWeight() {
        return mWeight;
    }
    public float getWeightMultiplier(){
        if(mWeight > 0){
            float multiplier = getWeight() / 100 ;
            return multiplier;
        }else {
            return 1;
        }
    }
    public void setAmountTaken(float aAmountTaken){
        mAmountTaken = aAmountTaken;
    }
    public float getAmountTaken() {
        if (getWeightMultiplier() != 0 && getWeightMultiplier() > 0) {
            mAmountTaken = getWeightMultiplier();
        }
        else {
            mAmountTaken = 0;
        }
        return mAmountTaken;
    }
    public String getFoodName(){
        return mFoodName;
    }
    public float getProtein() {
        return mProtein* getWeightMultiplier();
    }
    public float getCarbs(){
        return mCarbs* getWeightMultiplier();
    }
    public float getFat() {
        return mFat * getWeightMultiplier();
    }
    public float getDefaultWeight(){
        return mDefaultWeight;
    }

    public float getMacroValue(){
        float protein = getProtein() * 4;
        float carbs = getCarbs() * 4;
        float fat = getFat() * 9;
        float totalMacro = (protein+carbs+fat);
        return totalMacro;
    }
    public void printMacroValue(){
        System.out.println("-------------------------");
        System.out.println("Food name: " +getFoodName());
        if (getWeight() == 0){
            System.out.println("Weight: " + getDefaultWeight() + " g");
        }else{
            System.out.println("Weight: " + getWeight() + " g");
        }
        System.out.println("Protein: " + getProtein() + " g");
        System.out.println("Carbs: " + getCarbs() + " g");
        System.out.println("Fat: " + getFat() + " g");
        System.out.println("Total calories "+getMacroValue() + " kcal");
        System.out.println("-------------------------\n");
    }
    public void printAmount(){
        System.out.println(getAmountTaken());
    }

}
