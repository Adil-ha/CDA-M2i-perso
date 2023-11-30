package org.example.lambok;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class Demo {

    public static void main(String[] args) throws IOException {

        String asciiArt = FigletFont.convertOneLine("hello world");
        System.out.println(asciiArt);

        Person person =  new Person();
        System.out.println(person.toString());

        Person person1 = new Person();
        System.out.println(person1.equals(person));


    }
}
