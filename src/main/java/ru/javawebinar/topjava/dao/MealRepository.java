package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

public interface MealRepository {

    void addMeal(Meal meal);
    void getMealById(int id);
    void updateMeal(Meal meal);
    void deleteMeal(int id);
}
