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
    public ArrayList<String> lastThree (@RequestParam String array){
        String[] words = array.split("\\s");
        String[] lastThree;
        lastThree = Arrays.copyOfRange(words, words.length -3, words.length);
        ArrayList<String> list = new ArrayList<>();
        for (String w : lastThree) {
            list.add(w);
        }

        return list;
    }

    @GetMapping("/sum")
    public Integer sum (@RequestParam int[] array){
        int total = 0;
        for (int i : array) total += i;
        return total;
    }

    @GetMapping("/sumOfLonger")
    public Integer sumOfLonger (@RequestParam int[] array1, @RequestParam int[] array2){
        //If both Arrays are the same length, returns the sum of both Arrays.

        if (array1.length > array2.length) {
            return sum(array1);
        }
        else if (array1.length < array2.length) {
            return sum(array2);
        }
        else {
            return sum(array1) + sum(array2);
        }
    }

    @GetMapping("/Min")
    public ArrayList<Double> Min (@RequestParam String x) {
        // Returns the difference between each cost and the minimum cost.
        // For example, if our options were [1, 3, 3, 2, 5].
        // The minimum cost would be 1, and the differences from that;
        // minimum would be [0, 2, 2, 1, 4]

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

    @GetMapping("/hashtags")
    public ArrayList<String> hashtags (@RequestParam String tweet) {
        ArrayList<String> tags = new ArrayList<>();
        String[] words = tweet.split("\\s");
        for (String i : words) {
            if (i.contains("#")) {
                tags.add(i);
            }
        }
        return tags;
    }

    @GetMapping("/mentions")
    public ArrayList<String> mentions (@RequestParam String tweet) {
        ArrayList<String> tags = new ArrayList<>();
        String[] words = tweet.split("\\s");
        for (String i : words) {
            if (i.contains("@")) {
                tags.add(i);
            }
        }
        return tags;
    }

    @GetMapping("/parseInventorySpring")
    public ArrayList<String> parseInventorySpring (@RequestParam String Item) {
        String[] words = Item.split("\\t");
        ArrayList<String> result = new ArrayList<>();
        for(String i : words){
            result.add(i);
        }
        return result;
    }

}
