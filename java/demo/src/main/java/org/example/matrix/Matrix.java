package org.example.matrix;

import java.util.Scanner;

public class Matrix {


    public static void exo1() {
        int [][] array = {{45,23,34,56,30},{67,75,21,52,59},{89,34,19,19,15},{1,78,90,48,42}};
        int plusGrand = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > plusGrand){
                    plusGrand = array[i][j];
                }
            }
        }
        System.out.println(plusGrand);
    }

    public static void exo2() {
        int[][] array = new int[5][4];
        int count = 1;
        int somme = 0;
        float moyenne = 0;
        float produit = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                somme = somme + count;
                produit *= count;
                array[i][j] = count++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }
        }
        moyenne = somme/count;
        System.out.println(produit);
        System.out.println(somme);
        System.out.println(moyenne);
    }

    public static void exo3(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre de marques de véhicules : ");
        int nombreMarques = scanner.nextInt();

        System.out.print("Nombre de noms de vendeurs : ");
        int nombreVendeurs = scanner.nextInt();

        int[][] ventes = new int[nombreMarques][nombreVendeurs];

        String[] marques = new String[nombreMarques];
        for (int i = 0; i < nombreMarques; i++) {
            System.out.print("Nom de la marque " + (i + 1) + " : ");
            marques[i] = scanner.next();
        }

        String[] nomsVendeurs = new String[nombreVendeurs];
        for (int i = 0; i < nombreVendeurs; i++) {
            System.out.print("Nom du vendeur " + (i + 1) + " : ");
            nomsVendeurs[i] = scanner.next();
        }

        for (int i = 0; i < nombreMarques; i++) {
            for (int j = 0; j < nombreVendeurs; j++) {
                System.out.print("Nombre de véhicules vendus par " + nomsVendeurs[j] +
                        " pour la marque " + marques[i] + " : ");
                ventes[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nRésultats des ventes :");
        for (int i = 0; i < nombreMarques; i++) {
            System.out.println("Marque : " + marques[i]);
            for (int j = 0; j < nombreVendeurs; j++) {
                System.out.println("   " + nomsVendeurs[j] + " : " + ventes[i][j] + " véhicules vendus");
            }
            System.out.println();
        }

    }

}
