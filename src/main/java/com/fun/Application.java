package com.fun;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

       // isPalindrome("Ah, Satan ees Natasha");
    }

    public static boolean isPalindrome(String value) {
        String s = value.replaceAll("([^A-Za-z0-9])+","").toLowerCase();
        for (int i = 0; i < s.length()/2; i++)
        {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }


}