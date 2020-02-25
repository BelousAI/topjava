package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.util.List;

public interface Dao<T> {

    void add(T meal);
    T getById(int id);
    void update(T meal);
    void delete(int id);
    List<?> getAll();
}
