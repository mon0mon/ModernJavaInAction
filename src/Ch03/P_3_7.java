package Ch03;

import java.util.*;

public class P_3_7 {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>(List.of(
                new Apple(100, Color.RED),
                new Apple(90, Color.GREEN),
                new Apple(30, Color.RED),
                new Apple(150, Color.GREEN)
        ));

        //  pg.122
        //  1단계 코드 전달
//        inventory.sort(new AppleComparator());

        //  pg.122
        //  2단계 익명 클래스 사용
//        inventory.sort(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return Integer.compare(o1.getWeight(), o2.getWeight());
//            }
//        });

        //  pg.123
        //  3단계 람다 표현식 사용
//        inventory.sort((Apple a1, Apple a2) -> Integer.compare(a1.getWeight(), a2.getWeight()));
//        inventory.sort((a1, a2) -> Integer.compare(a1.getWeight(), a2.getWeight()));
//        inventory.sort(Comparator.comparing(apple -> apple.getWeight()));

        //  pg.123
        //  4단계 메소드 참조 사용
        inventory.sort(Comparator.comparing(Apple::getWeight));

        System.out.println(inventory);
    }

    //  pg.122
    //  1단계 코드 전달
    public static class AppleComparator implements Comparator<Apple> {

        @Override
        public int compare(Apple o1, Apple o2) {
            return Integer.compare(o1.getWeight(), o2.getWeight());
        }
    }
}
