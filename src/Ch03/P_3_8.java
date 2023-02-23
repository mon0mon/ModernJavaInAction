package Ch03;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class P_3_8 {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>(List.of(
                new Apple(100, Color.RED),
                new Apple(80, Color.GREEN),
                new Apple(120, Color.RED),
                new Apple(30, Color.GREEN),
                new Apple(100, Color.GREEN)
        ));

        //  pg.124
        //  역정렬
//        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());

        //  pg.125
        //  Comparator 연결
//        inventory.sort(Comparator.comparing(Apple::getWeight)
//                .reversed()
//                .thenComparing(Apple::getColor));

//        System.out.println(inventory);

        //  pg.125
        //  Predicate 조합
//        Predicate<Apple> redApple = new RedApplePredicate();
//        Predicate<Apple> notRedApple = redApple.negate();
//        Predicate<Apple> redAndHeavyApple = redApple.and(apple -> apple.getWeight() > 150);
//        Predicate<Apple> redAndHeavyOrGreen = redApple.and(apple -> apple.getWeight() > 150)
//                .or(apple -> Color.GREEN.equals(apple.getColor()));

        //  pg.126
//        Function<Integer, Integer> f = x -> x + 1;
//        Function<Integer, Integer> g = x -> x * 2;
//        Function<Integer, Integer> h = f.andThen(g);
//        int result = h.apply(1);
//        System.out.println(result);
//
//        Function<Integer, Integer> h2 = f.compose(g);
//        System.out.println(h2.apply(1));

        //  pg.127
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);
        Function<String, String> transformationPipeline2 = addHeader.andThen(Letter::addFooter);
        System.out.println(transformationPipeline.apply("Main Context lambda labda"));
        System.out.println(transformationPipeline2.apply("Main Context lambda labda"));
    }

    //  pg.125
    //  Predicate 조합
    static class RedApplePredicate implements Predicate<Apple>{
        @Override
        public boolean test(Apple apple) {
            return apple.getColor().equals(Color.RED);
        }
    }

    //  pg.126
    static class Letter {
        public static String addHeader(String text) {
            return "From Raoul, Mario and Alan: " + text;
        }

        public static String addFooter(String text) {
            return text + " Kind regards";
        }

        public static String checkSpelling(String text) {
            return text.replaceAll("labda", "lambda");
        }
    }
}
