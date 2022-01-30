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
    // Check CenterPrint file for more info about function centerPrint() instance
    private CenterPrint center = new CenterPrint();

    public BodyInformation(){
        // Basic Constructor
        // Setting everything to 0
        mWeight = 0;
        mHeight = 0;
        mGender = 0;
        mAge = 0;
        mBMI = 0;
    }
    public BodyInformation(float aWeight, float aHeight, int aGender, int aAge){
        // 4 Parameter constructor
        mWeight = aWeight;
        mHeight = aHeight;
        mGender = aGender;
        mAge = aAge;
        setBMI();
    }
    public void setWeight(float aWeight){
        // Making sure that height is between 40 cm and 250 cm
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
        // Making sure that height is between 40 cm and 250 cm
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
        // Getting gender as string
        return mGender_text;
    }
    public void setBMI(){
        // As height in BMI need to be in format x.xx
        // We are using height as int ex. 190 cm, so we are dividing it by 100 to make sure BMI
        // is calculated correctly
        float height = mHeight / 100;
        double BMI = mWeight/(height*height);
        mBMI = (float) BMI;
    }
    public float getBMI(){
        return mBMI;
    }
    public void printBMI(){
        // BMI was printed as a xx.xxxxx, setting it to show only 2 decimal places here
        DecimalFormat df = new DecimalFormat("#.##");
        // Out put was with comma, and gotta get it as . dot
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(2);
        System.out.println("BMI: " + df.format(getBMI()));
    }
    public void printBodyInformation(){
        // Basic printing to show given information and BMI
        // Check CenterPrint file for more info about function center.centerPrint() method
        center.centerPrint("Body Information");
        System.out.println("Weight: " + mWeight + " kg");
        System.out.println("Height: " + mHeight + " cm");
        printBMI();
        System.out.println("----------------------------");
    }
}