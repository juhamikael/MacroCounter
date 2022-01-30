# MacroCounter


# Classes
- BodyInformation
- ActivityLevel
- BMR
- CaloriesIntake
# Enums 
- CaloriesIntake_WeightLossStyle_Enum
- ActivityMultiplier

# **Class Methods**
## **1 Body Information**
``` 
BodyInformation() : CONSTRUCTOR
BodyInformation(float aWeight, float aHeight, int aGender, int aAge) : CONSTRUCTOR

setWeight(float aWeight)
setHeight(float aHeight)
setAge(int aAge)
setGender(int aGender)
void setBMI()

getWeight()
getHeight()
getAge(){
getGender()
getGender_text()
float getBMI()

void printBMI()
void printBodyInformation()

```


## **2 ActivityLevel**
``` 
ActivityLevel() : CONSTRUCTOR
ActivityLevel(float aActivity_level) : CONSTRUCTOR

setActivityLevel(ActivityMultiplier aActivity)
getActivityLevel()
printActivityLevel(
```
## **3 BMR**
```
BMR() : CONSTRUCTOR
BMR(BodyInformation aBodyInfo) : CONSTRUCTOR

setBMR()
getBMR()
printBMR()
```
## **4 CaloriesIntake**
```
CaloriesIntake(BMR aBMR, ActivityLevel aUserActivity) : CONSTRUCTOR

setCalories()
setWeightLossStyle(CaloriesIntake_WeightLossStyle_Enum aWeightlossStyle)

getWeightLossStyle()
getWeightLossMultiplier()
getCaloriesDaily()
getCaloriesWeekly()


printWeightLossStyle()
printCalories()
```

![Main Print](/images/screenshot.png)