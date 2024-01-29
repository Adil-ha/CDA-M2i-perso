package org.example.exercice3;

public class Bissextile {
    public boolean isBessectile(int year){
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
