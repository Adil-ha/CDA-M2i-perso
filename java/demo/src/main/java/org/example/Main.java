package org.example;


import org.example.exerciceCondition.ExerciceCondition;
import org.example.function.Function;
import org.example.matrix.Matrix;
import org.example.operator.Operator;
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

        System.out.println( "0! == " + FactRec.factRec( 0 ) );  // 1
        System.out.println( "1! == " + FactRec.factRec( 1 ) );  // 1
        System.out.println( "3! == " + FactRec.factRec( 3 ) );  // 6
        System.out.println( "5! == " + FactRec.factRec( 5 ) );  // 120
        System.out.println( "6! == " + FactRec.factRec( 6 ) );  // 720
    }
}