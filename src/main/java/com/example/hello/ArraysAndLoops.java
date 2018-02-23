package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.*;

@RestController
public class ArraysAndLoops {

    @GetMapping("/lastThree")
    public ArrayList<String> lastThree(@RequestParam String x) {

        String[] words = x.split("//s");
        String[] lastThree;
        lastThree = Arrays.copyOfRange(words, words.length -3, words.length);
        ArrayList<String> list = new ArrayList<>();
        for (String w : lastThree) {
            list.add(w);
        }
        return list;
    }

    @GetMapping("/Min")
    public ArrayList<Double> Min (@RequestParam String x) {
        String[] List = x.split("\\s");
        ArrayList<Double> num_list = new ArrayList<>();
        for(String num : List) {
            num_list.add(Double.parseDouble(num));
        }
        double minimum = Collections.min(num_list);
        ArrayList<Double> new_list = new ArrayList<>();
        for (double numbers: num_list) {
            new_list.add(numbers - minimum);
        } return  new_list;
    }

    @GetMapping("/sumOfLonger")
    public int sumOfLonger(@RequestParam String l1, @RequestParam String l2) {

        int sum = 0;
        
        if (l1.length() > l2.length()) {
            sum = IntStream.of(l1).sum();
        } else if (l1.length() < l2.length()) {
            sum = IntStream.of(l2).sum();
        }
        return sum;
    }



    @GetMapping("/hashtags")
    public String[] hashtags(@RequestParam String tweet) {

        String[] comment = tweet.split(" ");

        String[] hashtagsarray;

        for (String i : comment) {

                if (i.startsWith("#")) {
                    hashtagsarray = add(hashtagsarray, i);
                }
            } return hashtagsarray;
    }


    @GetMapping("/mentions")
    public String[] mentions(@RequestParam String tweet) {
        String[] at;

        String[] words = tweet.split(" ");

        for (String i : words) {
            if (i.startsWith("@")) {
                at = add(at, i);
            }
        } return at;
    }
//
//    // String -> Item
//// Return an inventory item encoded in the provided string.
//// An Item is a array of 3 elements:
////     - name
////     - price we paid
////     - price we're charging
//// The provided string seperates each of these pieces with a tab.
//    function parseInventoryString(s) {
//        var string = s.split('\t');
//        var item = [string[0], Number(string[1]), Number(string[2])];
//        return item;
//    }

    @GetMapping("/parseinv")
    public String[] parseinventory(@RequestParam String s) {

        String[] str = s.split("/t");
        String[] item = [str[0], Integer(str[1]), Integer(str[2])];

        return item;
    }

}
