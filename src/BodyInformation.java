import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class BodyInformation{
    private float mWeight;
    private float mHeight;
    private int mAge;
    private int mGender;
    private String mGender_text;
    private float mBMI;
    private CenterPrint center = new CenterPrint();

    public BodyInformation(){
        mWeight = 0;
        mHeight = 0;
        mGender = 0;
        mAge = 0;
        mBMI = 0;
    }
    public BodyInformation(float aWeight, float aHeight, int aGender, int aAge){
        mWeight = aWeight;
        mHeight = aHeight;
        mGender = aGender;
        mAge = aAge;
    }
    public void setWeight(float aWeight){
        if(aWeight > 2 && aWeight < 500){
            mWeight = aWeight;
        }
        else{
            System.out.println("ERROR, WEIGHT too low or high");
            mWeight = 0;
        }
    }
    public float getWeight(){
        return mWeight;
    }
    public void setHeight(float aHeight){
        if(aHeight > 40 && aHeight < 250){
            mHeight = aHeight;
        }
        else{
            System.out.println("ERROR, HEIGHT too low or high");
            mHeight = 0;
        }
    }
    public float getHeight(){
        return mHeight;
    }
    public void setGender(int aGender){
        if (aGender == 1){
            mGender = 1;
            mGender_text="Male";
        }
        else if (aGender == 2){
            mGender = 2;
            mGender_text = "Female";
        }
        else{
            mGender = 0;
            mGender_text = "N/A";
        }
    }
    public void setAge(int aAge){
        mAge = aAge;
    }
    public int getAge(){
        return mAge;
    }
    public int getGender(){
        return mGender;
    }
    public String getGender_text(){
        return mGender_text;
    }
    public void setBMI(){
        float height = mHeight / 100;
        double BMI = mWeight/(height*height);
        mBMI = (float) BMI;
    }
    public float getBMI(){
        return mBMI;
    }
    public void printBMI(){
        DecimalFormat df = new DecimalFormat("#.##");
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(2);
        System.out.println("BMI: " + df.format(getBMI()));
    }
    public void printBodyInformation(){
        center.centerPrint("Body Information");
        System.out.println("Weight: " + mWeight + " kg");
        System.out.println("Height: " + mHeight + " cm");
        setBMI();
        printBMI();
        System.out.println("----------------------------");
    }
}