package Ch04;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ch04_01 {
    public static void main(String[] args) {
//        //  pg.136 ~ 137
//        //  자바 7 방식
//        List<Dish> lowCaloricDishes = new ArrayList<>();
//        for (Dish dish : menu) {
//            if (dish.getCalorie() < 400) {
//                lowCaloricDishes.add(dish);
//            }
//        }
//
//        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
//            @Override
//            public int compare(Dish o1, Dish o2) {
//                return Integer.compare(o1.getCalorie(), o2.getCalorie());
//            }
//        });
//
//        List<String> lowCaloricDishesName = new ArrayList<>();
//        for (Dish dish : lowCaloricDishes) {
//            lowCaloricDishesName.add(dish.getName());
//        }
//
//        System.out.println(Arrays.toString(lowCaloricDishesName.toArray()));

//        List<String> lowCaloricDishesName = menu.stream().filter(d -> d.getCalorie() < 400)
//                .sorted(Comparator.comparing(Dish::getCalorie))
//                .map(Dish::getName)
//                .collect(Collectors.toList());
//
//
//        List<String> lowCaloricDishesNameParallel = menu.parallelStream().filter(d -> d.getCalorie() < 400)
//                .sorted(Comparator.comparing(Dish::getCalorie))
//                .map(Dish::getName)
//                .collect(Collectors.toList());
//
//        System.out.println(Arrays.toString(lowCaloricDishesName.toArray()));

        List<Integer> oddNumbers = IntStream.rangeClosed(1, 100).filter(i -> i % 2 != 0)
                .sorted().boxed().collect(Collectors.toList());
        List<Integer> evenNumbers = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0)
                .sorted().boxed().collect(Collectors.toList());

        oddNumbers.forEach(i -> System.out.print(i + "   "));

        System.out.println();
        evenNumbers.forEach(i -> System.out.print(i + "   "));
    }
}
