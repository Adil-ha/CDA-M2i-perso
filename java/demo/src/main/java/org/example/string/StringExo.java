package org.example.string;
import java.util.Arrays;
import java.util.Scanner;

public class StringExo {
    public static void exo1(String s){

        String[] words = s.trim().split(" ");
        int wordCount = words.length;

        System.out.printf("Il y a %d mots dans la phrase.%n", wordCount, s);

    }

    public static void exo2(String word) {
        char[] newWord = word.toCharArray();
        int occurrence = 0;

        for (int i = 0; i < newWord.length - 1; i++) {
                if (newWord[i] == newWord[i + 1]) {
                    occurrence++;
                }
        }
        if (newWord.length > 1 && newWord[newWord.length - 1] == newWord[newWord.length - 2]) {
            occurrence++;
        }

        System.out.println("Occurrences: " + occurrence);
    }

    public static void exo3(String word1, String word2) {
        if (word1.length() != word2.length()) {
            System.out.println(word1 + " et " + word2 + " ne sont pas de la même longueur.");
        } else {
            char[] charArray1 = word1.toCharArray();
            char[] charArray2 = word2.toCharArray();
            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            if (Arrays.equals(charArray1, charArray2)) {
                System.out.println(word1 + " et " + word2 + " sont des anagrammes.");
            } else {
                System.out.println(word1 + " et " + word2 + " ne sont pas des anagrammes.");
            }
        }
    }

    public static boolean exo4(String word){
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void pyramide(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer un nombre?");
        int nb = scanner.nextInt();

        for (int i = 1; i <= nb; i++) {

            for (int j = 1; j <= nb - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
