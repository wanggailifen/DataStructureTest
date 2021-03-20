package com.hoho;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Test1 {

    @Test
    public void test_mapfilter() {
        Stream.of(1, 2, 3, 4, 5, 6)
                .map(x -> x.toString())
                .map(x -> x + x)
                .map(x -> x + x + x)
                //                .map(x -> Integer.parseInt(x))
                .map(Integer::parseInt)
                .forEach(x -> {
                    System.out.println(x);
                });
    }

    @Test
    public void test_mapfilterreduce() {
        //var result = Stream.of(1,2,3,4,5,)
        var result = IntStream.of()
                .map(x -> x * x)
                .filter(x -> x < 20)
                .reduce(Math::max);
        //                    .orElse(0);
        //.reduce(0, Integer::min);
        System.out.println(result.isPresent());
        System.out.println(result.orElseGet(() -> 0));
    }

    int c = 0;
    int add(int a, int b) {
        System.out.println("XXXXX");
        return a + b;
    }

    public static void main(String[] args) {
        var random = new Random();
        LinkedList<String> words = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {

            var word = random.ints(97, 123)
                    .limit(12)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            words.add(word);
        }

        var hashSet = new HashSet<String>();
        var treeSet = new TreeSet<String>();

        var start = System.currentTimeMillis();
        for (var w : words) {
            hashSet.add(w);
        }
        for (var w : words) {
            hashSet.contains(w);
        }
        System.out.println("hashSet time:" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (var w : words) {
            treeSet.add(w);
        }
        for (var w : words) {
            treeSet.contains(w);
        }
        System.out.println("treeSet time:" + (System.currentTimeMillis() - start));
    }


}
