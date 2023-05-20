package com.example.demo;

import javax.script.AbstractScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;



public class CatchMe{
    public static void main(String[]args) {
        int num = 0;
        try {
            num = Integer.parseInt("13 + 3");
            String engine = String.valueOf(num);
            engine.equals(String.valueOf(num));

        } catch (NumberFormatException | NullPointerException e ) {
            System.out.println("Wrong input!");
        }
        System.out.println(num);
    }

}
