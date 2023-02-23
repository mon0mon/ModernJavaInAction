package Ch03;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class P_3_6_2 {
    public static void main(String[] args) {
        //  pg.119
        Supplier<Apple> c1 = Apple::new;
//        Supplier<Apple> c1 = () -> new Apple();
        Apple a1 = c1.get();

        //  pg.119
        Function<Integer, Apple> c2 = Apple::new;
//        Function<Integer, Apple> c2 = (weight) -> new Apple(weight);
        Apple a2 = c2.apply(110);

        //  pg.119
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);

        //  pg.120
        BiFunction<Color, Integer, Apple> c3 = Apple::new;
//        BiFunction<Color, Integer, Apple> c3 = (color, weight) -> new Apple(color, weight);
        Apple a3 = c3.apply(Color.GREEN, 110);


    }

    static class Apple {
        private int weight;
        private Color color;

        public Apple() {
        }

        public Apple(int weight) {
            this.weight = weight;
        }

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public Apple(Color color, Integer integer) {
            new Apple(integer, color);
        }
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer i : list) {
            result.add(f.apply(i));
        }

        return result;
    }
}
