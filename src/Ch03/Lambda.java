package Ch03;

import Ch02.FilteringApples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Lambda {
//    private static final String FILE = Lambda.class.getResource("./data.txt").getFile();

    private static final String path = "D:\\Study\\Programing\\JavaProjects\\Java_Study\\ModernJavaInAction\\src\\Ch03\\data.txt";
//    private static List<String> FILE;
//
//    static {
//        try {
//            FILE = Files.readAllLines(Paths.get(path));
//        } catch (IOException e) {
//            FILE.add("Hello World!");
//            FILE.add("This is Sample TEXT");
//            FILE.add("Because IOException happened :(");
//        }
//    }

    public static void main(String[] args) throws IOException {
        List<Apple> inventroy = List.of(new Apple(150, Color.GREEN),
                new Apple(125, Color.RED),
                new Apple(110, Color.GREEN),
                new Apple(80, Color.RED));

//        //  pg 89
//        Comparator<Apple> byWeight = new Comparator<Apple>() {
//            @Override
//            public int compare(Apple a1, Apple a2) {
//                return Integer.compare(a1.getWeight(), a2.getWeight());
//            }
//        };

//        //  pg 89
//        Comparator<Apple> byWeight2 = (Apple a1, Apple a2) -> Integer.compare(a1.getWeight(), a2.getWeight());

//        //  pg 91
//        //  제네릭을 이용하여서 다른 데이터타입이 오더라도 동작 가능
//        List<Apple> greenApples = filter(inventroy, (Apple a) -> Color.GREEN.equals(a.getColor()));


//        //  pg 94
//        Runnable r1 = () -> System.out.println("Hello World 1");
//
//        //  pg 94
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello World 2");
//            }
//        };
//
//        process(r1);
//        process(r2);
//        //  pg 94
//        //  직접 전달된 람다 표현식
//        process(() -> System.out.println("Hello World 3"));

        String result = processFileLimited();
        String result2 = processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }

    public static <T> List<T> filter(List<T> list, FilteringApples.Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if(p.test(e)){
                result.add(e);
            }
        }

        return result;
    }

    public static void process(Runnable r) {
        r.run();
    }

    public static String processFileLimited() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            return p.process(br);
        }
    }

    @FunctionalInterface
    interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }
}
