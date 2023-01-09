package Ch02;

import java.util.*;

import static Ch02.FilteringApples.Color.GREEN;
import static Ch02.FilteringApples.Color.RED;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(155, RED),
                new Apple(120, GREEN),
                new Apple(80, RED),
                new Apple(75, GREEN));

//        System.out.println(Arrays.toString(filterGreenApples(inventory).toArray()));

        //  pg 74
//        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());
//        System.out.println(Arrays.toString(redAndHeavyApples.toArray()));

        //  pg 79
        //  다섯 번째 시도
        //  익명 클래스를 이용하여 ApplePredicate를 구현하는 객체를 만드는 방법
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });

        //  pg 81
        //  여섯 번째 시도
        //  람다 표현식 사용
        List<Apple> result = filterApples(inventory, (Apple a) -> RED.equals(a.getColor()));

        //  pg 82
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<Apple> redApples2 = filter(inventory, (Apple a) -> RED.equals(a.getColor()));
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
    }

    //  pg 69
    //  첫 번째 시도 : 녹색 사과 필터링
    //  초록색 사과만을 필터링하는 filterGreenApples
    //  `거의 비슷한 코드가 반복 존재한다면 그 코드를 추상화한다.`
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        //  사과 누적 리스트
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())){
                result.add(apple);
            }
        }

        return result;
    }

    //  pg 69
    //  두 번째 시도 : 색을 파라미터화
    //  이후에 만일 무게로도 구분하게 만드는 요구사항이 추가되면...?
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    //  pg 70
    //  무게를 인수로 받아 구분하게 하는 filterApplesByWeight
    //  단순하게 새로운 메소드를 추가
    //  하지만 좋은 해결방법은 아님
    //  왜냐하면 색 필터링 코드와 대부분 중복됨 (소프트웨어 공학의 DRY 원칙 위반)
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }

        return result;
    }

    //  pg 71
    //  세 번째 시도 : 가능한 모든 속성으로 필터링
    //  실전에서 절대 절대 사용하지 말아야할 방법 (LoveData_Public 프로젝트에서 FileUploadService)
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            //  flag가 참일 경우 색비교
            //  flag가 거짓일 경우 무게비교
            if ((flag && color.equals(apple.getColor()))
                    || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }

        return result;
    }

    public interface ApplePredicate {
        boolean test (Apple apple);
    }

    static class AppleHeavyWeightPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    static class AppleGreenColorPredicate implements ApplePredicate{
        public boolean test(Apple apple) {
            return GREEN.equals(apple.getColor());
        }
    }

    static class AppleRedAndHeavyPredicate implements ApplePredicate{
        public boolean test(Apple apple) {
            return RED.equals(apple.getColor())
                && apple.getWeight() > 150;
        }
    }

    /**
     *  pg 73
     *  네 번째 시도 : 추상적 조건으로 필터링
     *  <a href="../../resource/pic-02-01.png>그림 2-1 사과를 선택하는 다양한 전략</a>
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    //  pg 82
    //  일곱 번째 시도
    //  리스트 형식으로 추상화
    public interface Predicate<T> {
        boolean test(T t);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if(p.test(e)){
                result.add(e);
            }
        }

        return result;
    }


    public enum Color {
        RED,
        GREEN
    }

    static class Apple {
        private int weight = 0;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color=" + color +
                    '}';
        }
    }
}
