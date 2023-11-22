package org.example;


import org.example.exerciceCondition.ExerciceCondition;
import org.example.function.Function;
import org.example.matrix.Matrix;
import org.example.operator.Operator;
import org.example.poo.Product;
import org.example.readFromConsole.ReadFromConsole;
import org.example.recursive.FactRec;
import org.example.string.StringExo;
import org.example.structure.Structure;
import org.example.structure.Structure2;
import org.example.structureIteratve.StructureIterative;
import org.example.tpVendredi.tpVendredi;
import org.example.variable.Variable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product p = new Product();

        p.setId(0);
        p.setName("Iphone");
        System.out.println(p.toString());

        Product p2 = new Product(10,"Table");
        System.out.println(p2);
        System.out.println(p2.getClass());


    }
}