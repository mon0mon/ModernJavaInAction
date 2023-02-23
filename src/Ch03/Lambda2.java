package Ch03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lambda2 {
    private static final String path = "D:\\Study\\Programing\\JavaProjects\\Java_Study\\ModernJavaInAction\\src\\Ch03\\data.txt";

    public static void main(String[] args) throws IOException {
//        System.out.println("첫 번째 출력");
//        System.out.println(processFileInterface(BufferedReader::readLine));
////        System.out.println(processFileInterface((BufferedReader br) -> br.readLine()));
//
//        System.out.println("\n두 번째 출력");
//        System.out.println(processFileInterface((BufferedReader br) -> br.readLine() + br.readLine()));

//        List<String> listOfStrings = List.of("", "", "Hello",
//                new String(), " ", "", "   ", "World!", "JAVA");
//
//        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
//        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
//        nonEmpty.forEach(System.out::println);

        //  pg 102
//        forEach(IntStream.rangeClosed(-5, 5).boxed().collect(Collectors.toList()),
//                System.out::println);
//        forEach(IntStream.rangeClosed(-5, 5).boxed().collect(Collectors.toList()),
//                (Integer i) -> {
//                    if (i > 0) {
//                        System.out.println(i);
//                    }
//                });

//        List<Integer> l = map(Arrays.asList("lambdas", "in", "action"),
//                (String s) -> s.length());
//        l.forEach(System.out::println);

//        List<Integer> list = new ArrayList<>();
//        for (int i = 300; i < 400; i++) {
//            list.add(i);
//        }
//
//        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
//        evenNumbers.test(1000);
//
//        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 != 0;
//        oddNumbers.test(1000);

        List<String> word = List.of("Hello", "World!", "JAVA", "Programming");
        word.sort(String::compareToIgnoreCase);


    }

    //  pg 100
    //  실행 어라운드 패턴을 적용하는 네 단계의 과정
    //  첫 번째 단계
    public static String processFile() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    //  pg 100
    //  두 번째 방법
    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }

//    public static String processFile(BufferedReaderProcessor p) throws IOException {
//        return p.process();
//    }

    //  pg 100
    //  세 번째 방법
    public static String processFileInterface(BufferedReaderProcessor p) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return p.process(br);
        }
    }

    //  pg 101
    //  Predicate
    //  T 형식 객체를 사용하여 boolean 표현식이 필요한 상황에서 사용
    @FunctionalInterface
    public interface Predicate<T> {
        boolean test(T t);
    }


    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }

        return results;
    }

    //  pg 102
    @FunctionalInterface
    public interface Consumer<T> {
        void accept(T t);
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    //  pg 103
    @FunctionalInterface
    public interface Function<T, R> {
        R apply(T t);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }

    //  pg 104
    public interface IntPredicate{
        boolean test(int t);
    }

    //  pg 116
    private static boolean isValidName(String string) {
        return Character.isUpperCase(string.charAt(0));
    }
}
