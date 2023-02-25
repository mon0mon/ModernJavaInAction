package Ch05;

import java.util.*;
import java.util.stream.Collectors;

public class Ch05_00 {
    public static void main(String[] args) {
        //  Ch05 스트림 활용
        //  pg.155
        //  데이터 컬렉션 반복을 명시적으로 관리하는 외부 반복 코드
        List<Dish> vegetarianDishes = new ArrayList<>();
        for (Dish dish : Dish.menu) {
            if (dish.isVegetarian()) {
                vegetarianDishes.add(dish);
            }
        }

        //  Ch05 스트림 활용
        //  pg.155
        //  데이터 컬렉션 반복을 내부적으로 처리
        List<Dish> vegetarianDishes2 = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
    }
}
