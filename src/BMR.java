
public class BMR {
    // BMR = Basal metabolic rate
    private int mBMR;

    private BodyInformation mBodyInfo = new BodyInformation();
    private ActivityLevel mActivityLevel = new ActivityLevel();

    public BMR() {
        mBMR = 0;
    }
    public BMR(BodyInformation aBodyInfo) {
        // Getting the basic information like Weight, height etc.
        mBodyInfo = aBodyInfo;
        // Setting MaintainWeight from CaloriesIntake_WeightLossStyle_Enum to default, which value is 1
        setBMR();
    }
    public void setBMR() {
        // Using 2 different famous equations Mifflin St. Jeor  & Harris Benedict equations
        // to calculate base BMR with given body info
        float mifflinStJeor = (float) ((10 * mBodyInfo.getWeight()) + (6.25 * mBodyInfo.getHeight()) - (5 * mBodyInfo.getAge()));
        float harrisBenedict;
        // Calculation and values for Male
        if (mBodyInfo.getGender() == 1) {
            mifflinStJeor -= 5;
            harrisBenedict = (float) (88.362 + (13.397 * mBodyInfo.getWeight()) + (4.799 * mBodyInfo.getHeight()) - (5.677 * mBodyInfo.getAge()));
//            System.out.println("Mifflin: " + mifflinStJeor);
//            System.out.println("Harris: " + harrisBenedict);
        }
        // Calculation and values for Female
        else if (mBodyInfo.getGender() == 2) {
            mifflinStJeor -= 161;
            harrisBenedict = (float) (447.593 + (9.247 * mBodyInfo.getWeight()) + (3.098 * mBodyInfo.getHeight()) - (4.330 * mBodyInfo.getAge()));
        }
        // If gender is not set, both is set to 0
        else {
            mifflinStJeor = 0;
            harrisBenedict = 0;
        }
        // Getting mean of the equations
        mBMR = (int) ((int) (((mifflinStJeor + harrisBenedict) / 2)));
    }
    public int getBMR() {
        return mBMR;
    }

    public void printBMR() {

        OwnLibrary.centerPrint("BMR");
        System.out.println("BMR: " + getBMR());
        System.out.println("BMR7: " + getBMR() * 7);
        OwnLibrary.printLine();
    }
}
