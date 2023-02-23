package Ch04;

import java.util.*;
import java.util.stream.Collectors;

public class Quiz_04_01 {
    public static void main(String[] args) {
        List<String> highCaloricDishes = new ArrayList<>();
        Iterator<Dish> iterator = Dish.menu.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();

            if (dish.getCalories() > 300) {
                highCaloricDishes.add(dish.getName());
            }
        }

        List<String> highCaloricDishes2 = Dish.menu.stream()
                .filter(dish -> dish.getCalories() < 300)
                .map(Dish::getName)
                .collect(Collectors.toList());;
    }
}
