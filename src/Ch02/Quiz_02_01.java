package Ch02;

import java.util.*;

public class Quiz_02_01 {
    public static void main(String[] args) {
        List<Apple> inventory = List.of(new Apple(155, Color.RED),
                new Apple(130, Color.GREEN),
                new Apple(65, Color.RED),
                new Apple(50, Color.GREEN));

//        prettyPrintApple(inventory, new AppleFancyFormatter());
        prettyPrintApple(inventory, new AppleWeightFormatter());
    }

    interface AppleFormatter {
        String format(Apple apple);
    }

    static class AppleFancyFormatter implements AppleFormatter {
        @Override
        public String format(Apple apple) {
            String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
            return "A " + characteristic + " " + apple.getColor() + " apple";
        }
    }

    static class AppleWeightFormatter implements AppleFormatter{
        @Override
        public String format(Apple apple) {
            return "An apple of " + apple.getWeight() + "g";
        }
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.format(apple);
            System.out.println(output);
        }
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
