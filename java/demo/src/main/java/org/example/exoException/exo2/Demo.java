package org.example.exoException.exo2;

public class Demo {

    public static int stringToInt(String string){
        return Integer.parseInt(string);
    }

    public static void main(String[] args) {
        try {
            System.out.println(stringToInt("coucou"));
        }catch(NumberFormatException e){
            System.out.println("Probleme de format "+e.getMessage());
        }
    }
}
