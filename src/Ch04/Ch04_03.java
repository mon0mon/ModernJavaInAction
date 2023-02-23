package Ch04;

import java.util.*;
import java.util.stream.Collectors;

public class Ch04_03 {
    public static void main(String[] args) {
        //  4.3.1 딱 한번만 탐색할 수 있다
        //  pg.146
        //  스트림은 단 한번만 소비가능
//        List<String> title = Arrays.asList("Java8", "In", "Action");
//        Stream<String> s = title.stream();
//        s.forEach(System.out::println);
//        s.forEach(System.out::println);

        //  4.3.2 외부 반복과 내부 반복
        //  pg.146
        //  예제 4-1
        //  컬렉션:for-each 루프를 이용하는 외부 반복
        List<String> names = new ArrayList<>();
        for (Dish dish : Dish.menu) {
            names.add(dish.getName());
        }

        //  4.3.2 외부 반복과 내부 반복
        //  pg.147
        //  예제 4-2
        //  컬렉션:내부적으로 숨겨졌던 반복자를 사용한 외부 반복
        List<String> names2 = new ArrayList<>();
        Iterator<Dish> iterator = Dish.menu.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            names2.add(dish.getName());
        }

        //  4.3.2. 외부 반복과 내부 반복
        //  pg.147
        //  예제 4-3
        //  스트림:내부 반복
        List<String> names3 = Dish.menu.stream().map(Dish::getName).collect(Collectors.toList());
    }
}
