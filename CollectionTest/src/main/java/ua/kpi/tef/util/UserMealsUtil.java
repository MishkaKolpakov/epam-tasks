package ua.kpi.tef.util;

import ua.kpi.tef.model.UserMeal;

import ua.kpi.tef.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GKislin 31.05.2015.
 */
public class UserMealsUtil {
	public static void main(String[] args) {
		List<UserMeal> mealList = Arrays.asList(
				new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
				new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
				new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
				new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
				new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
				new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));
		for (UserMealWithExceed userMealWithExceed : getFilteredWithExceeded(mealList, LocalTime.of(7, 0),
				LocalTime.of(12, 0), 2000)) {
			System.out.println(userMealWithExceed.toString());
		}

		// .toLocalDate();
		// .toLocalTime();
	}

	public static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime,
			LocalTime endTime, int caloriesPerDay) {
		Map<LocalDate, Integer> dateColloriesMap = new HashMap<>();
		List<UserMeal> temp = new ArrayList<>();
		List<UserMealWithExceed> userMealWithExceeds = new ArrayList<>();
		for (UserMeal userMeal : mealList) {
			if (!dateColloriesMap.containsKey(LocalDate.from(userMeal.getDateTime()))) {
				dateColloriesMap.put(LocalDate.from(userMeal.getDateTime()), userMeal.getCalories());
			} else {
				dateColloriesMap.put(LocalDate.from(userMeal.getDateTime()),
						dateColloriesMap.get(LocalDate.from(userMeal.getDateTime())) + userMeal.getCalories());
			}

			if (TimeUtil.isBetween(LocalTime.from(userMeal.getDateTime()), startTime, endTime))
				temp.add(userMeal);
		}

		for (UserMeal userMeal : temp) {
			boolean exceed = true;
			if (dateColloriesMap.get(LocalDate.from(userMeal.getDateTime())) <= 2000)
				exceed = false;
			userMealWithExceeds.add(new UserMealWithExceed(userMeal.getDateTime(), userMeal.getDescription(),
					userMeal.getCalories(), exceed));
		}

		return userMealWithExceeds;
	}
}
