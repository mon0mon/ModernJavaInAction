package Ch01;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );

//        //  pg 38
//        inventory = sortAppleTraditionalWay(inventory);
//        //  자바8을 이용한 정렬
//        inventory = sortAppleJava8Style(inventory);
//        System.out.println(Arrays.toString(inventory.toArray()));


        //  pg 52
        //  기존의 방식의 필터링
        //  특정 필터링 규칙에 맞는 메소드를 각자 설계해서 구현
//        System.out.println("Green Apples");
//        System.out.println(Arrays.toString(filterGreenApples(inventory).toArray()));
//        System.out.println("\nHeavy Apples(over 150)");
//        System.out.println(Arrays.toString(filterHeavyApples(inventory).toArray()));

//        //  pg 53
//        //  메소드를 파라미터 값으로 전달함으로 필터링 규칙이 분리 될 수 있도록 함
//        System.out.println(Arrays.toString(filterApples(inventory,
//                FilteringApples::isGreenApple).toArray()));
//        System.out.println(Arrays.toString(filterApples(inventory,
//                FilteringApples::isHeavyApple).toArray()));

        //  pg 54
        //  메소드를 전달하는 것 대신 람다로 표현하기
        //  람다 또는 익명함수
//        System.out.println(Arrays.toString(filterApples(inventory,
//                (Apple a) -> "green".equals(a.getColor())).toArray()));
//        System.out.println(Arrays.toString(filterApples(inventory,
//                (Apple a) -> 150 < a.getWeight()).toArray()));
//        System.out.println(Arrays.toString(filterApples(inventory,
//                (Apple a) -> a.getWeight() < 80 || "red".equals(a.getColor())).toArray()));

//        //  pg 59
//        //  순차 처리 코드
//        List<Apple> heavyApples = inventory.stream().filter((Apple a) -> a.getWeight() > 150)
//                .collect(toList());
//
//        //  pg 59
//        //  병렬 처리 코드
//        List<Apple> heavyApplesParallel = inventory.parallelStream().filter(
//                (Apple a) -> a.getWeight() > 150).collect(toList());

        //  pg 60
//        List<Apple> heavyApples1 = inventory.stream().filter((Apple a) -> a.getWeight() > 150)
//                .collect(toList());
//        List<Apple> heavyApples2 = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150)
//                .collect(toList());

        //  pg 61
        //  java.util.List<E>
        //  public void sort( java.util.Comparator<? super E> c )
        //  자바 8의 List 인터페이스에 선언된 디폴트 메소드 (정적 메소드인 Collections.sort를 호출)
        //  다중 상속의 개념이 일부 들어가 있음 (CPP 다이아몬드 상속 문제 참고)
//        inventory.sort();
    }

    //  pg 38
    public static List<Apple> sortAppleTraditionalWay(List<Apple> inventory) {
        Collections.sort(inventory, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });
        return inventory;
    }

    //  pg 38
    //  sortAppleTraditionalWay를 자바 8 스타일로 대체
    public static List<Apple> sortAppleJava8Style(List<Apple> inventory) {
        inventory.sort(Comparator.comparing(Apple::getWeight));
        return inventory;
    }

    //  pg 52
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    //  pg 52
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }

        return result;
    }

    //  pg 52
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    //  pg 53
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    //  pg 53
    public interface Predicate<T> {
        boolean test(T t);
    }

    //  pg 53
    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }


    private static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
