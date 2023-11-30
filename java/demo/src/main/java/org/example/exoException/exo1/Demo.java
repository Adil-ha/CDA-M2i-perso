package org.example.exoException.exo1;

public class Demo {

    public static int division(int nb1, int nb2) throws RationalException {
        if (nb2 == 0){
            throw new RationalException("Denominator cannot be zero");
        }
        return nb1/nb2;
    }

    public static void main(String[] args)  {
        try{
            division(2,2);
        }catch(RationalException e){
            System.out.println("message : " + e.getMessage());
        }
    }
}
