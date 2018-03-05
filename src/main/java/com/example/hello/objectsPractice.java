package com.example.hello;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.HashMap;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

@RestController
public class objectsPractice {

    @GetMapping("/readInventory")
    public HashMap<String, Item> readInventory(@RequestParam String inventory) {

        if (inventory.equals("")) {
            HashMap<String, Item> empty = new HashMap<>();

            return empty;
        }

        String[] nlSplit = inventory.split("\n");
        HashMap<String, Item> entry = new HashMap<>();

        for (int i = 0; i < nlSplit.length; i ++) {
            String[] tSplit = nlSplit[i].split("\t");

            String itemName = tSplit[0];
            Double paid = Double.parseDouble(tSplit[1]);
            Double charging = Double.parseDouble(tSplit[2]);
            Item items = new Item(itemName, paid, charging);
            entry.put(itemName, items);
        }
        return entry;
    }


    @PostMapping("/isDollarStore")
    public Boolean isDollarStore(@RequestBody HashMap<String, Item> inventory) {

        for (Item i : inventory.values()) {

            if (i.amountCharging > 1) {
                return false;
            }
        }
        return true;
    }


    @PostMapping("/arrayEquals")
    public boolean arrayEquals(@RequestParam int[] array1, @RequestParam int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i--) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    @GetMapping("/createMovie")
    public Movies createMovie(@RequestParam String title, String director, String genre, String casting) {

        String[] castMember = casting.split(", ");

        List<String> castMemberList = new ArrayList<>(Arrays.asList(castMember));

        Movies movie = new Movies(title, director, genre, castMemberList);

        System.out.println(movie);

        return movie;
    }

    @GetMapping("/FMDB")
    public ArrayList<Movies> SearchByCast(@RequestParam FMDB movies, String castmember){
        return movies.SearchByCast(castmember);
    }
    public ArrayList<Movies> SearchByDirector(@RequestParam FMDB movies, String director){
        return movies.SearchByDirector(director);
    }


}