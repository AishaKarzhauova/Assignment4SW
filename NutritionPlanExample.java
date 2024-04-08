package Assignment4SW;
import java.util.List;
import java.util.ArrayList;

class NutritionPlan {
    private int caloric_intake;
    private int[] macronutrient_ratios;
    private List<String> meal_plans;
    private String fitness_goal;
    private List<String> diet_restrictions;

    public NutritionPlan() {
        meal_plans = new ArrayList<>();
        diet_restrictions = new ArrayList<>();
    }

    public int getCaloricIntake() {
        return caloric_intake;
    }

    public void setCaloricIntake(int caloricIntake) {
        this.caloric_intake = caloricIntake;
    }

    public int[] getMacronutrientRatios() {
        return macronutrient_ratios;
    }

    public void setMacronutrientRatios(int[] macronutrientRatios) {
        this.macronutrient_ratios = macronutrientRatios;
    }

    public List<String> getMealPlans() {
        return meal_plans;
    }

    public void setMealPlans(List<String> mealPlans) {
        this.meal_plans = mealPlans;
    }

    public String getFitnessGoal() {
        return fitness_goal;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitness_goal = fitnessGoal;
    }

    public List<String> getDietaryRestrictions() {
        return diet_restrictions;
    }

    public void setDietaryRestrictions(List<String> dietaryRestrictions) {
        this.diet_restrictions = dietaryRestrictions;
    }

    @Override
    public String toString() {
        return "Nutrition Plan:\n" +
                "Caloric Intake: " + caloric_intake + " kcal\n" +
                "Macronutrient Ratios: " + macronutrient_ratios[0] + "% carbs, " + macronutrient_ratios[1] + "% proteins, " + macronutrient_ratios[2] + "% fats\n" +
                "Meal Plans: " + meal_plans + "\n" +
                "Fitness Goal: " + fitness_goal + "\n" +
                "Dietary Restrictions: " + diet_restrictions;
    }
}

interface NutritionPlanBuilder {
    void setCaloricIntake(int caloricIntake);
    void setMacronutrientRatios(int carbohydrates, int proteins, int fats);
    void setMealPlans(List<String> mealPlans);
    void setFitnessGoal(String fitnessGoal);
    void setDietaryRestrictions(List<String> dietaryRestrictions);
    NutritionPlan build();
}

class WeightLossNutritionPlanBuilder implements NutritionPlanBuilder {
    private NutritionPlan nutritionPlan;

    public WeightLossNutritionPlanBuilder() {
        nutritionPlan = new NutritionPlan();
        nutritionPlan.setFitnessGoal("weight loss");
    }

    @Override
    public void setCaloricIntake(int caloric_intake) {
        nutritionPlan.setCaloricIntake(caloric_intake);
    }

    @Override
    public void setMacronutrientRatios(int carbohydrates, int proteins, int fats) {
        nutritionPlan.setMacronutrientRatios(new int[]{carbohydrates, proteins, fats});
    }

    @Override
    public void setMealPlans(List<String> meal_plans) {
        nutritionPlan.setMealPlans(meal_plans);
    }

    @Override
    public void setFitnessGoal(String fitness_goal) {

    }

    @Override
    public void setDietaryRestrictions(List<String> diet_restrictions) {
        nutritionPlan.setDietaryRestrictions(diet_restrictions);
    }

    @Override
    public NutritionPlan build() {
        return nutritionPlan;
    }
}

class NutritionPlanDirector{
    private NutritionPlanBuilder builder;

    public NutritionPlanDirector(NutritionPlanBuilder builder){
        this.builder = builder;
    }

    public void createNutritionPlan(){
        builder.setCaloricIntake(2000);
        builder.setMacronutrientRatios(40, 30, 40);
        builder.setMealPlans(List.of("Breakfast: Rice porridge, eggs, toast", "Lunch: Grilled Salmon, salad", "Dinner: Chicken quesadilla"));
        builder.setDietaryRestrictions(List.of("no sugar", "gluten"));
    }
}

public class NutritionPlanExample {
    public static void main(String[] args){
        NutritionPlanBuilder builder = new WeightLossNutritionPlanBuilder();
        NutritionPlanDirector director = new NutritionPlanDirector(builder);
        director.createNutritionPlan();
        NutritionPlan nutritionPlan = builder.build();

        System.out.println(nutritionPlan);

        //same idea for all other fitness goals
    }
}
