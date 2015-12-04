package com.fun;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
       // SpringApplication.run(Application.class, args);

       // isPalindrome("Ah, Satan sees Natasha");

        String[] s = {
                "John,2",
                "Jane,3",
                "John,4",
                "Jane,5"
        };

        String res = nameCountPairs(Arrays.stream(s));
    }

    public static boolean isPalindrome(String value) {
        String s = value.replaceAll("([^A-Za-z0-9])+","").toLowerCase();
        for (int i = 0; i < s.length()/2; i++)
        {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }



    public static String nameCountPairs(String fileName) throws IOException {
        return nameCountPairs(Files.lines(Paths.get(fileName)));
    }

    public static String nameCountPairs(Stream<String> lines) {

        // of course it should be not here, but let's keep it simple
        class Tuple<T1,T2> {
            final T1 _1;
            final T2 _2;
            public Tuple(T1 _1, T2 _2) {
                this._1 = _1;
                this._2 = _2;
            }

            // equals, hashCode ..
        }

         return lines
                .map(line -> line.split(","))
                .map(line -> new Tuple<>(line[0].trim(), Integer.parseInt(line[1])))
                .collect(Collectors.groupingBy(t -> t._1,
                         Collectors.summingInt(t -> t._2)))
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + " is " + entry.getValue())
                .collect(Collectors.joining(". The total for ","The total for ","."));
    }




}