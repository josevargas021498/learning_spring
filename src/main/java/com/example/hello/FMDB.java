package com.example.hello;

import java.lang.reflect.Array;
import java.util.ArrayList;;
import com.example.hello.Movies;

public class FMDB {
    public ArrayList<Movies> fmdb;

    public FMDB(ArrayList<Movies> fmdb) {
        this.fmdb = fmdb;
    }

    public ArrayList<Movies> SearchByCast(String castMember) {
        ArrayList<Movies> result = new ArrayList<>();
        for (Movies movie : fmdb) {

            if (movie.castList.contains(castMember)){
                result.add(movie);
            }
        }
        return result;
    }

    public ArrayList<Movies> SearchByDirector(String director){
        ArrayList<Movies> result = new ArrayList<>();
        
        for (Movies movie : fmdb){

            if (movie.director.contains(director)){
                result.add(movie);
            }
        }
        return result;
    }


}