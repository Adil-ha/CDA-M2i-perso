package org.example.exoException.exo4;

public class Demo {

    public static int solde = 5000;

    public static int retirer(int montant) throws SoldeInsuffisantException {
        if (montant >= solde){
            throw new SoldeInsuffisantException("Solde insuffisant");
        }
        return solde - montant;
    }
    public static void main(String[] args) {
        try{
            System.out.println(retirer(6000));
        } catch (SoldeInsuffisantException e){
            System.out.println(e.getMessage());

        }
    }
}
