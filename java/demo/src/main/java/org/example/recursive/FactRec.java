package org.example.recursive;

public class FactRec {
    public static int factRec( int value ) {
        if ( value == 0 || value == 1 ) return 1;
        return value * factRec( value - 1 );
    }
}
