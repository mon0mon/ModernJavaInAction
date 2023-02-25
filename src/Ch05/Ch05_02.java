package Ch05;

import java.util.*;
import java.util.stream.Collectors;

public class Ch05_02 {
    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
        );

        //  5.2.1 프리디케이트를 이용한 슬라이싱
        //  pg.158
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        //  5.2.1 프리디케이트를 이용한 슬라이싱
        //  TakeWhile 활용
        //  pg.159
            //  specialMenu는 이미 칼로리 순으로 정렬되어 있음
            //  따라서 320칼로리 보다 크거나 같은 요리가 나왔을 경우 반복 작업을 중단함으로 효율성을 높일 수 있음
            //  takeWhile 연산을 활용해서 처리하기
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        //  5.2.1 프리디케이트를 이용한 슬라이싱
        //  DropWhile 활용
        //  pg.159
            //  takeWhile의 반대 역할 수행
            //  320칼로리와 같거나 큰 요소만을 탐색
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());


        //  5.2.2 스트림 축소
        //  pg.159
            //  300칼로리 초과의 세 요리를 선택하여 리스트 출력
            //  정렬되지 않은 스트림에서도 limit을 사용할 수 있음
            //  출력 결과도 소스와 마찬가지인 상태로 반환 (정렬 여부)
        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());


        //  5.2.3 요소 건너뛰기
        //  pg.160
            //  처음 n개의 요소를 제외한 스트림을 반환하는 skip(n) 메소드
            //  n개 이하의 요소를 포함한 스트림에 skip(n)을 호출시 빈 스트림이 반환
        List<Dish> dishes2 = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
    }
}
