package Ch04;

public class Quiz_04_02 {
    public static void main(String[] args) {
        long count = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)             //  중간연산
                .distinct()                                     //  중간연산
                .limit(3)                                       //  중간연산
                .count();                                       // 최종연산
    }
}
