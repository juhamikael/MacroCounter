# How to use in **main**

## BodyInformation
### **Required parameters:** 
1. Weight(KG) : float
2. Height(CM) : float
3. Gender : int (1 or 2) 1 is Male / 2 is Female
4. Age : int

### #Usage:

```
BodyInformation person1 = new BodyInformation(90,190,1,30);

person1.printBodyInformation();
```

### #Output:
```
-----Body Information-------
Weight: 90.0 kg
Height: 190.0 cm
BMI: 24.93
Age: 30
Gender: Male
----------------------------
```


## Activity Level
By default Activity Level is set to Light

ActivityLevel can be either 
- Light, 
- Moderate,
- Active, 
- VeryActive

### #Usage:
```
ActivityLevel person1_activity = new ActivityLevel();
person1_activity.setActivityLevel(ActivityLevelMultiplierEnum.Moderate);

person1_activity.printActivityLevel();
```

### #Output:
```
---------Activity-----------
Activity: Moderate
Activity multiplier: 1.55
----------------------------
```

## BMR
### **Required parameter**: 
***BodyInformation object*** so in this case: ***person1***

### #Usage:
```
BMR person1_BMR = new BMR(person1);

person1_BMR.printBMR();
```
### #Output:
```
------------BMR-------------
BMR: 1984
BMR7: 13888
----------------------------
```
`BMR means "Basal metabolic rate"`

## CaloriesIntake
Before calories can be calculated we need to get **BMR** and **Activity level** 

### **Required parameter**: 
- ***BMR object*** so in this case: ***person1_BMR*** and
- ***ActivityLevel object*** so in this case: ***person1_activity***

In this class, ***setWeightLossStyle*** and previously used ***setActivityLevel*** define how many calories you need to achieve your goals. By default it is set to MaintainWeight

Can be changed to 
- MaintainWeight,
- MildWeightLoss,
- WeightLoss,
- ExtremeWeightLoss

### #Usage:
```
CaloriesIntake person1_calories = new CaloriesIntake(person1_BMR,person1_activity);
person1_calories.setWeightLossStyle(CaloriesIntake_WeightLossStyle_Enum.WeightLoss);
person1_calories.setCalories();

person1_calories.printWeightLossStyle();
person1_calories.printCalories();
```

### #Output
```
--------Weight goal---------
Goal: Normal weight loss
Multiplier: 0.8445
----------------------------

---------Calories-----------
Calories Daily: 2597
Calories Weekly: 18179
----------------------------
```

With maintainWeight(***Multiplier 1***) calories would be:
- Daily: 3075
- Calories Weekly: 21526

*When other than **Maintain Meight** is used, equation is **MaintainWeight * New Multiplier*** in this case calorie deficiency result is .

```
3075 * 0.8445 = 2597
21526 * 0.8445 = 18179

3075 - 2597 = 478 kcal / day based on your activity
21526 - 18179 = 3347 kcal / weekly ----||----
```

## MacroSplit
### **Required parameter**: 
- ***CaloriesIntake Object*** so in this case: ***person1_calories***

Before it can show any info, macro split is defined by Bodytype and is needed to chosen from:
- Ectomorph:
    - Protein: 25%
    - Carbs: 55%
    - Fat: 20%
- Mesomorph:
    - Protein: 30%
    - Carbs: 40%
    - Fat: 30%
- Endomorph:
    - Protein: 35%
    - Carbs: 25%
    - Fat: 40%
### #Usage:
```
MacroSplit person1_macros = new MacroSplit(person1_calories);
person1_macros.setBodyType(MacroSplitEnum.Mesomorph);
```

### #Output
```
------Splitted Macros-------
Body type: Mesomorph
Daily calories: 2597
Protein: 30% = 194 g
Carbs: 40% = 259 g
Fat: 30% = 86 g
----------------------------
```

