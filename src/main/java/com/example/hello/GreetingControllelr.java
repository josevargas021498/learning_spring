package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GreetingControllelr {

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "GoodBye Cruel World!";
    }

    @GetMapping("/add")
    public int add(@RequestParam int x, @RequestParam int y) {
        return x + y;
    }


    ////////////////////////////////////SECRET
//    @GetMapping("secret/")
//    public String secret(@RequestParam(required = false) String y,
//                         @RequestParam(required = false) String n) {
//
//        System.out.println(n);
//        System.out.println(y);
//
//        if (y.equals("yes") && n == null) {
//
//            return "I Like Chocolate Cake!";
//
//        } else if (y == null && n.equals("no")) {
//
//            y.toString();
//            return "Okay, I Won't Tell You A Secret!";
//
//        } else {
//            System.out.println("It Went Straight To The Else!");
//            return "NOTHING HERE";
//        }
//    }

    public class Person {
        public String firstName;
        public String lastName;
        Person(String fn, String ln) { firstName = fn; lastName = ln; }
    }



    @GetMapping("/me")
    public Person me(@RequestParam String name) {

        Person person1 = new Person("Jose", "Vargas");
        Person person2 = new Person("Edgar", "Guzmán");


        Person person = null;

        if (name.equals("jose")) {
            person = person1;
        } else if (name.equals("edgar")) {
            person = person2;
        } else if (name == null) {
            List persons = new ArrayList();
            persons.add(person1);
            persons.add(person2);
            return (Person) persons;
        }


//        if (p1.equals("jose") && p2 == null) {
//            person = person1;
//        } else if (person2.equals("edgar") && p1 == null) {
//            person = person2;
//        } else {
//            System.out.println("Nothing To Return!");
//        }
//        return person;

        return person;
    }



}
