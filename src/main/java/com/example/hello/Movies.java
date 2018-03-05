package com.example.hello;

import java.util.List;

public class Movies {

    public String title;
    public String director;
    public String genre;
    public List<String> castList;



    public Movies(String title, String director, String genre, List<String> castList){

    this.title = title;
    this.director = director;
    this.genre = genre;
    this.castList = castList;

    }


    public String toString() {

        return String.format("TITLE: %s \n DIRECTOR: %s \n GENRE: %s \n CAST LIST: %s \n ", title, director, genre, String.join(", ", castList));

    }

}
