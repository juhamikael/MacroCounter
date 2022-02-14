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
    private String mBMI_string;
    // Check CenterPrint file for more info about function centerPrint() instance


    public BodyInformation(){
        // Everything to 0 by default
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
        setGender(aGender);
        mAge = aAge;
        setBMI();
        setBMI_string(mBMI);
    }

    public void setBMI_string(float aBMI){
        if (aBMI < 16){
            mBMI_string = "Underweight (Severe thinness)";
        }
        else if (aBMI >= 16 && aBMI < 17){
            mBMI_string = "Underweight (Moderate thinness)";
        }
        else if (aBMI >= 17 && aBMI < 18.5){
            mBMI_string = "Underweight (Mild thinness)";
        }
        else if (aBMI >= 18.5 && aBMI < 25){
            mBMI_string = "Normal Weight";
        }
        else if (aBMI >= 25 && aBMI < 30){
            mBMI_string = "Overweight (Pre-obese)";
        }
        else if (aBMI >= 30 && aBMI < 35){
            mBMI_string = "Obese (Class I)";
        }
        else if (aBMI >= 35 && aBMI < 40){
            mBMI_string = "Obese (Class II)";
        }
        else if (aBMI >= 40){
            mBMI_string = "Obese (Class III)";
        }
    }
    public String getBMI_text(){
        return mBMI_string;
    }


    // Obese (Class I)	30.0 – 34.9
    // Obese (Class II)	35.0 – 39.9
    // Obese (Class III)	≥ 40.0	≥

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
        System.out.print("BMI: " + df.format(getBMI()));
        System.out.println(" - " + getBMI_text());

    }
    public void printBodyInformation(){
        // Basic printing to show given information and BMI
        // Check CenterPrint file for more info about function center.centerPrint() method
        OwnLibrary.centerPrint("Body Information");
        System.out.println("Weight: " + mWeight + " kg");
        System.out.println("Height: " + mHeight + " cm");
        System.out.println("Age: " + mAge);
        printBMI();
        System.out.println("Gender: " + getGender_text());
        OwnLibrary.printLine();
    }
}

