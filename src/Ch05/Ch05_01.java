package Ch05;

import java.util.*;
import java.util.stream.Collectors;

public class Ch05_01 {
    public static void main(String[] args) {
        //  5.1.1 필터링
        //  pg.156
            //  filter 메소드는 Predicate(boolean 반환 함수)를 인수로 받아
            //  Predicate와 일치하는 모든 요소를 포함하는 스트림을 반환
        List<Dish> vegetarianMenu = Dish.menu.stream()
                .filter(Dish::isVegetarian)     //  채식 요리인지 확인하는 메소드 참조
                .collect(Collectors.toList());
//        [french fries, rice, season fruit, pizza]

        //  5.1.2 고유 요소 필터링
        //  pg.157
        //  리스트의 모든 짝수를 선택하고 중복을 필터링
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
        //  2
        //  4
    }
}
