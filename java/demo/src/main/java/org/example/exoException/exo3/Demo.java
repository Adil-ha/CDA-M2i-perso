package org.example.exoException.exo3;

public class Demo {

    public static int[] createTab(int number){
        if (number != 5 ){
            throw new ArrayIndexOutOfBoundsException("taille tableau dépasser");
        };
        return new int[number];
    }
    public static void main(String[] args) {
        try{
            createTab(6);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }


    }
}
