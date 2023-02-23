package Ch04;

import java.util.*;
import java.util.stream.Collectors;

public class Ch04_04 {
    public static void main(String[] args) {
        //  4.4 스트림 연산
        //  pg.150
        List<String> names = Dish.menu.stream()                 //  요리 리스트에서 스트림 얻기
                .filter(dish -> dish.getCalories() > 300)       //  중간 연산
                .map(Dish::getName)                             //  중간 연산
                .limit(3)                                       //  중간 연산
                .collect(Collectors.toList());                  //  스트림을 리스트로 변환

        //  4.4.1 중간 연산
        //  pg.151
        List<String> names2 = Dish.menu.stream()
                .filter(dish -> {
                    System.out.println("filtering:" + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping:" + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(names2);

        //  4.4.2 최종연산
        //  pg.152
        Dish.menu.stream().forEach(System.out::println);
    }
}
