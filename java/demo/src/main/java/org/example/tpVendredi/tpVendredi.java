package org.example.tpVendredi;

import java.util.Scanner;

public class tpVendredi {
    static Scanner scanner = new Scanner(System.in);

    public static void exoUn() {
        int [] array = {1,2,3,4,5};
        System.out.println(array[3]);
    }

    public static void exoDeux(){
        int [] array = {1,2,3,4,5,6,7,8,9,10};

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void exoTrois(){
        int [] array = {10,20,30,40,50,60,70,80};
        System.out.println("Entrer un nombre ?");
        int nb1 = scanner.nextInt();
        boolean bool = false;
        for (int i = 0; i < array.length; i++) {
            if (nb1 == array[i]){
                bool = true;
                break;
            }else{
                bool = false;
            }

        }
        if (bool==true){
            System.out.println("présent");
        }else {
            System.out.println("non present");
        }
        scanner.close();
    }

    public static void exoQuatre(){

        System.out.print("Entrez la taille du tableau : ");
        int taille = scanner.nextInt();
        int[] tableau = new int[taille];

        System.out.println("Entrez les éléments du tableau : ");
        for (int i = 0; i < taille; i++) {
            System.out.print("Élément " + (i + 1) + " : ");
            tableau[i] = scanner.nextInt();
        }

        boolean tousPairs = true;
        for (int i = 0; i < taille; i++) {
            if (tableau[i] % 2 != 0) {
                tousPairs = false;
                break;
            }
        }

        if (tousPairs) {
            System.out.println("Tous les éléments sont pairs.");
        } else {
            System.out.println("Au moins un élément est impair.");
        }

        scanner.close();

    }

    public static void exoCinq(){
        int max = 100;
        int min = 1;
        int range = max - min + 1;
        int [] array = new int [10];
        for (int i = 0; i < array.length; i++) {
            int rand = (int)(Math.random() * range) + min;
            array[i] = rand;
            System.out.println(array[i]);
        }
    }

    public static void exoSix(){
        int max = 100;
        int min = 1;
        int range = max - min + 1;
        int [] array = new int [10];
        int [] array1 = new int [10];
        int sommeArray = 0;
        int sommeArray1 = 0;
        for (int i = 0; i < array.length; i++) {
            int rand = (int)(Math.random() * range) + min;
            array[i] = rand;
            sommeArray += array[i];
        }
        for (int i = 0; i < array1.length; i++) {
            int rand = (int)(Math.random() * range) + min;
            array1[i] = rand;
            sommeArray1 += array1[i];
        }
        System.out.println("somme tableau un :  " + sommeArray );
        System.out.println("somme tableau deux :  " + sommeArray1 );
    }

    public static void exoSept(){
        int max = 100;
        int min = 1;
        int range = max - min + 1;
        int [] array = new int [10];
        int plusGrand = 0;

        for (int i = 0; i < array.length; i++) {
            int rand = (int)(Math.random() * range) + min;
            array[i] = rand;
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] > plusGrand){
                plusGrand = array[i];
            }
        }
        System.out.println(plusGrand);
    }

    public static void exoCinqUn() {
        int[] array = {2, 2, 2, 5, 2};
        int occurence = 0;
        int valeurRecherche = 2;

        for (int i = 0; i < array.length ; i++) {
            if (array[i] == valeurRecherche ) {
                occurence++;
            }
        }

        System.out.println(occurence);
    }

    public static void exoCinqDeux(){
        int[] array = {2, 2, 2, 5, 2};
        boolean bool = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i]>array[i+1]){
                bool= true;
                break;
            }
        }
        if(bool = true){
            System.out.println("tableau non trier");
        }else{
            System.out.println("tableau trier");
        }
    }

    public static void exoCinqTrois(){
        int[] tableau = {3, 7, 1, 9, 5};
        int taille = tableau.length;
        int maxEcart = 0;


        for (int i = 0; i < taille - 1; i++) {
            for (int j = i + 1; j < taille; j++) {
                int ecart = Math.abs(tableau[i] - tableau[j]);
                if (ecart > maxEcart) {
                    maxEcart = ecart;
                }
            }
        }

        System.out.println(maxEcart); ;
    }

    public static void exoCinqQuatre(){
        int[] array = {3, 7, 1, 9, 5};
        int temp = array[0];

        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        array[array.length - 1] = temp;

        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }
    }
}
