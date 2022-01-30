# MacroCounter


# Classes
### - BodyInformation
### - ActivityLevel
### - BMR
### - CaloriesIntake

# Enums 
### - WeightLossStyle
### - ActivityMultiplier

# **Class Methods**
## **Body Information**
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


## **ActivityLevel**
``` 
ActivityLevel() : CONSTRUCTOR
ActivityLevel(float aActivity_level) : CONSTRUCTOR

setActivityLevel(ActivityMultiplier aActivity)
getActivityLevel()
printActivityLevel(
```
## **BMR**
```
BMR() : CONSTRUCTOR
BMR(BodyInformation aBodyInfo) : CONSTRUCTOR

setBMR()
getBMR()
printBMR()
```
## **CaloriesIntake**
```
CaloriesIntake(BMR aBMR, ActivityLevel aUserActivity) : CONSTRUCTOR

setCalories()
setWeightLossStyle(WeightLossStyle aWeightlossStyle)

getWeightLossStyle()
getWeightLossMultiplier()
getCaloriesDaily()
getCaloriesWeekly()


printWeightLossStyle()
printCalories()
```

![Main Print](/images/screenshot.png)