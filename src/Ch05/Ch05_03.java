package Ch05;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch05_03 {
    public static void main(String[] args) {
        //  5.3.1 스트림의 각 요소에 함수 적용하기
        //  pg.162
        //  Dish::getName을 map 메소드로 전달하여 스트림의 요리명을 추출
        List<String> dishNames = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

        //  5.3.1 스트림의 각 요소에 함수 적용하기
        //  pg.162
        //  단어를 인수로 받아 길이를 반환
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());

        //  5.3.1 스트림의 각 요소에 함수 적용하기
        //  pg.163
        //  각 요리명의 길이를 추출
        //  map 메소드를 연결(chaining)
        List<Integer> dishNameLengths = Dish.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());

        //  5.3.2 스트림 평면화
        //  pg.163
        //  distinct를 활용한 중복된 요소 필터
        List<String> words2 = Arrays.asList("Hello", "World");
        words2.stream()
                .map(word -> word.split(""))        //  map 매소드가 반환한 스트림 형식은 Stream<String[]>
                .distinct()
                .collect(Collectors.toList());      //  List<String[]> 반환

        //  5.3.2 스트림 평면화
        //  pg.164
        //  map과 Arrays.stream 활용
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

        Arrays.stream(arrayOfWords)
                .map(word -> word.split(""))        //  각 단어를 개별 문자열 배열로 변환
                .map(Arrays::stream)                //  각 배열을 별도의 스트림으로 생성
                .distinct()
                .collect(Collectors.toList());      //  List<Stream<String>> 반환

        //  5.3.2 스트림 평면화
        //  pg.164
        //  flatMap 사용
        List<String> uniqueCharacters = Arrays.stream(arrayOfWords)
                .map(word -> word.split(""))        //  각 단어를 개별 문자를 포함하는 배열로 변환
                .flatMap(Arrays::stream)            //  생성된 스트림을 하나의 스트림으로 평면화
                .distinct()
                .collect(Collectors.toList());
    }
}
