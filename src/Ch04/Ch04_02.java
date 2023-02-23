package Ch04;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch04_02 {
    public static void main(String[] args) {
        //  pg.143
//        List<String> threeHighCaloricDishNames = Dish.menu.stream()
//                .filter(dish -> dish.getCalories() > 300)
//                .map(Dish::getName)             //  요리명 추출
//                .limit(3)                       //  선착순 세 개만 선택
//                .collect(Collectors.toList());  //  결과를 다른 리스트로 저장
//        System.out.println(threeHighCaloricDishNames);  /// 결과는 [pork, beef, chicken]

//        System.out.println(new Ch04_02().implement7ThreeHigCaloricDishNames(Dish.menu));

    }

    //  Code by me
    public List<String> implement7ThreeHigCaloricDishNames(List<Dish> menu) {
        List<String> res = new ArrayList<>();

        for (Dish dish : menu) {
            if (dish.getCalories() > 300 && res.size() < 3) {
                res.add(dish.getName());
            }
        }

        return res;
    }
}
