package com.example.demo;

import java.util.HashMap;

public class Mapping {
    public static void main(String [] args){

        HashMap<Integer, String> hymns = new HashMap<>();
    hymns.put(1,"Glory Lord of all Creation");
    hymns.put(2,"Sing Praises for has Risen");
    hymns.put(3,"I'm not worthy of his grace");
    hymns.put(4,"Tears of Joy");
    hymns.put(5,"He is my Savoir");

    System.out.println(hymns.size());
hymns.replace(3, "I'm not worthy of his grace","We have Won!");

    System.out.println(hymns.get(3));
    }
}
