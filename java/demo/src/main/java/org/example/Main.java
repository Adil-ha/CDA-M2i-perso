package org.example;


import org.example.exerciceCondition.ExerciceCondition;
import org.example.function.Function;
import org.example.matrix.Matrix;
import org.example.operator.Operator;
import org.example.readFromConsole.ReadFromConsole;
import org.example.string.StringExo;
import org.example.structure.Structure;
import org.example.structure.Structure2;
import org.example.structureIteratve.StructureIterative;
import org.example.tpVendredi.tpVendredi;
import org.example.variable.Variable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        exo 1
//        System.out.print("Entrer la taille du tableau: ");
//        int size = scanner.nextInt();
//        int[] array = new int[size];
//
//        for (int i = 0; i < size; i++) {
//            System.out.print("Entrer un nombre : ");
//            array[i] = scanner.nextInt();
//        }
//
//        System.out.println(Function.findMaxIntArray(array));

//        exo 2
//        System.out.println("Entrer la hauteur du rectangle");
//        int hauteur = scanner.nextInt();
//
//        System.out.println("Entrer la largeur du rectangle");
//        int largeur = scanner.nextInt();
//
//        Function.drawRectangle(hauteur,largeur);

//        exo 3
//        System.out.print("Entrer une phrase: ");
//        String s = scanner.nextLine();
//
//        Function.getWordsAmount(s);

//        exo 4

        System.out.print("Entrer le nombre de mots: ");
        int size = scanner.nextInt();
        String[] mots = new String[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Entrer un mots : ");
            mots[i] = scanner.next();
        }

        System.out.print("Entrer la longueur minimale: ");
        int minLength = scanner.nextInt();


        String[] motsFiltres = Function.filterWordsByLength(minLength,mots);
        for (String mot : motsFiltres) {
            System.out.println(mot);
        }
    }
}