package org.example.exoException.exo4;

import java.util.Scanner;

public class Demo {

    public static int solde = 5000;

    public static int retirer(int montant) throws SoldeInsuffisantException {
        if (montant < 0 || montant > solde) {
            throw new SoldeInsuffisantException("Montant invalide ou solde insuffisant");
        }
        return solde -= montant;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Montant à retirer : ");
        int montant = scanner.nextInt();
        try {
            System.out.println(retirer(montant));
        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage());
        }
    }
}
