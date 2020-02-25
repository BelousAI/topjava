package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MealDaoByMemory implements Dao<Meal> {

    private List<Meal> meals;
    private AtomicInteger id;

    public MealDaoByMemory(List<Meal> meals) {
        this.meals = meals;
        id = new AtomicInteger(meals.size());
    }

    @Override
    public void add(Meal meal) {
        if (meal != null) {
            meal.setId(id.incrementAndGet());
            meals.add(meal);
        }
    }

    @Override
    public Meal getById(int id) {
        if (meals != null && !meals.isEmpty()) {
            for (Meal meal : meals) {
                if (meal.getId() == id) {
                    return meal;
                }
            }
        }
        return null;
    }

    @Override
    public void update(Meal meal) {
        Meal currentMeal = getById(meal.getId());
        currentMeal.setId(meal.getId());
        currentMeal.setDateTime(meal.getDateTime());
        currentMeal.setDescription(meal.getDescription());
        currentMeal.setCalories(meal.getCalories());
    }

    @Override
    public void delete(int id) {
        Meal founded = getById(id);
        if (founded != null) {
            meals.remove(founded);
        }
    }

    @Override
    public List<MealTo> getAll() {
        return MealsUtil.getTosList(meals, MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }
}
