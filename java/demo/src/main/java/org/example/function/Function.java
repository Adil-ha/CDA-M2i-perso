package org.example.function;

import java.util.ArrayList;
import java.util.Scanner;

public class Function {
    public static int findMaxIntArray(int[] intArray) {

        int plusGrand = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > plusGrand) {
                plusGrand = intArray[i];
            }
        }
        return plusGrand;
    }

    public static void drawRectangle(int hauteur, int largeur) {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (i == 0 || i == hauteur - 1 || j == 0 || j == largeur - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void getWordsAmount(String s) {
        String[] words = s.split(" ");
        int wordCount = words.length;

        System.out.printf("Il y a %d mots dans la phrase.%n", wordCount, s);
    }

    public static String[] filterWordsByLength(int minLength, String[] mots) {
        int count = 0;
        for (int i = 0; i < mots.length; i++) {
            if (mots[i].length() > minLength) {
                count++;
            }
        }

        String[] motsFiltres = new String[count];

        int index = 0;
        for (int i = 0; i < mots.length; i++) {
            if (mots[i].length() > minLength) {
                motsFiltres[index++] = mots[i];
            }
        }

        return motsFiltres;
    }

    ;

}
