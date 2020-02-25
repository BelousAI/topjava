package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.util.List;

public class MemoryUtil {

    private static List<Meal> meals = null;

    public static List<Meal> getMeals() {
        if (meals != null) {
            return meals;
        } else {
            return meals = MealsUtil.MEALS;
        }
    }

    private List<MealTo> mealTos = MealsUtil.getTosList(meals, MealsUtil.DEFAULT_CALORIES_PER_DAY);
}
