package Ch05;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quiz_05_02 {
    public static void main(String[] args) {
        // 05-02-01
        Stream.of(1,2,3,4,5)
                .map(i -> i * i)
                .forEach(System.out::println);

        //  05-02-02
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        pairs.forEach(ary -> System.out.println(Arrays.toString(ary)));

        //  05-02-03
        List<int []> paris2 = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> ((i + j) % 3) == 0)
                        .map(j -> new int[] {i, j}))
                .collect(Collectors.toList());
        paris2.forEach(ary -> System.out.println(Arrays.toString(ary)));
    }
}
