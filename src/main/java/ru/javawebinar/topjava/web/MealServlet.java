package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDaoByMemory;
import ru.javawebinar.topjava.dao.Dao;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private static String INSERT_OR_EDIT = "/mealForm.jsp";
    private static String LIST_MEAL = "/meals.jsp";
    private Dao<Meal> mealDao;

    public MealServlet() {
        super();
        this.mealDao = new MealDaoByMemory(MealsUtil.MEALS);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String forward = LIST_MEAL;
        String action = req.getParameter("action");

        if (action != null && action.equalsIgnoreCase("delete")) {
            log.info("delete");
            int mealId = Integer.parseInt(req.getParameter("mealId"));
            mealDao.delete(mealId);
            req.setAttribute("meals", mealDao.getAll());
        } else if (action != null && action.equalsIgnoreCase("edit")){
            int mealId = Integer.parseInt(req.getParameter("mealId"));
            Meal meal = mealDao.getById(mealId);
            forward = INSERT_OR_EDIT;
            req.setAttribute("meal", meal);
        } else if (action!= null && action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
        } else {
            log.info("getAll");
            req.setAttribute("meals", mealDao.getAll());
        }

        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Meal meal = new Meal();

        meal.setDescription(req.getParameter("description"));

        String dateTimeText = (req.getParameter("dateTime"));
        if (dateTimeText != null && !dateTimeText.isEmpty()) {
            meal.setDateTime(LocalDateTime.parse(dateTimeText));
        }

        String caloriesText = req.getParameter("calories");
        if (caloriesText != null && !caloriesText.isEmpty()) {
            meal.setCalories(Integer.parseInt(caloriesText));
        }

        String mealIdText = req.getParameter("mealId");
        if (mealIdText == null || mealIdText.isEmpty()) {
            log.info("insert");
            mealDao.add(meal);
        } else {
            log.info("edit");
            meal.setId(Integer.parseInt(mealIdText));
            mealDao.update(meal);
        }

        RequestDispatcher view = req.getRequestDispatcher(LIST_MEAL);
        req.setAttribute("meals", mealDao.getAll());
        view.forward(req, resp);
    }
}
