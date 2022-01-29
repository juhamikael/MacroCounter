
public class BMR extends CenterPrint {
    private int mBMR;
    private float mWeightLossMultiplier;
    private BodyInformation mBodyInfo = new BodyInformation();
    private ActivityLevel mActivityLevel = new ActivityLevel();

    public BMR() {
        mBMR = 0;
    }
    public BMR(BodyInformation aBodyInfo) {
        mBodyInfo = aBodyInfo;
        setWeightLossStyle(WeightLossStyle.MaintainWeight);
        setBMR();
    }
    public void setWeightLossStyle(WeightLossStyle aWeightlossStyle) {
        if (aWeightlossStyle == WeightLossStyle.MaintainWeight) {
            mWeightLossMultiplier = 1;
        } else if (aWeightlossStyle == WeightLossStyle.MildWeightLoss) {
            mWeightLossMultiplier = (float) 0.9224;
        } else if (aWeightlossStyle == WeightLossStyle.WeightLoss) {
            mWeightLossMultiplier = (float) 0.8445;
        } else if (aWeightlossStyle == WeightLossStyle.ExtremeWeightLoss) {
            mWeightLossMultiplier = (float) 0.689;
        }
    }
    public float getWeightLossMultiplier() {
        return mWeightLossMultiplier;
    }
    public void setBMR() {
        float mifflinStJeor = (float) ((10 * mBodyInfo.getWeight()) + (6.25 * mBodyInfo.getHeight()) - (5 * mBodyInfo.getAge()));
        float harrisBenedict;
        if (mBodyInfo.getGender() == 1) {
            mifflinStJeor -= 5;
            harrisBenedict = (float) (88.362 + (13.397 * mBodyInfo.getWeight()) + (4.799 * mBodyInfo.getHeight()) - (5.677 * mBodyInfo.getAge()));
//            System.out.println("Mifflin: " + mifflinStJeor);
//            System.out.println("Harris: " + harrisBenedict);
        } else if (mBodyInfo.getGender() == 2) {
            mifflinStJeor -= 161;
            harrisBenedict = (float) (447.593 + (9.247 * mBodyInfo.getWeight()) + (3.098 * mBodyInfo.getHeight()) - (4.330 * mBodyInfo.getAge()));
        } else {
            mifflinStJeor = 0;
            harrisBenedict = 0;
        }
        mBMR = (int) ((int) (((mifflinStJeor + harrisBenedict) / 2)) * mWeightLossMultiplier);
    }
    public int getBMR() {
        return mBMR;
    }
    public void printBMR() {
        mBodyInfo.printBodyInformation();
        centerPrint("BRM");
        System.out.println("BMR: " + getBMR());
        System.out.println("BMR7: " + getBMR() * 7);
        printLine();
    }
}
//        Maintain Weight	1
//        Mild Weight loss	0,9224
//        Weight Loss	0,8445
//        Extreme Weight Loss	0,689